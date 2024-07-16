package com.ljy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljy.MemberDAO;
import com.ljy.MemberVO;


@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private MemberDAO memberDAO = null;
    public MemberListServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.memberDAO = new MemberDAO();
		
		List<MemberVO> memberList = this.memberDAO.selectList();
		
		request.setAttribute("memberList", memberList);
		
		RequestDispatcher requestDispatcher = 
				request.getRequestDispatcher("/admin_member.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

	

}
