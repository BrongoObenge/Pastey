package servlet;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PasteController;
import controller.PastebinController;

/**
 * Servlet implementation class p
 */
@WebServlet("/p")
public class p extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public p() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("paste") != null){
			PasteController pastey = new PasteController();
			ArrayList<model.Paste> paste = pastey.getPasteById(request.getParameter("paste"));
			RequestDispatcher rd = request.getRequestDispatcher("/html/p.jsp");
			request.setAttribute("paste", paste);
			rd.forward(request, response);
		}else{
			response.sendRedirect("./Paste");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = (String) request.getParameter("title");
		String content = (String) request.getParameter("content");
		
		//Send to pastebin
		PastebinController pastebin = new PastebinController();
		URL url = pastebin.pastebin(title, content);
		
		//Redirect to paste
		response.sendRedirect(url.toString());
	}

}
