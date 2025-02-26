package ar.com.cac24103.web.dto;

// Es un Objeto Inmutables
public class PersonasDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String imagen;
    private Long tipoPersonaId;

    //necesitamos un constructor por defecto para poder usar jackson
    public PersonasDto(){
        
    }

    public PersonasDto(Long id, String nombre, String apellido, String email, String imagen, Long tipoPersonaId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.imagen = imagen;
        this.tipoPersonaId = tipoPersonaId;
    }

        // Nuevo constructor
        public PersonasDto(String nombre, String apellido,String email, String imagen, Long tipoPersonaId) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.email = email;
            this.imagen = imagen;
            this.tipoPersonaId = tipoPersonaId;
        }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getImagen() {
        return imagen;
    }

    public Long getTipoPersonaId() {
        return tipoPersonaId;
    }

}
