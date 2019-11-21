package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.ContentValues;

/**
 * Created by DTIC-123 on 23/03/2017.
 */

public class Usuario {

    private String nombre;
    private String nombreUsuario;
    private String contrasenia;
    private String domicilio;
    private String email;
    private String numeroCelularTelefono;
    private String nombreFactura;
    private String nit;


    public Usuario(String [] usuario) {
        this.nombre = usuario[0];
        this.nombreUsuario = usuario[1];
        this.contrasenia = usuario[2];
        this.domicilio = usuario[3];
        this.email = usuario[4];
        this.numeroCelularTelefono = usuario[5];
        this.nombreFactura = usuario[6];
        this.nit = usuario[7];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCelularTelefono() {
        return numeroCelularTelefono;
    }

    public void setNumeroCelularTelefono(String numeroCelularTelefono) {
        this.numeroCelularTelefono = numeroCelularTelefono;
    }

    public String getNombreFactura() {
        return nombreFactura;
    }

    public void setNombreFactura(String nombreFactura) {
        this.nombreFactura = nombreFactura;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(UsuariosContract.UsuarioEntry.NAME, nombre);
        values.put(UsuariosContract.UsuarioEntry.USERNAME, nombreUsuario);
        values.put(UsuariosContract.UsuarioEntry.PASSWORD, contrasenia);
        values.put(UsuariosContract.UsuarioEntry.EMAIL, email);
        values.put(UsuariosContract.UsuarioEntry.ADDRESS, domicilio);
        values.put(UsuariosContract.UsuarioEntry.PHONE_NUMBER, numeroCelularTelefono);
        values.put(UsuariosContract.UsuarioEntry.NIT, nit);
        values.put(UsuariosContract.UsuarioEntry.INVOICENAME, nombreFactura);

        return values;
    }
}
