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
	
	// 웹 서버상에서 파일을 확인 하려면 C:에 저장되어 있는 파일은 확인 불가...
	// 웹페이지에서 업로드 된 파일을 보기 위해서는 Web경로(resources) 상에 파일을 저장해야 한다...
	
	// Web상의 절대 경로를 가져오기...
	// @Autowired - 자동주입, 자동연결
	
	@Autowired // Spring으로 부터 자동으로 application의 정보를 받는다...
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
		String webPath = "/resources/upload/"; // Web경로...
		String savePath = application.getRealPath(webPath); // 절대경로
		
		System.out.println(savePath);
		
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
		
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "input_result.jsp";
	}
	
	@RequestMapping("/insert_form2.do")
	public String insert_form2() {
		return VIEW_PATH + "insert_form2.jsp";
	}
	
	@RequestMapping("/upload2.do")
	public String upload2(PhotoVO2 vo, Model model) throws IllegalStateException, IOException {
		String webPath = "/resources/upload/"; // Web경로...
		String savePath = application.getRealPath(webPath); // 절대경로
		
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
