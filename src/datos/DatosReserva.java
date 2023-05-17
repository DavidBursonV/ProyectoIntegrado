package datos;

import java.util.Date;

public class DatosReserva {
    private int idreserva;
    private int idhabitacion;
    private int idcliente;
    private int idtrabajador;
    private String tipo_reserva;
    private String estado;
    private Date fecha_reserva;
    private Date fecha_ingreso;
    private Date fecha_salida;
    private Double precio_total;

    public DatosReserva() {
    }

    public DatosReserva(int idreserva, int idhabitacion, int idcliente,int idtrabajador, String tipo_reserva,
            String estado, Date fecha_reserva, Date fecha_ingreso, Date fecha_salida, Double precio_total) {
        this.idreserva = idreserva;
        this.idhabitacion = idhabitacion;
        this.idcliente = idcliente;
        this.tipo_reserva = tipo_reserva;
        this.estado = estado;
        this.fecha_reserva = fecha_reserva;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.precio_total = precio_total;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getTipo_reserva() {
        return tipo_reserva;
    }

    public void setTipo_reserva(String tipo_reserva) {
        this.tipo_reserva = tipo_reserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Double precio_total) {
        this.precio_total = precio_total;
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    
    
    
    
    
    
}
