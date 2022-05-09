package com.voiceon.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.voiceon.domain.User;
import com.voiceon.service.AdminService;


@Controller
public class DashboardController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/dashboard")
	public String getDashBoard(@AuthenticationPrincipal User user, ModelMap model) {
		
		model.put("user", user);
		List<User> allUserAccounts = adminService.getAllUserAccounts();
		return "dashboard";
	}

}
