package com.wch.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wch.dao.QNADAO;

@WebServlet("/qna/qnaDelete")
public class QNADeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    QNADAO qnaDAO = null;
	
    public QNADeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 합칠때 지우기
		response.setContentType("text/html;charset=UTF-8"); // 합칠때 지우기
		
		qnaDAO = new QNADAO();
		qnaDAO.deleteQNA(Integer.parseInt(request.getParameter("idx")));
		
		response.sendRedirect("../detail/detailList?idx="+request.getParameter("item_idx"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
