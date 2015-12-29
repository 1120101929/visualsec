package cn.csbit.visualsec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 全局Controller：不需要进行权限控制。
 * 
 * @author liuyimin
 *
 */
@Controller
public class GlobalController {
	@RequestMapping("/loginInput")
	public String loginInput() {
		return "login";
	}

	@RequestMapping("/permissionDenied")
	public String permissionDenied() {
		return "common/permissionDenied";
	}
}
