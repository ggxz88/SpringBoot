package org.hdcd.domain;

import java.io.Serializable;

public class ProvinceClass implements Serializable {

	private static final long serialVersionUID = 4943281794819208944L;
	
	private int provinceNo;
    
	private String provinceName;

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
    
}
