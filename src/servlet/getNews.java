package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.News;
import service.NewsImp;
import utils.getIp;

/**
 * Servlet implementation class getNews
 */
@WebServlet("/getNews")
public class getNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key=request.getParameter("key");
		getIp gi=new getIp();
		String IP=gi.getIp(request);
		System.out.println("访问者:"+IP);
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		News news=new NewsImp();
		String jString=news.getNews(key);
		response.getWriter().write(jString);
		
	}

}
