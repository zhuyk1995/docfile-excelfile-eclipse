package myselfinterface.interfaceutil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 运行时注解
 * @author 作者: ZHUYAKANG
 * @createDate 创建时间：2019年5月8日 下午3:47:21
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeSex {

	// 定义性别枚举类
	enum Sex {
		Man, Woman
	}

	Sex employeeSex() default Sex.Man;
}
