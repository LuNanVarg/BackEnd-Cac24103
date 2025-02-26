package ar.com.cac24103.web.domain;

public class Personas {
    private Long id;
    private String email;
    private String nombre;
    private String apellido;
    private String imagen;
    private Long tipoPersonaId;

    //Obtener desde la db
    public Personas(Long id, String email, String nombre,  String apellido, String imagen, Long tipoPersonaId) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
        this.tipoPersonaId = tipoPersonaId;
    }

    //para crear en la db
    public Personas( String email, String nombre,  String apellido, String imagen, Long tipoPersonaId) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
        this.tipoPersonaId = tipoPersonaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Long getTipoPersonaId() {
        return tipoPersonaId;
    }

    public void setTipoPersonaId(Long tipoPersonaId) {
        this.tipoPersonaId = tipoPersonaId;
    }

    public String toString() {
        return "Personas [id=" + id + ", email=" + email + ", nombre=" + nombre + ", apellido=" + apellido + ", imagen="
                + imagen + ", tipoPersonaId=" + tipoPersonaId + "]";
    }

}
