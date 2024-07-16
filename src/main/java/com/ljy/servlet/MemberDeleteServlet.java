package com.ljy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljy.MemberDAO;
import com.ljy.MemberVO;

@WebServlet("/MemberDeleteServlet")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MemberDAO memberDAO = null;
    public MemberDeleteServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = Integer.parseInt(request.getParameter("idx"));
		
		MemberVO membervo = new MemberVO();
		membervo.setIdx(n);
		
		memberDAO = new MemberDAO();
		memberDAO.delete(membervo);
		
		response.sendRedirect("MemberListServlet");
	

	}

	

}
