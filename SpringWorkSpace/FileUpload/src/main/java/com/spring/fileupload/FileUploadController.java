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
		
		// ���ε�� ������ �����Ѵٸ�...
		if(!photo.isEmpty()) {
			filename = photo.getOriginalFilename();
			
			File saveFile = new File(savePath, filename);
			
			// ��ΰ� ���ٸ�
			if(!saveFile.exists()) {
				saveFile.mkdirs(); // ���丮 ����
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
		
		return "";
	}
	
}
