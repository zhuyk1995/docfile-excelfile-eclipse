package myselfinterface.interfaceutil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 运行时注解
* @author 作者: ZHUYAKANG
* @createDate 创建时间：2019年5月8日 下午3:41:30
*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Company {

	public int id() default -1;
	
	public String name() default "";
	
	public String address() default "";
}
