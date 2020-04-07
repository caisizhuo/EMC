package cn.cai.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController
{
	@PostMapping("/user/login")
	public String userLogin(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model,HttpSession session)
	{
		if (!StringUtils.isEmpty(username) && "123456".equals(password))
		{
			session.setAttribute("loginUser", username);
			return "main";
		}
		else
		{
			model.addAttribute("errmsg", "用户名或密码错误！");
			return "index";
		}

	}
}
