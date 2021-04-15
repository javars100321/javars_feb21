package com.rs.fer.util;

import com.rs.fer.entity.User;
import com.rs.fer.vo.RegistrationVO;
import com.rs.fer.vo.ResetPasswordVO;

public interface UserUtil {
	User getUser(RegistrationVO registrationVO);
	
	ResetPasswordVO getResetPasswordVO(User user);
	
}
