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
 */
@WebServlet("/user/modify")
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifyServlet() {
    	userService = new UserService(new UserDAO());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = userService.toUserVO(request);
		userService.modifyUser(user);
		response.sendRedirect("../index.jsp");
	}
}
