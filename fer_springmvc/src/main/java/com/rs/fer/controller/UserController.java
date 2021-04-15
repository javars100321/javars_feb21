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

	
}
