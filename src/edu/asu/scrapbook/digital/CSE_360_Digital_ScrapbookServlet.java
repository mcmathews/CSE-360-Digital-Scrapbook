package edu.asu.scrapbook.digital;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class CSE_360_Digital_ScrapbookServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
