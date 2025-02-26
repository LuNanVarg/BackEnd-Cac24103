package ar.com.cac24103.web.dao;

import ar.com.cac24103.web.domain.Usuario;

public interface UsuarioDao {

    public Usuario findByUsername(String username);


}
