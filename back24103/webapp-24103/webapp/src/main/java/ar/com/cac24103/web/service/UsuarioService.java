package ar.com.cac24103.web.service;

import ar.com.cac24103.web.dao.UsuarioDao;
import ar.com.cac24103.web.dao.UsuarioDaoMysqlImpl;
import ar.com.cac24103.web.domain.Usuario;

public class UsuarioService {

    private UsuarioDao dao;

    public UsuarioService() {
        this.dao = new UsuarioDaoMysqlImpl();
    }

    public Usuario buscarUsuario(String email){
        return this.dao.findByUsername(email);
    }
}
