package ar.com.cac24103.web.service;

import java.util.ArrayList;

import ar.com.cac24103.web.dao.ICrud;
import ar.com.cac24103.web.dao.MySQLCrudImpl;
import ar.com.cac24103.web.domain.Personas;
import ar.com.cac24103.web.dto.PersonasDto;

public class PersonasService {
    private ICrud crud; //null, porque no es primitivo

    //ctrl + espacio ==> MovieService
    public  PersonasService(){
        //Interface nombre = new ClaseQueImplementaLaInterface();
        crud = new MySQLCrudImpl();
    }

    public void crearPersona(PersonasDto dto) {
        this.crud.create(dto);
      //  this.crud.getById(null);
    }

    public Personas obtenerPersonaPorID(Long id) {
        return this.crud.getById(id);
    }

    public void eliminarPersonaPorID(Long id) {
       this.crud.delete(id);
    }

    public ArrayList<Personas> listarPersonas() {
       return this.crud.findAll();
    }

    public void actualizarPersona(PersonasDto persona) {
        this.crud.update(persona);
    }
}
