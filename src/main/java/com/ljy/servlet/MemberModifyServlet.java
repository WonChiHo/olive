package com.ljy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljy.MemberDAO;
import com.ljy.MemberVO;

@WebServlet("/MemberModifyServlet")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberDAO memberDAO = null;
    public MemberModifyServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO membervo = new MemberVO();
		int n = Integer.parseInt(request.getParameter("idx"));
		membervo.setIdx(n);
		
		memberDAO = new MemberDAO();
		MemberVO memberOne = memberDAO.selectOne(membervo);
		
		request.setAttribute("membervo", memberOne);
		
		RequestDispatcher rd=request.getRequestDispatcher("/admin_memberModify.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int n = Integer.parseInt(request.getParameter("idx"));
		MemberVO membervo = new MemberVO();
		membervo.setIdx(n);
		
		membervo.setName(request.getParameter("name"));
		membervo.setLevel(request.getParameter("level"));
		
		System.out.println(membervo);
		
		MemberDAO mdao = new MemberDAO();
		mdao.update(membervo);
		
		response.sendRedirect("MemberListServlet");
	}

}
