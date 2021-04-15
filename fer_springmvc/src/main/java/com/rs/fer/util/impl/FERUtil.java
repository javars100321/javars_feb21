package com.rs.fer.util.impl;

import javax.servlet.http.HttpSession;

public class FERUtil {
	
	public static int getUserId(HttpSession session) {

		return Integer.parseInt(session.getAttribute("userId").toString());
	}

}
