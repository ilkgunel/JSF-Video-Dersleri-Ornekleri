 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ajaxexample extends HttpServlet {
 
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {

    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();

    out.println("İsim-Soyisim:"+request.getParameter("isim")+" "+request.getParameter("soyisim"));

    }
}