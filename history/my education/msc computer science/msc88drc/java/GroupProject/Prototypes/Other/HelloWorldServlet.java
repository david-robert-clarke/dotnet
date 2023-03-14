import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HelloWorldServlet extends HttpServlet
{

  /**
   * Method to receive get requests from the web server
   * (Passes them onto the doPost method)
   * @param req The HttpServletRequest which contains the information submitted via get
   * @param res A response containing the required response data for this request
   **/

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {
    doPost(req,res);  				//  Pass all GET request to the the doPost method
  }

  /**
   * Method to relieve and process Post requests from the web server
   * @param req The HttpServletRequest which contains the information submitted via post
   * @param res A response containing the required response data for this request
   **/

  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {
    res.setContentType("text/html");		//  Set the content type of the response
    PrintWriter out=res.getWriter();		//  Get a PrintWriter so that we can write text to the response
    out.println("Hello World");			//  Write Hello World
    out.close();				//  Close the PrintWriter
  }
}


