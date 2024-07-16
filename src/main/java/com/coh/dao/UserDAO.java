package com.coh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.coh.query.Query;
import com.coh.vo.User;

public class UserDAO implements MemberRepository{
	MySQLConnector dataSource;
	
	public UserDAO() {
		dataSource = new MySQLConnector();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Optional<User> findById(String id) {
		User user = null;
		Connection conn = dataSource.getConnector();
		try (PreparedStatement pstmt = conn.prepareStatement(Query.USER_BY_ID.getQuery())){
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setIdx(rs.getInt(1));
				user.setId(rs.getString(2));
				user.setPw(rs.getString(3));
				user.setName(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setLevel(rs.getString(7));
				user.setGender(rs.getString(8));
				user.setAddress(rs.getString(9));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataSource.close();
		return Optional.ofNullable(user);
	}
	
	public void insertUser(User user) {
		Connection conn = dataSource.getConnector();
		try (PreparedStatement pstmt = conn.prepareStatement(Query.JOIN.getQuery())){
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getGender());
			pstmt.setString(7, user.getAddress());
			pstmt.setString(8, user.getBirthday());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataSource.close();
	}
	
	public void updateUserInfo(User user) {
		Connection conn = dataSource.getConnector();
		try (PreparedStatement pstmt = conn.prepareStatement(Query.UPDATE_USER.getQuery())){
			System.out.println(user);
			pstmt.setString(1, user.getPw());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getAddress());
			pstmt.setInt(6, user.getIdx());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataSource.close();
	}
	
	public void updateUserLevel(int idx, String level) {
		Connection conn = dataSource.getConnector();
		try (PreparedStatement pstmt = conn.prepareStatement(Query.UPDATE_LEVEL.getQuery())){
			pstmt.setString(1, level);
			pstmt.setInt(2, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataSource.close();
	}
	
	public List<User> findAll(){
		User user = null;
		List<User> users = new ArrayList<>();
		Connection conn = dataSource.getConnector();
		try (PreparedStatement pstmt = conn.prepareStatement(Query.FIND_ALL.getQuery())){
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setIdx(rs.getInt(1));
				user.setId(rs.getString(2));
				user.setPw(rs.getString(3));
				user.setName(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setLevel(rs.getString(7));
				user.setGender(rs.getString(8));
				user.setAddress(rs.getString(9));
				users.add(user);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataSource.close();
		return users;
	}
	
	public List<User> findByBirthdayALL() {
		User user = null;
		List<User> users = new ArrayList<>();
		Connection conn = dataSource.getConnector();
		try (PreparedStatement pstmt = conn.prepareStatement(Query.FIND_BIRTHDAY.getQuery())){
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setIdx(rs.getInt(1));
				user.setId(rs.getString(2));
				user.setPw(rs.getString(3));
				user.setName(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setLevel(rs.getString(7));
				user.setGender(rs.getString(8));
				user.setAddress(rs.getString(9));
				users.add(user);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataSource.close();
		return users;
	}
}
