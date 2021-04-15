package com.rs.fer.util;

import com.rs.fer.entity.User;
import com.rs.fer.vo.RegistrationVO;
import com.rs.fer.vo.UpdateProfileVO;

public interface UserUtil {
	User getUser(RegistrationVO registrationVO);
	
}
