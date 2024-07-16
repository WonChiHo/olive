package com.ljy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljy.BoardDAO;
import com.ljy.BoardVO;


@WebServlet("/BoardListServlet")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardDAO boardDAO = null;
    public BoardListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.boardDAO = new BoardDAO();
		
		List<BoardVO> boardList = this.boardDAO.selectList();
		
		request.setAttribute("boardList", boardList);
		

		RequestDispatcher rd = 
				request.getRequestDispatcher("/admin_board.jsp");
		rd.forward(request, response);
		
	}

}
