package guyue.hu;

import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletLife extends HttpServlet {
	
	public TestServletLife() {
		System.out.println("Constructor!");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoGet!");
	}

	@Override
	public void destroy() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("d:/testServletDestroy.txt", true);
			fw.write("destroy");
			fw.flush();			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) fw.close();				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Initialize...");
	}
	
}
