package ar.com.cac24103.web.contrallers;

import java.io.IOException;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Object;
//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import ar.com.cac24103.web.dto.PersonasDto;
import ar.com.cac24103.web.service.PersonasService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CrearClientesController") //1
public class CrearPersonasController extends HttpServlet {

    @Override
    protected void doPost(
        HttpServletRequest req,
        HttpServletResponse resp
    ) throws ServletException, IOException {

        String jsonQueMandaElFront = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(jsonQueMandaElFront);

        // usamos jackson para convertir el texto que viene desde el front en un objeto java "magcamente" creado
        ObjectMapper mapper = new ObjectMapper();
        //creo el DTO
        PersonasDto dto = mapper.readValue(jsonQueMandaElFront, PersonasDto.class); 
        // quiero obtener una persona de la base de datos (db) con id=1
        //Long id=1l;//recibe desde el request que mando algun frontend
        //String nombre = "Ycnan";
        //String apellido = "Anul";
        //String email = "ycnan@ycnan.com";
        //String imagen = "https://gorillaz.fandom.com/es/wiki/Demon_Days_(%C3%A1lbum)?file=Gorillaz_Demon_Days.png" ;
        //Long tipoPersonaId = 1l;
/* 
        if(nombre == null || nombre.isBlank()) {
            //aca hay un error
            return;
        }
*/
        PersonasService service = new PersonasService();
        service.crearPersona(dto);

        //crear el DTO
        // PersonasDto dto = new PersonasDto(nombre, apellido,email, imagen, tipoPersonaId);
        //service.crearPersona(dto);

        // Configurar cabeceras CORS
        //resp.setHeader("Access-Control-Allow-Origin", "*"); //Permite acceso desde cualquir origen
        //resp.setHeader("Access-Control-Allow-Methods", "*"); //Metodos permitidos
        //resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); //Cabeceras permitidas

        ////http status code: 100,200,300,400,500
        resp.setStatus(HttpServletResponse.SC_CREATED); ///creado
    }

}
