package com.ljy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljy.BoardDAO;
import com.ljy.BoardVO;

@WebServlet("/BoardDeleteServlet")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardDAO boardDAO = null;
    public BoardDeleteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = Integer.parseInt(request.getParameter("idx"));
		
		BoardVO boardvo = new BoardVO();
		boardvo.setIdx(n);
		
		boardDAO = new BoardDAO();
		boardDAO.delete(boardvo);
		
		response.sendRedirect("BoardListServlet");
		
	}

}
