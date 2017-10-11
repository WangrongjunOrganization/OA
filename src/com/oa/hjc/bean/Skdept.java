package com.oa.hjc.bean;

import java.util.Date;
import java.sql.SQLException;

import com.oa.hjc.service.UserService;
import com.oa.hjc.service.UserServiceImpl;

public class Skdept {
	 int id;     
	 String name;    
	 String type;       
	 String  tele ;      
	 String fax;       
	 String discrip;    
	 int sksuper;      
	 Date date; 
	 String explanation1; 
	 String explanation2;  
	 String explanation3;
	 
	 
	 
	 
	 public Skdept(String name, String type,  String tele, String fax, String discrip,int sksuper,Date date)
		{
			this(0,  name,  type,  tele,  fax,  discrip,sksuper,date);
		}
	
	public Skdept(int id, String name, String type, String tele, String fax,
			String discrip, int sksuper, Date date
			) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.tele = tele;
		this.fax = fax;
		this.discrip = discrip;
		this.sksuper = sksuper;
		this.date = date;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDiscrip() {
		return discrip;
	}
	public void setDiscrip(String discrip) {
		this.discrip = discrip;
	}
	public int getSksuper() {
		return sksuper;
	}
	public void setSksuper(int sksuper) {
		this.sksuper = sksuper;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getExplanation1() {
		return explanation1;
	}
	public void setExplanation1(String explanation1) {
		this.explanation1 = explanation1;
	}
	public String getExplanation2() {
		return explanation2;
	}
	public void setExplanation2(String explanation2) {
		this.explanation2 = explanation2;
	}
	public String getExplanation3() {
		return explanation3;
	}
	public void setExplanation3(String explanation3) {
		this.explanation3 = explanation3;
	}
	@Override
	public String toString() {
		return "Skdept [id=" + id + ", name=" + name + ", type=" + type
				+ ", tele=" + tele + ", fax=" + fax + ", discrip=" + discrip
				+ ", sksuper=" + sksuper + ", createtime=" + date
				+ ", explanation1=" + explanation1 + ", explanation2="
				+ explanation2 + ", explanation3=" + explanation3 + "]";
	}  
	String validateErrorMsg;
	public String getValidateErrorMsg()
	{
		return validateErrorMsg;
	}
	public boolean validate()
	{
		UserService us=UserServiceImpl.getInstance();
		if(getName()==null ||getName().equals(""))
		{
			validateErrorMsg="添加失败，用户名为空";
			System.out.println("添加失败，用户名为空");
			return false;
		}
		
		if(getFax()==null || getFax().equals(""))
		{
			validateErrorMsg="添加失败，部门为空";
			System.out.println("添加失败，部门为空");
			return false;
		}
		try {
			if(us.getUserByName1(name)!=null)
			{
				validateErrorMsg="添加失败，用户名已经存在";
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			validateErrorMsg="添加失败，用户名已经存在";
			return false;
		}
		return true;
	}
}
