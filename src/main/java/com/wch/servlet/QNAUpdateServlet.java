package com.wch.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wch.dao.QNADAO;

@WebServlet("/qna/qnaUpdate")
public class QNAUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QNADAO qnaDAO = null;
    public QNAUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 합칠때 지우기
		response.setContentType("text/html;charset=UTF-8"); // 합칠때 지우기
		
		qnaDAO = new QNADAO();
		int idx = Integer.parseInt(request.getParameter("qnaIdx"));
		String questionContent = request.getParameter("qnaContent");
		int item_idx = Integer.parseInt(request.getParameter("itemIdx"));
		qnaDAO.updateQNA(idx, questionContent);
		
		response.sendRedirect("../detail/detailList?idx="+item_idx);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
