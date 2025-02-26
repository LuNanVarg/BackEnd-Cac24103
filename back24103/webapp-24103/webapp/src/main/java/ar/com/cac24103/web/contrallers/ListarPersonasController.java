package ar.com.cac24103.web.contrallers;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.cac24103.web.domain.Personas;
import ar.com.cac24103.web.service.PersonasService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListarPersonasController")
public class ListarPersonasController extends HttpServlet{

    @Override
    protected void doGet(
        HttpServletRequest req, //esto tiene los datos del front
        HttpServletResponse resp //va todo lo que el back quiera enviarle al front 
    ) throws ServletException, IOException {
        //crear service
        PersonasService service = new PersonasService();

        //invocar metodo listarPersonas > lista
        ArrayList<Personas> personas = service.listarPersonas();

        ObjectMapper mapper = new ObjectMapper();

        //convierto Objecto java a json string
        //ahora respondo al frontend, convirtiendo el nuevo orador a json.
        String personasJSON = mapper.writeValueAsString(personas);

        //mostrar por consola | enviar al front
        // Configurar cabeceras CORS
       // resp.setHeader("Access-Control-Allow-Origin", "*"); //Permite acceso desde cualquir origen
        //resp.setHeader("Access-Control-Allow-Methods", "*"); //Metodos permitidos
        //resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); //Cabeceras permitidas
        
        resp.getWriter().println(personasJSON); 
    }

/* 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //crear service
        PersonasService service = new PersonasService();

        //invocar metodo listarPersonas > lista
        ArrayList<Personas> personas = service.listarPersonas();

        //mostrar por consola | enviar al frontend
       resp.getWriter().println(personas);
    }
*/

    
    /*
    //Esto deja de seer java
    public static void main(String[] args) {
        //crear service
        PersonasService service = new PersonasService();

        //invocar metodo listarPersonas > lista
        ArrayList<Personas> personas = service.listarPersonas();

        //mostrar por consola | enviar al frontend
        System.out.println(personas);
    }
    */

}
