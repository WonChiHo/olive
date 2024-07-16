package com.coh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coh.service.MembershipService;
import com.coh.vo.Coupon;
import com.coh.vo.User;

/**
 * Servlet implementation class CouponServlet
 */
@WebServlet("/user/coupon")
public class CouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MembershipService membershipService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CouponServlet() {
        super();
        this.membershipService = new MembershipService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		List<Coupon> coupons = membershipService.getCoupons(user.getIdx());
		request.setAttribute("coupons", coupons);
		request.getRequestDispatcher("../memberships/coupon.jsp").forward(request, response);
		// request.getContextPath() + "/memberships/coupon.jsp" 은 플젝명이 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
