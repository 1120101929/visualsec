package cn.csbit.visualsec.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.csbit.visualsec.annotation.permission.Role;
import cn.csbit.visualsec.model.User;

/**
 * 用户相关的请求
 * 
 * @author liuyimin
 *
 */
@Controller
public class UserController {

	private List<User> users = new ArrayList<>();

	public UserController() {
		users.add(new User(1L, "liuyimin", "12345", Role.SecurityManager));
		users.add(new User(2L, "admin", "admin12345", Role.SecurityManager));
		users.add(new User(3L, "csbit", "csbit", Role.SecurityManager));
	}

	@RequestMapping("/user/list")
	public String list(Map<String, Object> map) {
		map.put("users", users);
		return "user/list";
	}

	@RequestMapping("/user/{id}")
	public String show(@PathVariable Long id, Map<String, Object> map) {
		map.put("user", new User(1L, "liuyimin", "12345", Role.SecurityManager));
		return "user/show";
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String add(User user, Map<String, Object> map) {
		user.setId((long) this.users.size());
		this.users.add(user);
		return "redirect:/user/list";
	}
}
