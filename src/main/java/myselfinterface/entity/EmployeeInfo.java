package myselfinterface.entity;

import myselfinterface.interfaceutil.Company;
import myselfinterface.interfaceutil.EmployeeName;
import myselfinterface.interfaceutil.EmployeeSex;
import myselfinterface.interfaceutil.EmployeeSex.Sex;

/**
 * 运行时注解
 * @author 作者: ZHUYAKANG
 * @createDate 创建时间：2019年5月8日 下午3:59:05
 */
public class EmployeeInfo {

	@EmployeeName("leiq")
	private String employeeName;
	@EmployeeSex(employeeSex = Sex.Man)
	private String employeeSex;
	@Company(id = 1, name = "上本集团", address = "朝阳路三号")
	private String company;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	
}
