package ar.com.cac24103.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ar.com.cac24103.web.domain.Personas;
import ar.com.cac24103.web.dto.PersonasDto;

public class MySQLCrudImpl implements ICrud {
    //private String tableName;
    //debo decir COMO: implementar el/los metodo/s de ICrud
    public Personas getById(Long id) {
        String sql = "select * from personas where id = " + id;
        //conectar a la db
        Personas persona = null;

        Connection con = null;
        try {
            con = AdministradorDeConexiones.conectar();

            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            //leer el reusltado y crear mis entidades
            //si hay datos, solo existe un registro!!!
            if (resultSet.next()) {
                Long idPersona = resultSet.getLong(1);
                String email = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String apellido = resultSet.getString(4);
                String imagen = resultSet.getString(5);
                Long tipoPersonaId = resultSet.getLong(6);

                persona = new Personas(idPersona, email, nombre, apellido, imagen, tipoPersonaId);
            }
        } catch(Exception e){
            System.err.println(e);
        }finally{
            AdministradorDeConexiones.desconectar(con);
        } 

        return persona;
    }

    public void create(PersonasDto dto) {
        String sql = "INSERT INTO personas (email, nombre, apellido, imagen, tipos_personas_Id) value(?,?,?,?,?,?)";
    
        Connection connection = AdministradorDeConexiones.conectar();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            //seteo en orden cada parametro
            pst.setString(1, dto.getEmail());
            pst.setString(2, dto.getNombre());
            pst.setString(3, dto.getApellido());
            pst.setString(4, dto.getImagen());
            pst.setLong(5, dto.getTipoPersonaId());
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            AdministradorDeConexiones.desconectar(connection);
        }
    }

    //implementamos el delete
    @Override
    public void delete(Long pk) {
        Connection cnx = null;
        String sql = "DELETE FROM personas WHERE id = ?";
        try {
            // 1) Conectarme a la DB
            cnx = AdministradorDeConexiones.conectar();
            PreparedStatement pstmt = cnx.prepareStatement(sql);
            pstmt.setLong(1, pk);
            if(pstmt.executeUpdate() > 0)
                System.out.println("El usuario con ID=" + pk + " ha sido eliminado.");
            } catch(Exception e ) {
                e.printStackTrace();
            } finally {
                AdministradorDeConexiones.desconectar(cnx);
            } 
    }
    //ListarPersonasController
    public ArrayList<Personas> findAll() {
        String sql = "select * from personas";
        //conectar a la db
        ArrayList<Personas> personas = new ArrayList<>();

        Connection con = null;
        try {
            con = AdministradorDeConexiones.conectar();

            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            //ahora son muchos | se cambia el if x el while !!!
            while(resultSet.next()) {
                Long idPersona = resultSet.getLong(1);
                String email = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String apellido = resultSet.getString(4);
                String imagen = resultSet.getString(5);
                Long tipoPersonaId = resultSet.getLong(6);

                Personas persona = new Personas(idPersona, email, nombre, apellido, imagen, tipoPersonaId);
                personas.add(persona);
            }
        } catch(Exception e){
            System.err.println(e);
        }finally{
            AdministradorDeConexiones.desconectar(con);
        } 

        return personas;
    }

    public void update(PersonasDto persona) {
        String sql = new String("UPDATE personas set nombre=?, apellido=?, email=?, tipos_personas_id=? WHERE id=? ");
        
        Connection connection = AdministradorDeConexiones.conectar();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido());
            pst.setString(3, persona.getEmail());
            //pst.setString(3, persona.getImagen());
            pst.setLong(4, persona.getTipoPersonaId());
            pst.setLong(5, persona.getId());

            pst.executeUpdate();
            if (pst.getUpdateCount()> 0) {
                System.out.println("update ok");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            AdministradorDeConexiones.desconectar(connection);
        }
    }
  
}