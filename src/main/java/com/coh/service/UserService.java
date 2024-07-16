package com.coh.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;

import com.coh.dao.UserDAO;
import com.coh.vo.User;

public class UserService implements MemberService{
	private UserDAO userDAO;
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User toUserVO(HttpServletRequest request) {
		User user = new User();
		if (request.getParameter("idx") != null)
			user.setIdx(Integer.parseInt(request.getParameter("idx")));
		user.setId(request.getParameter("id"));
		user.setPw((String)request.getAttribute("hashedPassword"));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setGender(request.getParameter("gender"));
		user.setPhone(request.getParameter("phone"));
		user.setAddress(request.getParameter("address"));
		user.setBirthday(request.getParameter("birthday"));
		return user;
	}
	
	public void join(User user) {
		validateDuplication(user.getId());
		userDAO.insertUser(user);
	}
	
	public void validateDuplication(String id) {
		userDAO.findById(id).ifPresent(m -> {throw new IllegalArgumentException("Already exists");});
	}
	
	public User getEntity(String id) {
		return userDAO.findById(id).get();
	}
	
	public User modifyUser(User user) {
		userDAO.updateUserInfo(user);
		return getEntity(user.getId());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User login(String id, String pw) {
		Optional<User> user = userDAO.findById(id);
		if (!user.isPresent())
			throw new IllegalArgumentException(id + ":no exist");
		if (!BCrypt.checkpw(pw, user.get().getPw()))
			throw new IllegalArgumentException("패스워드가 다릅니다.");
		return user.get();
	}
	
}
