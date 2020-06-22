package Model;

import java.util.List;


public class Rol {

    private Long idRol;

    private String nombreRol;

    private List<String> acciones;

    public Rol() {
    }

    public Rol(Long idRol, String nombreRol, List<String> acciones) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.acciones = acciones;
    }

    public Long getIdRol() {
        return this.idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return this.nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List<String> getAcciones() {
        return this.acciones;
    }

    public void setAcciones(List<String> acciones) {
        this.acciones = acciones;
    }

    public Rol idRol(Long idRol) {
        this.idRol = idRol;
        return this;
    }

    public Rol nombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
        return this;
    }

    public Rol acciones(List<String> acciones) {
        this.acciones = acciones;
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " idRol='" + getIdRol() + "'" +
            ", nombreRol='" + getNombreRol() + "'" +
            ", acciones='" + getAcciones() + "'" +
            "}";
    }
    
}