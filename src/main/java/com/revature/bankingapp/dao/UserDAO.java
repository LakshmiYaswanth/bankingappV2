package com.revature.bankingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankingapp.Exeception.DBExeception;
import com.revature.bankingapp.connectionUtill.ConnectionUtil;
import com.revature.bankingapp.model.User;

public class UserDAO {
	public int insert(User user) throws DBExeception {
		Connection con =null;
		PreparedStatement pst=null;
		int row=0;
		try {
			con=ConnectionUtil.getConnection();
			String sql="insert into user ( id,name,SSN,phoneNo,email,password) values (?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1,user.getName());
			pst.setString(2,user.getSSN());
			pst.setInt(3,user.getPhoneNo());
			pst.setString(4,user.getEmail());
			pst.setString(5,user.getPassword());
		    row =pst.executeUpdate();
		}
		catch(SQLException e)
		{
			throw new  DBExeception ( "Unable to insert",e);
		}
		finally {
			ConnectionUtil.close(con, pst ,null);
		}	
		return row;
	}
	public User login(String email,String password) throws DBExeception{
	  Connection con =null;
	  PreparedStatement pst =null;
	  User user=null;
	  ResultSet rs= null;
	  try {
		  con=ConnectionUtil.getConnection();
		  String sql="select id,name,email,password from user where email=? and password =?";
		  pst=con.prepareStatement(sql);
		  pst.setString(1,email);
		  pst.setString(2,password);
		  rs=pst.executeQuery();
		  if(rs.next()) {
			  user=new User();
			  user.getId();
			  user.getName();
			  user.getEmail();
			  user.getPassword();
			  
		  }
	  }catch(SQLException e) {
			  throw new  DBExeception ( "Unable to login",e);
		  } 
		  finally {
			  ConnectionUtil.close(con, pst, rs);
		  }return user;
	  }
	public List<User> listUser() throws DBExeception{
		Connection con =null;
		PreparedStatement pst=null;
		List<User> list=null;
		ResultSet rs= null;
		try {
			con=ConnectionUtil.getConnection();
			String sql = "select id,name,SSN,phoneNo,email,password from user";
			pst=con.prepareStatement(sql);
			list= new ArrayList<User>();
			rs=pst.executeQuery();
			while(rs.next()) {
				User user= new User();
				  user.getId();
				  user.getName();
				  user.getEmail();
				  user.getPassword();
				  user.getSSN();
				  user.getPhoneNo();
				  list.add(user);
			}
		}
			catch(SQLException e) {
				throw new DBExeception("unable to list users",e);
			}
			finally{
				ConnectionUtil.close(con, pst, rs);
			}return list;
		  }
		}
	


