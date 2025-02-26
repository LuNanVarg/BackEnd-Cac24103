package ar.com.cac24103.web.contrallers;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.cac24103.web.dto.PersonasDto;
import ar.com.cac24103.web.service.PersonasService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ActualizarPersonasController")
public class ActualizarPersonasController extends HttpServlet {

    @Override
    protected void doPost(
        HttpServletRequest req,
        HttpServletResponse resp
    ) throws ServletException, IOException {
       // usamos jackson para convertir el texto que viene desde el front en un objeto java "magcamente" creado
       ObjectMapper mapper = new ObjectMapper();
       //creo el DTO
       PersonasDto dto = mapper.readValue(req.getReader(), PersonasDto.class); 

       PersonasService service = new PersonasService();
       service.actualizarPersona(dto);

       resp.setStatus(HttpServletResponse.SC_CREATED); 

    }

}
