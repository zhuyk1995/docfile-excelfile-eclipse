package myselfinterface.run;

import java.util.Map;

import myselfinterface.entity.EmployeeInfo;
import myselfinterface.infoutil.EmployeeInfoUtil;

/**
* @author 作者: ZHUYAKANG
* @createDate 创建时间：2019年5月8日 下午4:02:11
*/
public class EmployeeRun {

	public static void main(String[] args) {
		Map fruitInfo = EmployeeInfoUtil.getEmployeeInfo(EmployeeInfo.class);
		System.out.println(fruitInfo);
	}
}
