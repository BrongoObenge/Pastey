package servlet;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PasteController;
/**
 * Servlet implementation class Paste
 */
@WebServlet("/Paste")
public class Paste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Paste() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PasteController pastey = new PasteController();
		ArrayList<model.Paste> pastes = pastey.getAllPastesLim20();

		RequestDispatcher rd  = request.getRequestDispatcher("/html/paste.jsp");
		request.setAttribute("paste", pastes);
		rd.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//try and catch 
		//on catch retry
		String title = "";
		String paste = "";
		String password = "";
		
		try{title = (String) request.getParameter("title");}catch(Exception e){}
		try{
			paste = (String) request.getParameter("paste");
			paste = paste.replaceAll("\"", "'");
			System.out.println(paste);
			}catch(Exception e){}
		try{password = (String) request.getParameter("password");}catch(Exception e){}
		
			if(request.getParameter("code") != null){				
				paste = "<pre><code>" + paste + "</pre></code>";
			}
		
	
		PasteController pastey = new PasteController();
		//Get paste ID and redirect

		String location = pastey.addPaste(title, paste, password);
//		System.out.println("Paste");
//		System.out.println(title);
//		System.out.println(paste);
//		System.out.println(password);
//		System.out.println("-----------");
//		MySqlController mysqlcon = new MySqlController();
//		TimeManager tm = new TimeManager();
//		
//		mysqlcon.addPasteQueryBuilder(title, paste, password, tm.getTimestamp());
		response.sendRedirect("./Index");
		}

}
