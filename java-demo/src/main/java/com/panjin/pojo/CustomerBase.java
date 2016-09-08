package com.panjin.pojo;

import java.io.Serializable;

/**
 * 客户信息基本类
 * @author panjin
 *
 */
public class CustomerBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8101997611135597189L;

	/**
	 * 客户id
	 */
	private long customerId;
	
	/**
	 * 客户姓名
	 */
	private String customerName;
	
	/**
	 * 联系邮箱
	 */
	private String email;
	
	/**
	 * 电话号码
	 */
	private String phone;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
