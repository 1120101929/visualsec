package cn.csbit.visualsec.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.csbit.visualsec.annotation.permission.Authority;
import cn.csbit.visualsec.annotation.permission.Role;
import cn.csbit.visualsec.common.GlobalResult;
import cn.csbit.visualsec.controller.GlobalController;
import cn.csbit.visualsec.model.User;

/**
 * 权限控制的拦截器。
 * <p>
 * 该拦截器在{@link #preHandle(HttpServletRequest, HttpServletResponse, Object)}
 * 方法中对请求进行拦截。
 * </p>
 * <p>
 * 注意：该拦截器要放在拦截器栈的栈顶，作为请求的第一个拦截器。
 * </p>
 * 
 * @author liuyimin
 *
 */
public class PermissionCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 首先判断请求的是否是静态资源，对静态资源不进行拦截
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		if (uri.startsWith(contextPath + GlobalResult.staticResourcePrefix)) {// 静态资源路径以“${contextPath}/resources”开头
			return true;
		}

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		if (handlerMethod.getBeanType() == GlobalController.class) {
			return true;
		}

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {// 用户未登录，需要判断请求是否是登录请求
			if (uri.startsWith(contextPath + GlobalResult.loginPrefix)) {// 登录请求以“${contextPath}/login”开头
				return true;
			} else {// 重定向到登录页
				// response.sendRedirect(contextPath + GlobalResult.loginInput);
				// return false;
			}
		}

		user = new User(1L, "", "", Role.SecurityManager);

		// 用户已登录，需要验证用户权限
		Role userRole = user.getRole();

		Authority authority = getAuthorityAnnotation((HandlerMethod) handler);

		if (authority == null) {// 请求方法及Controller类上面都没有标注@Authority注解，则不需要进行权限控制
			return true;
		}

		Role[] roles = authority.value();
		if (isPermitted(userRole, roles)) {
			return true;
		} else {
			response.sendRedirect(contextPath + GlobalResult.permissionDenied);
			return false;
		}
	}

	/**
	 * 获得请求方法上或者Controller类上标注的@Authority注解
	 * 
	 * @param handlerMethod
	 * @return
	 */
	private Authority getAuthorityAnnotation(HandlerMethod handlerMethod) {
		Authority authority = null;
		Method method = handlerMethod.getMethod();
		Class<?> beanType = handlerMethod.getBeanType();

		if ((authority = method.getAnnotation(Authority.class)) == null) {// 请求方法上没有@Authority注解标注时，需要看Controller类上有没有@Authority注解标注
			authority = beanType.getAnnotation(Authority.class);
		}
		return authority;
	}

	/**
	 * 该用户是否有访问该请求的权限。
	 * <p>
	 * 判断方法：用户角色是否在给定的角色组中。
	 * </p>
	 * 
	 * @param userRole
	 * @param roles
	 * @return
	 */
	private boolean isPermitted(Role userRole, Role[] roles) {
		for (Role role : roles) {
			if ((userRole.value() & role.value()) != 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
