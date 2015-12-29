package cn.csbit.visualsec.annotation.permission;

/**
 * 用户角色。
 * <p>
 * 共有三种用户角色：
 * <ol>
 * <li>系统管理员：SystemManager</li>
 * <li>安全管理员：SecurityManager</li>
 * <li>安全审计员：SecurityAuditor</li>
 * </ol>
 * </p>
 * <p>
 * 系统管理员用1表示（二进制0001）；安全管理员用2表示（二进制0010）；安全审计员用4表示（二进制0100）。
 * </p>
 * <p>
 * 在{@link cn.csbit.visualsec.interceptor.PermissionCheckInterceptor}
 * 中使用时，根据当前用户角色与权限控制中指定的角色按位与的结果（0或者非0），来判断当前用户是否有访问该请求的权限。<br/>
 * All表示所有用户角色都具有访问该请求的权限。
 * </p>
 * 
 * @author liuyimin
 *
 */
public enum Role {
	/**
	 * 系统管理员
	 */
	SystemManager(1),
	/**
	 * 安全管理员
	 */
	SecurityManager(2),
	/**
	 * 安全审计员
	 */
	SecurityAuditor(4),
	/**
	 * 所有用户角色
	 */
	All(7);

	private Role(int value) {
		this.value = value;
	}

	private int value;

	public int value() {
		return this.value;
	}
}
