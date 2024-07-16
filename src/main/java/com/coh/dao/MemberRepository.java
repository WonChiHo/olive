package com.coh.dao;

import java.util.Optional;


public interface MemberRepository {
	public <T> Optional<T> findById(String id);
}
