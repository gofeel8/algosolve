package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product.do")
public class product extends HttpServlet{
	static List<Node> list = new ArrayList<>();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String price =req.getParameter("price");
		String desc =req.getParameter("desc");
		list.add(new Node(name,price,desc));
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.append("<html>");
		writer.append("<head>");
		writer.append("</head>");
		writer.append("<body>");
		writer.append("name :"+name+"<br>");
		writer.append("price :"+price+"<br>");
		writer.append("desc :"+desc+"<br>");
		writer.append("저장완료<br>");
		writer.append("저장 리스트 사이즈 :"+list.size()+"<br>");
		writer.append("</body>");
		writer.append("</html>");
	}
	
	static public class Node{
		String name;
		String price;
		String desc;
		public Node(String name,String price,String desc) {
			this.name = name;
			this.price = price;
			this.desc = desc;
		}
	}
	

}
