package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.VisitDAO;
import mycommons.MyCommons;
import vo.VisitVO;

@Controller
public class VisitController {
	
	@Autowired // Spring���� ���� �ڵ����� application�� ������ �޴´�...
	ServletContext application;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	private VisitDAO visit_dao;
	
	public VisitController(VisitDAO visit_dao) {
		// TODO Auto-generated constructor stub
		this.visit_dao = visit_dao;
	}
	
	@RequestMapping(value = {"/", "/list.do"}) // url�ߺ� ���� ( / , /list.do ��� url�� ������ �Ʒ� �޼ҵ����)
	public String list(Model model) {
		VisitVO vo = new VisitVO();
		
		List<VisitVO> list = visit_dao.selectList();
		
		model.addAttribute("list", list);
		
		return MyCommons.Visit.VIEW_PATH + "visit_list.jsp";
	}
	
	@RequestMapping("insert_form.do")
	public String insert_form() {
		return MyCommons.Visit.VIEW_PATH + "visit_insert_form.jsp";
	}
	
	@RequestMapping("/insert.do")
	public String insert(VisitVO vo, HttpServletRequest request) {
		
		String ip = request.getRemoteAddr();
		String webPath = "/resources/upload/"; // Web���...
		String savePath = application.getRealPath(webPath); // ������
		
		//Content�� �����߿� \n�� <br>�� �ٲ�
		String content = vo.getContent().replaceAll("\n", "<br>");
		vo.setContent(content);
		vo.setIp(ip);
		
		MultipartFile photo = vo.getPhoto();
		
		String filename = "no_file";
		
		// ���ε�� ������ �����Ѵٸ�...
		if(!photo.isEmpty()) {
			filename = photo.getOriginalFilename();
			
			File saveFile = new File(savePath, filename);
			
			// ��ΰ� ���ٸ�
			if(!saveFile.exists()) {
				saveFile.mkdirs(); // ���丮 ����
			}else {
				// ������ ���ϸ��� �����ϴ°�� ���� ���ε� �ð��� �ٿ��� �ߺ��� ������ �ش�...
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
			}
			
			// ���ε�� ������ MultipartResolver ��� Ŭ������ ������ �ӽ� ����ҿ� �����Ѵ�...
			// �ӽ� ������� ������ �ð��� ������ �������...���� ������ ��η� ������ �������ش�...
			try {
				photo.transferTo(saveFile);
			}catch (IOException e) {
				// TODO: handle exception
			}
		}
		
		vo.setFilename(filename);
		
		int res = visit_dao.insert(vo);
		
		return "redirect:list.do";
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody // return ���� View�� �ν��������� �ٷ� Ŭ���̾�Ʈ�� �����϶�... - Ajax�� ���� �۾�...
	public String delete(int idx) {
		int res = visit_dao.delete(idx);
		
		String result = "no"; // ���� ���н�
		if(res != 0) {
			result = "yes";
		}
		
		return result;
	}
	
	@RequestMapping("/modify_form.do")
	public String modify_form(Model model, int idx) {
		// �Ķ���ͷ� �Ѿ�� idx�� �ش��ϴ� ��ü�� �Ѱ� ���;� �Ѵ�...
		VisitVO vo = visit_dao.selectOne(idx);
		
		if(vo != null) {
			model.addAttribute("vo", vo);
		}
		
		return MyCommons.Visit.VIEW_PATH + "visit_modify_form.jsp";
	}
	
	@RequestMapping("/modify.do")
	@ResponseBody
	public String update(VisitVO vo, HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		
		String content = vo.getContent().replaceAll("\n", "<br>");
		vo.setContent(content);
		vo.setIp(ip);
		
		int res = visit_dao.update(vo);
		
		String result = "no"; // ���� ���н�
		if(res != 0) {
			result = "yes";
		}
		
		return result;
	}
	
}
