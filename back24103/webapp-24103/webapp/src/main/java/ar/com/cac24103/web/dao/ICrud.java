package ar.com.cac24103.web.dao;

import java.util.ArrayList;

import ar.com.cac24103.web.domain.Personas;
import ar.com.cac24103.web.dto.PersonasDto;

public interface ICrud {

    //que 
    public Personas getById(Long id);
    //select * from clientes where id = '?'

    public void create(PersonasDto dto);

    public void delete(Long pk);

    public ArrayList<Personas> findAll();

    public void update(PersonasDto persona);

}
