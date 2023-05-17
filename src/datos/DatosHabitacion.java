/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author david
 */
public class DatosHabitacion {
    
    private int idhabitacion;
	private String numero;
	private String piso;
	private String descripcion;
	private String caracteristicas;
	private Double precio_dia;
	private String estado;
	private String tipo_habitacion;
	
	public DatosHabitacion() {
		super();
	}

	public DatosHabitacion(int idhabitacion, String numero, String piso, String descripcion, String caracteristicas,
			Double precio_dia, String estado, String tipo_habitacion) {
		super();
		this.idhabitacion = idhabitacion;
		this.numero = numero;
		this.piso = piso;
		this.descripcion = descripcion;
		this.caracteristicas = caracteristicas;
		this.precio_dia = precio_dia;
		this.estado = estado;
		this.tipo_habitacion = tipo_habitacion;
	}

	public int getIdhabitacion() {
		return idhabitacion;
	}

	public void setIdhabitacion(int idhabitacion) {
		this.idhabitacion = idhabitacion;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public Double getPrecio_dia() {
		return precio_dia;
	}

	public void setPrecio_dia(Double precio_dia) {
		this.precio_dia = precio_dia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo_habitacion() {
		return tipo_habitacion;
	}

	public void setTipo_habitacion(String tipo_habitacion) {
		this.tipo_habitacion = tipo_habitacion;
	}
    
}
