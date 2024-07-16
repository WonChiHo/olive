package com.ljy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljy.BoardDAO;
import com.ljy.BoardVO;


@WebServlet("/BoardModifyServlet")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private BoardDAO boardDAO = null;
    public BoardModifyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO boardvo = new BoardVO();
		int n = Integer.parseInt(request.getParameter("idx"));
		boardvo.setIdx(n);
		
		boardDAO = new BoardDAO();
		BoardVO boardOne = boardDAO.selectOne(boardvo);
		
		request.setAttribute("boardvo", boardOne);
		
		RequestDispatcher rd=request.getRequestDispatcher("/admin_boardAnswer.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int n = Integer.parseInt(request.getParameter("idx"));
		
		BoardVO boardvo = new BoardVO();
		boardvo.setIdx(n);
		
		boardvo.setAnswer(request.getParameter("answer"));
		
		System.out.println(boardvo);
		
		BoardDAO bdao = new BoardDAO();
		bdao.update(boardvo);
		
		response.sendRedirect("BoardListServlet");
		
	}

}
