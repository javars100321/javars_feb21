package com.rs.fer.service;

import javax.servlet.http.HttpSession;

import com.rs.fer.entity.User;
import com.rs.fer.vo.LoginVO;
import com.rs.fer.vo.RegistrationVO;
import com.rs.fer.vo.UpdateProfileVO;

public interface UserService {

	public boolean saveUser(RegistrationVO registrationVO);

	UpdateProfileVO getUser(HttpSession session);

	UpdateProfileVO nameInfo(HttpSession session);

	UpdateProfileVO contactInfo(UpdateProfileVO updateProfileVO, HttpSession session);

	UpdateProfileVO addressInfo(UpdateProfileVO updateProfileVO,HttpSession session);

	UpdateProfileVO review(UpdateProfileVO updateProfileVO,HttpSession session);

	public boolean updateUser(HttpSession session);

}