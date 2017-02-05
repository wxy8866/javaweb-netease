package com.netease.server.example.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConcurrentServlet extends HttpServlet {

	String name;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6948878379930865229L;

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		synchronized (this) {
			name = req.getParameter("username");
			PrintWriter out = resp.getWriter();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			out.println("username: " + name);
		}
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
