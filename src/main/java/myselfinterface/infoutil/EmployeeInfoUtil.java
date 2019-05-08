package myselfinterface.infoutil;
/**
 * 运行时注解
* @author 作者: ZHUYAKANG
* @createDate 创建时间：2019年5月8日 下午3:51:12
*/

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import myselfinterface.interfaceutil.Company;
import myselfinterface.interfaceutil.EmployeeName;
import myselfinterface.interfaceutil.EmployeeSex;

public class EmployeeInfoUtil {

	public static Map getEmployeeInfo(Class<?> clazz) {
		HashMap<String, String> info = new HashMap<String, String>();
		Field[] fields = clazz.getDeclaredFields();// 获取类成员变量
		for (Field field : fields) {
			if (field.isAnnotationPresent(EmployeeName.class)) {// 判断是不是EmployeeName类型注解
				EmployeeName employeeName = field.getAnnotation(EmployeeName.class);
				info.put("employeeName", employeeName.value());// 获取注解的值
			}
			if (field.isAnnotationPresent(EmployeeSex.class)) {
				EmployeeSex employeeSex = field.getAnnotation(EmployeeSex.class);
				info.put("employeeSex", employeeSex.employeeSex().toString());
			}
			if (field.isAnnotationPresent(Company.class)) {
				Company company = field.getAnnotation(Company.class);
				info.put("company", company.id() + ":" + company.name() + ":" + company.address());
			}
		}
		return info;
	}
}
