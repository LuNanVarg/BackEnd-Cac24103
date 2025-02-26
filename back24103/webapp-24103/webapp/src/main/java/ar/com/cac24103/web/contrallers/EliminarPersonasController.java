package ar.com.cac24103.web.contrallers;

import java.io.IOException;

import ar.com.cac24103.web.service.PersonasService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarPersonasController")
public class EliminarPersonasController extends HttpServlet{

    protected void doDelete(
        HttpServletRequest req,
        HttpServletResponse resp
    ) throws ServletException, IOException {
            // quiero obtener una persona de la base de datos (db) con id=1
                String id= req.getParameter("id"); 

                PersonasService service = new PersonasService();
 
                service.eliminarPersonaPorID(Long.parseLong(id));

                resp.setStatus(HttpServletResponse.SC_OK);
    }

/*    public static void main(String[] args) {
        // quiero obtener una persona de la base de datos (db) con id=1
        Long id=1l;//recibe desde el request que mando algun frontend

        PersonasService service = new PersonasService();

        service.eliminarPersonaPorID(id);
        
    }
*/

}

