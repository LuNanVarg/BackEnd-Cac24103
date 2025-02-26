package ar.com.cac24103.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ar.com.cac24103.web.domain.Usuario;

public class UsuarioDaoMysqlImpl implements UsuarioDao {

    public Usuario findByUsername(String username) {

        String sql = "SELECT u.id, u.email, u.password, r.nombre"+
                     "FROM usuarios u "+ 
                     "INNER JOIN usuarios_roles ur ON ur.usuarios_id = u.id "+
                     "INNER JOIN roles r ON r.id = ur.roles_id "+
                     "WHERE u.email = ?";
        
        Usuario usuario = null;

        Connection con = null;
        try {
            con = AdministradorDeConexiones.conectar();

            PreparedStatement statement = con.prepareStatement(sql);

            //seteo el email a consultar
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            //leer el reusltado y crear mis entidades
            //si hay datos, solo existe un registro!!!
            ArrayList<String> roles = new ArrayList<>();
            Long id = null;
            String email = null;
            String password = null;

            if (resultSet.next()) {
                id = resultSet.getLong(1);
                email = resultSet.getString(2);
                password = resultSet.getString(3);
                String roleName = resultSet.getString(4);

                roles.add(roleName);
            }
            if (id != null) {
                usuario = new Usuario(id, email, password, roles);
            }
        } catch(Exception e){
            System.err.println(e);
        }finally{
            AdministradorDeConexiones.desconectar(con);
        } 

        return usuario;
    }

}
