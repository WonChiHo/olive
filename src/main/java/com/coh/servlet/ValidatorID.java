package com.coh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coh.dao.UserDAO;
import com.coh.service.UserService;

/**
 * Servlet implementation class ValidatorID
 */
@WebServlet("/validateID")
public class ValidatorID extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidatorID() {
        super();
        userService = new UserService(new UserDAO());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			userService.validateDuplication(request.getParameter("id"));
			PrintWriter out = response.getWriter();
			out.print("usable");
			request.setAttribute("validate", "pass");
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
	}

}
