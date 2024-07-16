package com.coh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coh.dao.UserDAO;
import com.coh.service.UserService;
import com.coh.vo.User;

/**
 * Servlet implementation class Join
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;
    public JoinServlet() {
    	userService = new UserService(new UserDAO());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = userService.toUserVO(request);
			userService.join(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect("../index.jsp");
	}
	
	

}
