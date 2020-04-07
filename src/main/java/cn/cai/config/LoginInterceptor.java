package cn.cai.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class LoginInterceptor extends HandlerInterceptorAdapter
{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception
	{
		Object loginUser = request.getSession().getAttribute("loginUser");
		if (null == loginUser)
		{
			request.setAttribute("errmsg", "没有权限，请先登录！");
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		}

		return true;
	}

}
