package cn.weiyigeek.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Administrator
 * ˵����ʵ�� Generialͨ��httpServet�̳еĸ�д
 */

public class HttpHelloWorld extends HttpServlet {
	
	//1.get����
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<!DOCTYPE HTML><html><head><title>HttpServlet Hello World</title></head><body><h1>Hello World,HttpServlet!</h1></body></html>");
	}
	
	//2.post����
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}