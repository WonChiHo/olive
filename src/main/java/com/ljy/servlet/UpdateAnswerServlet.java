package com.ljy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljy.BoardDAO;
import com.ljy.BoardVO;


@WebServlet("/UpdateAnswer")
public class UpdateAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public UpdateAnswerServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
		
        BoardVO boardvo = new BoardVO();
        boardvo.setAnswer(request.getParameter("answer"));
        
        BoardDAO bdao = new BoardDAO();
        bdao.update(boardvo);
        
        response.setContentType("text/plain");
        response.getWriter().write("success");
	}

}
