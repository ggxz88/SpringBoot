package org.hdcd.domain;

import java.io.Serializable;

public class ProvinceDetail implements Serializable {

	private static final long serialVersionUID = 2365320346743119646L;
	
	private int provinceNo;
    
	private String provinceName;
	
	private int cityNo;
	
	private String city;

	public int getProvinceNo() {
		return provinceNo;
	}

	public void setProvinceNo(int provinceNo) {
		this.provinceNo = provinceNo;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public int getCityNo() {
		return cityNo;
	}

	public void setCityNo(int cityNo) {
		this.cityNo = cityNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
