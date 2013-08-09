package com.czg.jtgl.model;

import java.util.HashSet;
import java.util.Set;

public class YpjgRegcom implements
		java.io.Serializable {

	// Fields
    private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	private String userid;
	private String comname;
	
}