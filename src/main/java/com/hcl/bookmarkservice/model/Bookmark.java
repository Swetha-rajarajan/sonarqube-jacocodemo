package com.hcl.bookmarkservice.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bookmark {
	
	

	@Id
	private String jobid;
	private String jobrole;
	private String joblocation;
	private String companyname;
	private boolean isbookmark;
	
	//This is the pojo class of our bookmarkservice application
	public Bookmark() {
		
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getJobrole() {
		return jobrole;
	}

	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}

	public String getJoblocation() {
		return joblocation;
	}

	public void setJoblocation(String joblocation) {
		this.joblocation = joblocation;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public boolean isIsbookmark() {
		return isbookmark;
	}

	public void setIsbookmark(boolean isbookmark) {
		this.isbookmark = isbookmark;
	}
	
	@Override
	public String toString() {
		return "Bookmark [jobid=" + jobid + ", jobrole=" + jobrole + ", joblocation=" + joblocation + ", companyname="
				+ companyname + ", isbookmark=" + isbookmark + "]";
	}
	
	
	

}
