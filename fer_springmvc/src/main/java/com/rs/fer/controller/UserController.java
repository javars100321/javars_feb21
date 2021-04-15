package com.rs.fer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rs.fer.entity.User;
import com.rs.fer.service.UserService;
import com.rs.fer.vo.AddExpenseVO;
import com.rs.fer.vo.LoginVO;
import com.rs.fer.vo.RegistrationVO;
import com.rs.fer.vo.UpdateProfileVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcome() throws IOException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}
	
	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public ModelAndView displayRegistration() throws IOException {
		return new ModelAndView("Registration");
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute RegistrationVO registrationVO) {
		ModelAndView mv = new ModelAndView();

		boolean isAdded = userService.saveUser(registrationVO);
		String nextPath = "";
		if (isAdded) {
			mv.addObject("status", "User registered successfully");
			nextPath = "Login";
		} else {
			mv.addObject("status", "User registration is failed");
			nextPath = "Registration";
		}
		
		mv.setViewName(nextPath);
		
		return mv;
	}
	
	@RequestMapping(value = { "/nameInfo" }, method = RequestMethod.POST)
	public ModelAndView nameInfo(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("NameInfo");

		HttpSession session = request.getSession();

		UpdateProfileVO updateProfileVO = userService.nameInfo(session);
		session.setAttribute("updateProfileVO", updateProfileVO);
		mv.addObject("updateProfileVO", updateProfileVO);

		return mv;
	}

	@RequestMapping(value = { "/contactInfo" }, method = RequestMethod.POST)
	public ModelAndView contactInfo(@ModelAttribute UpdateProfileVO updateProfileVO, ModelAndView modelAndView,
			HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();

		updateProfileVO = userService.contactInfo(updateProfileVO, session);

		session.setAttribute("updateProfileVO", updateProfileVO);
		modelAndView.addObject("updateProfileVO", updateProfileVO);

		modelAndView.setViewName("ContactInfo");
		return modelAndView;
	}
	@RequestMapping(value = { "/addressInfo" }, method = RequestMethod.POST)
	public ModelAndView addressInfo(@ModelAttribute UpdateProfileVO updateProfileVO, ModelAndView modelAndView,
			HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();

		updateProfileVO = userService.addressInfo(updateProfileVO, session);

		session.setAttribute("updateProfileVO", updateProfileVO);
		modelAndView.addObject("updateProfileVO", updateProfileVO);

		modelAndView.setViewName("AddressInfo");
		return modelAndView;
	}

	@RequestMapping(value = { "/review" }, method = RequestMethod.POST)
	public ModelAndView review(@ModelAttribute UpdateProfileVO updateProfileVO, ModelAndView modelAndView,
			HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();

		updateProfileVO = userService.review(updateProfileVO, session);

		session.setAttribute("updateProfileVO", updateProfileVO);
		modelAndView.addObject("updateProfileVO", updateProfileVO);

		modelAndView.setViewName("Review");
		return modelAndView;
	}
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ModelAndView updateUser(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		boolean isUpdateUser = userService.updateUser(session);

		if (isUpdateUser) {

			mv.addObject("status", "User profile Updated Successfully");

		} else {
			mv.addObject("status", "User profile update is Failed");

		}
		mv.setViewName("Status");

		return mv;
	}
}
