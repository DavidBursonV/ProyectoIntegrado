/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author david
 */
public class DatosPersona {
    
    private int idpersona;
    private String nombre;
    private String email;
    private String direccion;
    private String num_dni;
    private String primer_apellido;
    private String seg_apellido;
    private String telefono;
    private String tipo_documneto;

    public DatosPersona() {
    }

    public DatosPersona(int idpersona, String nombre, String email, String direccion, String num_dni,
            String primer_apellido, String seg_apellido, String telefono, String tipo_documneto) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.num_dni = num_dni;
        this.primer_apellido = primer_apellido;
        this.seg_apellido = seg_apellido;
        this.telefono = telefono;
        this.tipo_documneto = tipo_documneto;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNum_dni() {
        return num_dni;
    }

    public void setNum_dni(String num_dni) {
        this.num_dni = num_dni;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSeg_apellido() {
        return seg_apellido;
    }

    public void setSeg_apellido(String seg_apellido) {
        this.seg_apellido = seg_apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo_documneto() {
        return tipo_documneto;
    }

    public void setTipo_documneto(String tipo_documneto) {
        this.tipo_documneto = tipo_documneto;
    }       
    
}
