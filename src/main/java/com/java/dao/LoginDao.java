package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.java.connect.Constant;
import com.java.model.Login;



public class LoginDao {

	private Connection getConnection() throws ClassNotFoundException {
		Connection con = null;
		Class.forName(Constant.dbDriver);
		try {
			con = DriverManager.getConnection(Constant.jdbcURL, Constant.jdbcUsername, Constant.jdbcPassword);
			if (con != null) {
				System.out.println("Connect Success");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}
   public void LoginCheck (Login login) throws SQLException {
	   try {
		   String query = "Select * From login.login where name = ? and pass = ?";
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(query);
	    st.setString(1, login.getName());
	    st.setInt(1, login.getId());
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Login a = new Login(rs.getString(1) , rs.getInt(2));
		}
		con.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
	
}
