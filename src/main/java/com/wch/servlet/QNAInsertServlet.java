package com.wch.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coh.vo.User;
import com.wch.dao.QNADAO;
import com.wch.dto.QNA;

/**
 * Servlet implementation class RankingListServlet
 */
@WebServlet("/qna/qnaInsert")
public class QNAInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QNADAO qnaDAO = null;
    public QNAInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 합칠때 지우기
		response.setContentType("text/html;charset=UTF-8"); // 합칠때 지우기	
		
		qnaDAO = new QNADAO();
		QNA qna= new QNA();
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		qna.setUser_id(user.getId()); //나중에 세션값으로 바꿈
		qna.setItem_idx(Integer.parseInt(request.getParameter("itemIdx")));
		qna.setQuestionContent(request.getParameter("qnaContent"));
		qnaDAO.insertQNA(qna);
		
		response.sendRedirect("../detail/detailList?idx="+request.getParameter("itemIdx"));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
