package ar.com.cac24103.web.contrallers;

import ar.com.cac24103.web.domain.Personas;
import ar.com.cac24103.web.service.PersonasService;

public class ObtenerPersonasController {
    //?id=1&roX=valor

    //doGet

    public static void main(String[] args) {
        // quiero obtener una persona de la base de datos (db) con id=1
        Long id=1l;//recibe desde el request que mando algun frontend
        PersonasService service = new PersonasService();

        Personas persona = service.obtenerPersonaPorID(id);

        System.out.println(persona);
    }

}
