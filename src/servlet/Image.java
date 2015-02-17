package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.ImageController;
import manager.ImageManager;

/**
 * Servlet implementation class Image
 */
@WebServlet("/Image")
@MultipartConfig
public class Image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Image() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Image servlet GET");
		//Get all images yada yada
		
		RequestDispatcher rd = request.getRequestDispatcher("/html/image.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Image POST");
		
		ImageController image = new ImageController();
		
		String location = image.getImageId(ImageManager.LOCATION);
		String title = (String) request.getParameter("title");
		String password = (String) request.getParameter("password");
		System.out.println(title);
		System.out.println(password);
		Part filePart;
		
		filePart = request.getPart("image");
		// Retrieves <input type="file" name="file">
		String fileName = getFileName(filePart);
	    //File
		InputStream fileContent = filePart.getInputStream();
	    
		FileOutputStream outputStream = new FileOutputStream(new File(location));
	    
	    //Save file
		int read = 0;
		byte[] bytes = new byte[1024];
		while ((read = fileContent.read(bytes)) != -1) {
		outputStream.write(bytes, 0, read);
		}
		image.processImage(title, password, location);
	}
	private String getFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}

	

}
