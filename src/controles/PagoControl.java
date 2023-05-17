/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import datos.DatosHabitacion;
import datos.DatosPago;
import datos.DatosProducto;
import java.sql.Connection;
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
public class PagoControl {
    
     private Conexion mysql = new Conexion();
     private Connection cn=mysql.conectar();
     private String sSQL="";
     public int totalregistros;
	
	public DefaultTableModel mostrar(String buscar) {
		DefaultTableModel modelo;

		String[] titulos = { "ID", "idreserva", "comprobante", "Número ", "IVA", "Total", "Fecha Emision", "Fecha Pago" };

		String[] registro = new String[8];
		totalregistros = 0;
		modelo = new DefaultTableModel(null, titulos);

		sSQL = "SELECT * FROM pago Where idreserva=" + buscar + " ORDER BY idpago desc";

		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);

			//bucle para recorrer el resultSet y que muestre los productos
			while (rs.next()) {
				registro[0] = rs.getString("idpago");
				registro[1] = rs.getString("idreserva");
				registro[2] = rs.getString("tipo_comprobante");
				registro[3] = rs.getString("num_comprobante");
				registro[4] = rs.getString("IVA");
                                registro[5] = rs.getString("total_pago");
                                registro[6] = rs.getString("fecha_emision");
                                registro[7] = rs.getString("fecha_pago");
                                

				totalregistros = totalregistros+1;
				modelo.addRow(registro);

			}

			return modelo;

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
			return null;
		}
	}
	
	//Método para insertar datos en la bd con preparedStatement y un condicional para verificar si el registro es diferente a 0
	public boolean insertar(DatosPago dts) {
		sSQL = "INSERT INTO pago (idreserva, tipo_comprobante, num_comprobante, IVA, total_pago, fecha_emision, fecha_pago)"
				+ "values(?,?,?,?,?,?,?)";
		try {

			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setInt(1, dts.getIdreserva());
			pst.setString(2, dts.getTipo_comprobante());
                        pst.setString(3, dts.getNum_comprobante());
			pst.setDouble(4, dts.getIVA());
			pst.setDouble(5, dts.getTotal_pago());
                        pst.setDate(6, dts.getFecha_emision());
                        pst.setDate(7, dts.getFecha_pago());

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
	
	
	public boolean editar(DatosPago dts) {
		
		sSQL="UPDATE pago SET idreserva =?, tipo_comprobante =?, num_comprobante =?, IVA=?, total_pago =?, fecha_emision =?, fecha_pago =?"+
		"WHERE idpago =?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setInt(1, dts.getIdreserva());
			pst.setString(2, dts.getTipo_comprobante());
                        pst.setString(3, dts.getNum_comprobante());
			pst.setDouble(4, dts.getIVA());
			pst.setDouble(5, dts.getTotal_pago());
                        pst.setDate(6, dts.getFecha_emision());
                        pst.setDate(7, dts.getFecha_pago());
                        
                        pst.setInt(8,dts.getIdpago());

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
	
	public boolean eliminar(DatosPago dts) {
		
		sSQL="DELETE FROM pago WHERE idpago=?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setInt(1, dts.getIdpago());

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
        
         
}
