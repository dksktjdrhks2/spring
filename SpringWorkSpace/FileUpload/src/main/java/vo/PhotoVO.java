package vo;

import org.springframework.web.multipart.MultipartFile;

public class PhotoVO {
	private String title; // 제목
	private MultipartFile photo; // 파일을 받기위한 클래스
	
	private String filename; // 업로드된 파일명

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
