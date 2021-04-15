package com.rs.fer.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.rs.fer.util.impl.DateUtil;
import com.rs.fer.util.impl.FERUtil;
import com.rs.fer.vo.LoginVO;
import com.rs.fer.vo.RegistrationVO;
import com.rs.fer.vo.ResetPasswordVO;
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
	
	@Override
	public UpdateProfileVO getUser(HttpSession session) {

		UpdateProfileVO updateProfileVO = null;

		int userId = FERUtil.getUserId(session);

		User user = repository.findById(userId).get();

		session.setAttribute("user", user);
		updateProfileVO = userUtil.getUpdateProfileVO(user);

		return updateProfileVO;
	}

	@Override
	public UpdateProfileVO nameInfo(HttpSession session) {
		UpdateProfileVO updateProfileVO = null;

		int userId = FERUtil.getUserId(session);

		User user = repository.findById(userId).get();

		session.setAttribute("user", user);
		updateProfileVO = userUtil.getUpdateProfileVO(user);

		return updateProfileVO;
	}

	@Override
	public UpdateProfileVO contactInfo(UpdateProfileVO updateProfileVO, HttpSession session) {

		User user = (User) session.getAttribute("user");

		user.setFirstName(updateProfileVO.getFirstName());
		user.setMiddleName(updateProfileVO.getMiddleName());
		user.setLastName(updateProfileVO.getLastName());

		updateProfileVO.setEmail(user.getEmail());
		updateProfileVO.setMobile(user.getMobile());

		return updateProfileVO;

	}
	@Override
	public UpdateProfileVO addressInfo(UpdateProfileVO updateProfileVO, HttpSession session) {
		User user = (User) session.getAttribute("user");

		user.setEmail(updateProfileVO.getEmail());
		user.setMobile(updateProfileVO.getMobile());
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

	@Override
	public UpdateProfileVO review(UpdateProfileVO updateProfileVO, HttpSession session) {
		User user = (User) session.getAttribute("user");

		if (user.getAddress() == null) {
			user.setAddress(new Address());
		}

		Address address = user.getAddress();

		address.setLineOne(updateProfileVO.getLineOne());
		address.setLineTwo(updateProfileVO.getLineTwo());
		address.setCity(updateProfileVO.getCity());
		address.setState(updateProfileVO.getState());
		address.setPinCode(updateProfileVO.getPinCode());
		address.setCountry(updateProfileVO.getCountry());


		return updateProfileVO;
	}
	@Override
	public boolean updateUser(HttpSession session) {
		User user = (User) session.getAttribute("user");
		try {
			repository.save(user);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}
}
