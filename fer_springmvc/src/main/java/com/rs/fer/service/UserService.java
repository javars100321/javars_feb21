package com.rs.fer.service;

import javax.servlet.http.HttpServletRequest;

import com.rs.fer.entity.User;
import com.rs.fer.vo.LoginVO;
import com.rs.fer.vo.RegistrationVO;
import com.rs.fer.vo.ResetPasswordVO;

public interface UserService {

	public boolean saveUser(RegistrationVO registrationVO);
	
	boolean resetPassword(ResetPasswordVO resetPasswordVO,HttpServletRequest request);

}