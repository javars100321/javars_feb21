package com.rs.fer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.bean.User;

@Repository
public interface UserRepository extends CrudRepository<com.rs.fer.bean.User, Integer>{
	
	List<User> findByUsernameAndPassword(String username, String password);
	List <User> findByUserIdAndPassword(int userId,String password);
	
}