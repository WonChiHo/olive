package com.coh.service;

import java.util.Optional;

import com.coh.dao.AdminDAO;
import com.coh.vo.Admin;

public class AdminService implements MemberService{
	private AdminDAO adminDAO;
	
	public AdminService(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Admin login(String id, String pw) {
		Optional<Admin> admin = adminDAO.findById(id);
		if (!admin.isPresent())
			throw new IllegalArgumentException("id가 없습니다");
		if (!admin.get().getPw().equals(pw))
			throw new IllegalArgumentException("pw가 다릅니다");
		return admin.get();
	}

}
