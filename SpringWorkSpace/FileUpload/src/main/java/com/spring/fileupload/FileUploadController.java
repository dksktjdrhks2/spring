package com.spring.fileupload;

import java.io.File;
import java.io.IOException;

import javax.swing.plaf.multi.MultiFileChooserUI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;

@Controller
public class FileUploadController {
	
	public static final String VIEW_PATH = "/WEB-INF/views/";
	
	@RequestMapping(value = {"/", "/insert_form.do"})
	public String insert_form() {
		return VIEW_PATH + "insert_form.jsp";
	}
	
	@RequestMapping("/upload.do")
	public String upload(PhotoVO vo) {
		String savePath = "c:/MyUpload";
		
		MultipartFile photo = vo.getPhoto();
		
		String filename = "no_file";
		
		// 업로드된 파일이 존재한다면...
		if(!photo.isEmpty()) {
			filename = photo.getOriginalFilename();
			
			File saveFile = new File(savePath, filename);
			
			// 경로가 없다면
			if(!saveFile.exists()) {
				saveFile.mkdirs(); // 디렉토리 생성
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
		
		return "";
	}
	
}
