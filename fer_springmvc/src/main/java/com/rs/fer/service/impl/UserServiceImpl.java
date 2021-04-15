package com.rs.fer.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.entity.Address;
import com.rs.fer.entity.User;
import com.rs.fer.repository.UserRepository;
import com.rs.fer.service.UserService;
import com.rs.fer.util.UserUtil;
import com.rs.fer.util.impl.FERUtil;
import com.rs.fer.vo.LoginVO;
import com.rs.fer.vo.RegistrationVO;
import com.rs.fer.vo.UpdateProfileVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserUtil userUtil;
	
	
	@Transactional
	@Override
	public boolean saveUser(RegistrationVO registrationVO) {
	
		User user = userUtil.getUser(registrationVO);
		
		try {
			repository.save(user);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
