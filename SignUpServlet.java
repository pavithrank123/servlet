import java.io.*;

import javax.servlet.*;

import javax.servlet.http.*;

import java.sql.*;

public class SignUpServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

		throws ServletException, IOException {
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();
			String name = request.getParameter("name");
			String hid = request.getParameter("hid");
			String op1 = request.getParameter("op1");
			String op2 = request.getParameter("op2");
                        String oper = request.getParameter("oper");
                        String email = request.getParameter("email");
			char op=oper.charAt(0);
		 	if(op=='+'||op=='-'||op=='*'||op=='/'||op=='%')	
			{
				int a=Integer.parseInt(op1);
				int b=Integer.parseInt(op2);
				int answer;	
				if(op=='+')
				{
					answer=a+b;
				}
				else if(op=='-')
				{
					answer=a-b;		
				}
				else if(op=='*')               
	                                {
                                        answer=a*b;
                                }
				else if(op=='/')               
                                {
                                        answer=a/b;
                                }
				else if(op=='%')               
                                {
                                        answer=a%b;
                                }
				else
				{
					answer=-1111;
				}
				if(answer!=-1111)
				{			
					out.println("<center><h2>RESULT IS</h2></center>");
					out.println("<center><h3>"+answer+"</h2></center>");
                                        out.println("<br><br><br><br><br><br>");
                                        out.println("<center><h2>Reading Secret Message</h2></center>");
                                        out.println("<center><h3>"+hid+"</h3></center>");
					out.println("<br><br><br><br><br><br>");

					Cookie ck=new Cookie("user",email);  
					response.addCookie(ck);
                                        out.println("<center><h2>COOKIE SET</h2></center>");
					out.println("<center><h3>"+email+"</h3></center>");
					out.println("<center><h2>RELOADING WITH CALCULATED ANSWER</h2></center>");
					out.print("<center><h3><a href='?answer="+answer+"'>Reload</a></h3></center>");  						
				}
				else
				{
					out.println("<center><h2>Calculator Error</h2></center>");
				}
			}
			else
			{
				out.println("<center><h2>Invalid Operator</h2></center>");
			}
			out.close();

		}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

			// Set response content type
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();

                        String answerparams = request.getParameter("answer");
			if(answerparams!=null)
                        {
                                out.println("<center><h2>ANSWER IS PASSED IN URL PARAMETERS</h2></center>");
                                out.println("<center><h3>Calculated Answer - "+answerparams+"</h3></center>");
                        	HttpSession session=request.getSession();  
        			session.setAttribute("answer",answerparams);  
				out.println("<center><h2>ANSWER IN SESSION ATTRIBUTE IS SET</h2></center>");
				out.println("<center><h3>CHECK YOUR BROWSER</h3></center>");
			}
                        else
			{
				out.println("<center><h2>ERROR</h2></center>");
                                out.println("<center><h3>NOT AVAILABLE NOW!!!</h3></center>");
			}
		}	
}
