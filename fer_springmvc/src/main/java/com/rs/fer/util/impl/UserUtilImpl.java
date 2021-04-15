package com.rs.fer.util.impl;

import org.springframework.stereotype.Component;


import com.rs.fer.entity.User;
import com.rs.fer.util.UserUtil;
import com.rs.fer.vo.RegistrationVO;
import com.rs.fer.vo.UpdateProfileVO;

@Component
public class UserUtilImpl implements UserUtil{

	@Override
	public User getUser(RegistrationVO registrationVO) {
		User user = new User();
		
		user.setFirstName(registrationVO.getFirstName());
		user.setMiddleName(registrationVO.getMiddleName());
		user.setLastName(registrationVO.getLastName());
		
		user.setEmail(registrationVO.getEmail());
		user.setUsername(registrationVO.getUsername());
		user.setPassword(registrationVO.getPassword());
		user.setMobile(registrationVO.getMobile());
		
		user.setCreated(DateUtil.getCurrentDate());
		
		return user;
	}
	
	@Override
	public UpdateProfileVO getUpdateProfileVO(User user) {

		UpdateProfileVO updateProfileVO = new UpdateProfileVO();

		updateProfileVO.setFirstName(user.getFirstName());
		updateProfileVO.setMiddleName(user.getMiddleName());
		updateProfileVO.setLastName(user.getLastName());

		updateProfileVO.setEmail(user.getEmail());
		updateProfileVO.setMobile(user.getMobile());

		if (user.getAddress() != null) {
			updateProfileVO.setLineOne(user.getAddress().getLineOne());
			updateProfileVO.setLineTwo(user.getAddress().getLineTwo());
			updateProfileVO.setCity(user.getAddress().getCity());
			updateProfileVO.setState(user.getAddress().getState());
			updateProfileVO.setPinCode(user.getAddress().getPinCode());
			updateProfileVO.setCountry(user.getAddress().getCountry());

		}

		return updateProfileVO;
	}
}
