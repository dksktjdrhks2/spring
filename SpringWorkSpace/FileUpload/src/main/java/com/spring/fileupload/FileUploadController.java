package com.spring.fileupload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.multi.MultiFileChooserUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;
import vo.PhotoVO2;

@Controller
public class FileUploadController {
	
	public static final String VIEW_PATH = "/WEB-INF/views/";
	
	// �� �����󿡼� ������ Ȯ�� �Ϸ��� C:�� ����Ǿ� �ִ� ������ Ȯ�� �Ұ�...
	// ������������ ���ε� �� ������ ���� ���ؼ��� Web���(resources) �� ������ �����ؾ� �Ѵ�...
	
	// Web���� ���� ��θ� ��������...
	// @Autowired - �ڵ�����, �ڵ�����
	
	@Autowired // Spring���� ���� �ڵ����� application�� ������ �޴´�...
	ServletContext application;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value = {"/", "/insert_form.do"})
	public String insert_form() {
		return VIEW_PATH + "insert_form.jsp";
	}
	
	@RequestMapping("/upload.do")
	public String upload(PhotoVO vo, Model model) {
		//String savePath = "c:/MyUpload";
		String webPath = "/resources/upload/"; // Web���...
		String savePath = application.getRealPath(webPath); // ������
		
		System.out.println(savePath);
		
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
		
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "input_result.jsp";
	}
	
	@RequestMapping("/insert_form2.do")
	public String insert_form2() {
		return VIEW_PATH + "insert_form2.jsp";
	}
	
	@RequestMapping("/upload2.do")
	public String upload2(PhotoVO2 vo, Model model) throws IllegalStateException, IOException {
		String webPath = "/resources/upload/"; // Web���...
		String savePath = application.getRealPath(webPath); // ������
		
		MultipartFile[] photo_array = vo.getPhoto();
		
		for(int i = 0; i < photo_array.length; i++) {
			MultipartFile photo = photo_array[i];
			
			String filename = "no_file";
			
			if(!photo.isEmpty()) {
				filename = photo.getOriginalFilename();
				
				File saveFile = new File(savePath, filename);
				
				if(!saveFile.exists()) {
					saveFile.mkdirs();
				}else {
					long time = System.currentTimeMillis();
					filename = String.format("%d_%s", time, filename);
					saveFile = new File(savePath, filename);
				}
				
				photo.transferTo(saveFile);
			}
			
			if(i == 0) {
				vo.setFilename1(filename);
			}else if(i == 1) {
				vo.setFilename2(filename);
			}
		}
		
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "input_result2.jsp";
	}
	
}
