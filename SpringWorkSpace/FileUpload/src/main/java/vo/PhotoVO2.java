package vo;

import org.springframework.web.multipart.MultipartFile;

public class PhotoVO2 {
	
	// filename도 배열로 해도 된다...귀찮음.
	
	private String title; // 제목
	
	private MultipartFile[] photo; // 파일을 받기위한 클래스
	
	private String filename1, filename2; // 업로드된 파일명

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile[] getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile[] photo) {
		this.photo = photo;
	}

	public String getFilename1() {
		return filename1;
	}

	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}

	public String getFilename2() {
		return filename2;
	}

	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}

	
}
