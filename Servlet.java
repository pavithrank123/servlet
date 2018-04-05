/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

/**
 *
 * @author pavithran
 */
    import java.io.IOException;  
    import java.io.PrintWriter;  
    import javax.servlet.RequestDispatcher;  
    import javax.servlet.ServletException;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
      
      
    public class Servlet extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
      
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
              
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass");  
              
        if(LoginUser.validate(n, p)){  
            RequestDispatcher rd=request.getRequestDispatcher("servlet1");  
            rd.forward(request,response);  
        }  
        else{  
            out.print("Sorry username or password error");  
            RequestDispatcher rd=request.getRequestDispatcher("index.html");  
            rd.include(request,response);  
        }  
              
        out.close();  
        }  
    }  
