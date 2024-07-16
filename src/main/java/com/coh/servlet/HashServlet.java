package com.coh.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class HashServlet
 */
@WebServlet("/hashPassword/*")
public class HashServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HashServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("pw");
		String action = request.getPathInfo(); // 앞에 /를 뺀 url pattern이름이 들어온다.
//		System.out.println(action);
		String path = "/index.jsp";
		if(password != null && !password.isEmpty()) {
			String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
			request.setAttribute("hashedPassword", URLDecoder.decode(hashedPassword, StandardCharsets.UTF_8));
		}
		
		if (action.equals("/join.do"))
			path = "../join";
		if (action.equals("/update.do"))
			path = "../user/modify";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
