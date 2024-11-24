package com.java.controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.LoginDao;
import com.java.model.Login;





public class LoginControler extends HttpServlet {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginDao logindao;
	public void init() {
		logindao = new LoginDao();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   try {
		resp.setContentType("text/html;");
		String name = req.getParameter("name");
		int id = Integer.parseInt(req.getParameter("id"));
		Login login = new Login(name,id);
	    logindao.LoginCheck(login);
	    if (name == null) {
	    	resp.sendRedirect("WEB-INF/view/login.jsp");
	    }else {
	    	resp.sendRedirect("WEB-INF/view/index.jsp");
	    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				}
	
	
}
