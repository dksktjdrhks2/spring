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
	
	@Autowired // Spring으로 부터 자동으로 application의 정보를 받는다...
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
	
	@RequestMapping(value = {"/", "/list.do"}) // url중복 매핑 ( / , /list.do 라는 url이 들어오면 아래 메소드실행)
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
		String webPath = "/resources/upload/"; // Web경로...
		String savePath = application.getRealPath(webPath); // 절대경로
		
		//Content의 내용중에 \n을 <br>로 바꿈
		String content = vo.getContent().replaceAll("\n", "<br>");
		vo.setContent(content);
		vo.setIp(ip);
		
		MultipartFile photo = vo.getPhoto();
		
		String filename = "no_file";
		
		// 업로드된 파일이 존재한다면...
		if(!photo.isEmpty()) {
			filename = photo.getOriginalFilename();
			
			File saveFile = new File(savePath, filename);
			
			// 경로가 없다면
			if(!saveFile.exists()) {
				saveFile.mkdirs(); // 디렉토리 생성
			}else {
				// 동일한 파일명이 존재하는경우 현재 업로드 시간을 붙여서 중복을 방지해 준다...
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
			}
			
			// 업로드된 파일은 MultipartResolver 라는 클래스가 지정한 임시 저장소에 저장한다...
			// 임시 저장소의 파일은 시간이 지나면 사라진다...내가 지정한 경로로 파일을 복사해준다...
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
	@ResponseBody // return 값을 View로 인식하지말고 바로 클라이언트로 응답하라... - Ajax를 위한 작업...
	public String delete(int idx) {
		int res = visit_dao.delete(idx);
		
		String result = "no"; // 삭제 실패시
		if(res != 0) {
			result = "yes";
		}
		
		return result;
	}
	
	@RequestMapping("/modify_form.do")
	public String modify_form(Model model, int idx) {
		// 파라미터로 넘어온 idx에 해당하는 객체를 한개 얻어와야 한다...
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
		
		String result = "no"; // 수정 실패시
		if(res != 0) {
			result = "yes";
		}
		
		return result;
	}
	
}
