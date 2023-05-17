/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import datos.DatosHabitacion;
import datos.DatosPago;
import datos.DatosProducto;
import datos.DatosReserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david
 */
public class ReservaControl {
    
     private Conexion mysql = new Conexion();
     private Connection cn=mysql.conectar();
     private String sSQL="";
     public int totalregistros;
     public int num_dias;
	
	public DefaultTableModel mostrar(String buscar) {
		DefaultTableModel modelo;

		String[] titulos = { "ID", "idhabitacion", "Numero", "idcliente", "Cliente", "idtrabajador",
                        "Trabajador", "tipo Reserva", "Fecha Reserva", "Fecha Ingreso","Fecha Salida", "Coste Total", "Estado" };

		String[] registro = new String[13];
		totalregistros = 0;
		modelo = new DefaultTableModel(null, titulos);

		sSQL = "SELECT r.idreserva, r.idhabitacion, h.numero, r.idcliente,"+
                        "(select nombre from persona where idpersona =r.idcliente)as clienten,"+
                        "(select primer_apellido from persona where idpersona =r.idcliente)as clientepa,"+
                        "r.idtrabajador, (select nombre from persona where idpersona =r.idtrabajador)as trabajadorn,"+
                        "(select primer_apellido from persona where idpersona =r.idcliente)as trabajadorap,"+
                        "r.tipo_reserva, r.fecha_reserva, r.fecha_ingreso,r.fecha_salida,"+
                        "r.precio_total, r.estado FROM reserva r inner join habitacion h on r.idhabitacion=h.idhabitacion "+
                        "Where r.fecha_reserva LIKE '%" + buscar + "%' ORDER BY idreserva desc";

		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);

			//bucle para recorrer el resultSet y que muestre los productos
			while (rs.next()) {
				registro[0] = rs.getString("idreserva");
				registro[1] = rs.getString("idhabitacion");
				registro[2] = rs.getString("numero");
				registro[3] = rs.getString("idcliente");
				registro[4] = rs.getString("clienten") + " " + rs.getString("clientepa");
                                registro[5] = rs.getString("idtrabajador");
                                registro[6] = rs.getString("trabajadorn") + " " + rs.getString("trabajadorap");
                                registro[7] = rs.getString("tipo_reserva");
                                registro[8] = rs.getString("fecha_reserva");
                                registro[9] = rs.getString("fecha_ingreso");
                                registro[10] = rs.getString("fecha_salida");
                                registro[11] = rs.getString("precio_total");
                                registro[12] = rs.getString("estado");

				totalregistros = totalregistros ++;
				modelo.addRow(registro);

			}

			return modelo;

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
			return null;
		}
	}
	
	//Método para insertar datos en la bd con preparedStatement y un condicional para verificar si el registro es diferente a 0
	public boolean insertar(DatosReserva dts) {
		sSQL = "INSERT INTO reserva (idhabitacion, idcliente, idtrabajador, tipo_reserva, fecha_reserva, fecha_ingreso, fecha_salida, precio_total, estado)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {

			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setInt(1, dts.getIdhabitacion());
			pst.setInt(2, dts.getIdcliente());
			pst.setInt(3, dts.getIdtrabajador());
			pst.setString(4, dts.getTipo_reserva());
                        pst.setDate(5, (Date) dts.getFecha_reserva());
                        pst.setDate(6, (Date) dts.getFecha_ingreso());
                        pst.setDate(7, (Date) dts.getFecha_salida());
                        pst.setDouble(8, dts.getPrecio_total());
                        pst.setString(9, dts.getEstado());

			int n = pst.executeUpdate();

			if (n != 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
			return false;
		}
	}
	
	
	public boolean editar(DatosReserva dts) {
		
		sSQL="UPDATE reserva SET idhabitacion =?, idcliente =?, idtrabajador =?, tipo_reserva=?, fecha_reserva=?, fecha_ingreso=?, fecha_salida=?, precio_total=?, estado=?"+
		"WHERE idreserva =?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setInt(1, dts.getIdhabitacion());
			pst.setInt(2, dts.getIdcliente());
			pst.setInt(3, dts.getIdtrabajador());
			pst.setString(4, dts.getTipo_reserva());
                        pst.setDate(5, (Date) dts.getFecha_reserva());
                        pst.setDate(6, (Date) dts.getFecha_ingreso());
                        pst.setDate(7, (Date) dts.getFecha_salida());
                        pst.setDouble(8, dts.getPrecio_total());
                        pst.setString(9, dts.getEstado());
                        pst.setInt(10, dts.getIdreserva());

			int n = pst.executeUpdate();

			if (n != 0) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
			return false;
		}
	}
        
        
        public boolean pagar(DatosReserva dts) {
		
		sSQL="UPDATE reserva SET estado='Pagado"+
		"WHERE idreserva =?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setInt(1, dts.getIdhabitacion());
			

			int n = pst.executeUpdate();

			if (n != 0) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
			return false;
		}
	}
        
        
	
	public boolean eliminar(DatosReserva dts) {
		
		sSQL="DELETE FROM reserva WHERE idreserva=?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setInt(1, dts.getIdreserva());

			int n = pst.executeUpdate();

			if (n != 0) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
			return false;
		}
		
        }
        
      /*  public int num_dias(DatosReserva dts){
            String[] registro = new String[2];
            
            sSQL="SELECT precio_diario DATEDIFF (fecha_ingreso, fecha_salida) as num_dias FROM habitaciones WHERE id =?";
            try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);

			registro[0] = rs.getString("precio_diario");
                        registro[0] = rs.getString("num_dias");
                        
            JOptionPane.showMessageDialog(null, num_dias);
			
		} catch (Exception e) {
			
                }
                     return 0;
        }*/
}

      
        
        
        
        

