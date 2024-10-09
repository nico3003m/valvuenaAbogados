
package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "svLogin", urlPatterns = {"/svLogin"})
public class svLogin extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tempEmail = "j.morenoSanchez@valvuenaAbogados.com";
        String tempPassword ="123456";
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if (tempEmail.equalsIgnoreCase(email) && tempPassword.equals(password)) {
               response.sendRedirect("index.jsp");
        }else{
            response.sendRedirect("login.jsp");
        }
       
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
