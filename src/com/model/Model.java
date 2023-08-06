package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model {
	private int accno;
	private String name;
	private String pass;
	private String email;
	private int balance;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	//connecting with DB
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String pwd="system";

	PreparedStatement pst=null;
	ResultSet rs=null;
	Connection con=null;

	public Model()
	{
		super();
		try {
			//loading driver
			Class.forName(driver);
			//establishing the connection
			con=DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	public boolean login() {
		try {
			String sql="select * from bank where accno=? and pass=?";
			//creating medium
			pst=con.prepareStatement(sql);
			
			//setting the values
			pst.setInt(1, accno);
			pst.setString(2, pass);
			
			//executing the query
			rs=pst.executeQuery();
			
			//fetch the data
			if(rs.next()==true)
			{
				accno=rs.getInt(1);
				name=rs.getString(2);
				pass=rs.getString(3);
				email=rs.getString(4);
				balance=rs.getInt(5);
				
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean register() {
		try {
			String sql="insert into bank values(?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setInt(1, accno);
			pst.setString(2, name);
			pst.setString(3, pass);
			pst.setString(4, email);
			pst.setInt(5, balance);
			
			int row=pst.executeUpdate();
			if(row==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean viewBalance() {
		try {
			String sql="select balance from bank where accno=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, accno);
			rs=pst.executeQuery();
			if(rs.next()==true)
			{
				balance= rs.getInt("balance");
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean changePwd(String np) {
		try {
			String sql="update bank set pass=? where accno=? and pass=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, accno);
			pst.setString(3, pass);
			
			int row=pst.executeUpdate();
			if(row==0)
			{
				return false;
			}
			else{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean changeName(String nn) {
		try {
			String sql="update bank set name=? where accno=? and name=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, nn);
			pst.setInt(2,accno);
			pst.setString(3, name);
			
			int row=pst.executeUpdate();
			if(row==0){
				return false;
			}
			else
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean transfer(int amount, int taccno) {
		try {
			String sql1 = "update bank set balance = balance-? where accno=?";
			pst=con.prepareStatement(sql1);
			pst.setInt(1, amount);
			pst.setInt(2, accno);
			int row1 = pst.executeUpdate();
			
			String sql2 = "update bank set balance = balance+? where accno=?";
			pst=con.prepareStatement(sql2);
			pst.setInt(1, amount);
			pst.setInt(2, taccno);
			int row2 = pst.executeUpdate();
			
			if(row1==0 || row2==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean forgotPwd(String np) {
		try {
			String sql="update bank set pass= ? where accno=? and name=? and email=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, accno);
			pst.setString(3, name);
			pst.setString(4, email);
			int row=pst.executeUpdate();
			if(row==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
