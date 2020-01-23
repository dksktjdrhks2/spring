package board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.boardDAO.BoardDAO;
import board.boardDTO.BoardDTO;
import util.Action;

public class CheckWriteAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDTO dto = new BoardDTO();
		
		//MultipartRequest ��ü ����.....
		String realPath = request.getServletContext().getRealPath("/Storage");
		
		MultipartRequest mr = new MultipartRequest(request, realPath, 1024*1024*10, "UTF-8", 
				new DefaultFileRenamePolicy());
		
		//1. request
		//2. ������ ������ ���� ���... ��, ���� ��θ� ���� �Ѵ�.
		//3. ������ ũ�� - Byte������ �ۼ�...
		//4. ���ڵ� ���� ------------------------ ��������� �ʼ�
		//5. ����� ���� ���� Ŭ���� - ���û���.
		
		dto.setId(mr.getParameter("id"));
		dto.setTitle(mr.getParameter("title"));
		dto.setContent(mr.getParameter("content"));
		
		//������ getParameter�� ���� ������ ����...
		
		//mr.getFilesystemName(arg0)	- ���� ����� ���ϸ�
		//mr.getOriginalFileName(arg0)	- ���۵� ���ϸ�
		
		String file1 = mr.getOriginalFileName("filename");
		String file2 = mr.getFilesystemName("filename");
		String file3 = mr.getParameter("filename");
		
		System.out.println(file1 + "\t" + file2 + "\t" + file3);
		
		dto.setFilename(file2);
		
		boolean check = BoardDAO.getInstance().write(dto);
		
		request.setAttribute("check", check);
		request.setAttribute("status", "write");
		request.setAttribute("url", "/MyHome/BoardList.brd");
		
	}
	
}
