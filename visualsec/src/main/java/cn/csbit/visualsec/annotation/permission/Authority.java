package cn.csbit.visualsec.annotation.permission;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限控制的注解。
 * 
 * <p>
 * 在需要做权限控制的类和（或）方法上标注该注解以实现权限控制。该注解可以标注于类和（或）方法上。当方法及其类上同时标注有该注解时，方法上的注解其作用。
 * </p>
 * <p>
 * 在{@link cn.csbit.visualsec.interceptor.PermissionCheckInterceptor}拦截器中使用
 * </p>
 * 
 * @author liuyimin
 *
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Authority {
	/**
	 * 允许访问该类和（或）方法的用户角色
	 * 
	 * @return
	 */
	Role[] value() default { Role.All };
}
