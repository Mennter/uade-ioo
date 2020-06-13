package Model;

import java.time.ZonedDateTime;

import com.google.gson.annotations.Expose;

import helpers.SHA256Converter;


public class Usuario {

    private Long idUsuario;

    private String username;

    private String password;

    private String nombre;

    private String domicilio;

    private String dni;

    @Expose(serialize = false) 
    private ZonedDateTime fechaNacimiento;

    private Rol rol;


    public Usuario() {
    }

    public Usuario(Long idUsuario, String username, String password, String nombre, String domicilio, String dni, ZonedDateTime fechaNacimiento, Rol rol, Boolean borrado) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = SHA256Converter.toHash(password);
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
        this.borrado = borrado;
    }

    public Long getIdUsuario() {
        return this.idUsuario;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = SHA256Converter.toHash(password);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ZonedDateTime getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(ZonedDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Rol getRol() {
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Boolean isBorrado() {
        return this.borrado;
    }

    public Boolean getBorrado() {
        return this.borrado;
    }

    public void setBorrado(Boolean borrado) {
        this.borrado = borrado;
    }

    public Usuario idUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public Usuario username(String username) {
        this.username = username;
        return this;
    }

    public Usuario password(String password) {
        this.password = SHA256Converter.toHash(password);;
        return this;
    }

    public Usuario nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Usuario domicilio(String domicilio) {
        this.domicilio = domicilio;
        return this;
    }

    public Usuario dni(String dni) {
        this.dni = dni;
        return this;
    }

    public Usuario fechaNacimiento(ZonedDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public Usuario rol(Rol rol) {
        this.rol = rol;
        return this;
    }

    public Usuario borrado(Boolean borrado) {
        this.borrado = borrado;
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " idUsuario='" + getIdUsuario() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", domicilio='" + getDomicilio() + "'" +
            ", dni='" + getDni() + "'" +
            ", fechaNacimiento='" + getFechaNacimiento() + "'" +
            ", rol='" + getRol() + "'" +
            ", borrado='" + isBorrado() + "'" +
            "}";
    }
    private Boolean borrado;
}