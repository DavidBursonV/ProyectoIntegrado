/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import datos.DatosHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author david
 */
public class HabitacionControl {
    
    private Conexion mysql = new Conexion();
	private Connection cn=mysql.conectar();
	private String sSQL="";
	public int totalregistros;
	
	public DefaultTableModel mostrar(String buscar) {
		DefaultTableModel modelo;

		String[] titulos = { "id", "Número", "piso", "Descripcion", "Carateristicas", "Precio", "Estado",
				"Tipo de habitación" };

		String[] registro = new String[8];
		totalregistros = 0;
		modelo = new DefaultTableModel(null, titulos);

		sSQL = "SELECT * FROM habitacion Where piso LIKE '%" + buscar + "%' ORDER BY idhabitacion";

		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);

			////bucle para recorrer el resultSet y que muestre las habitaciones
			while (rs.next()) {
				registro[0] = rs.getString("idhabitacion");
				registro[1] = rs.getString("numero");
				registro[2] = rs.getString("piso");
				registro[3] = rs.getString("descripcion");
				registro[4] = rs.getString("caracteristicas");
				registro[5] = rs.getString("precio_dia");
				registro[6] = rs.getString("estado");
				registro[7] = rs.getString("tipo_habitacion");

				totalregistros = totalregistros++;
				modelo.addRow(registro);

			}

			return modelo;

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
			return null;
		}
	}
	
	//Método para insertar datos en la bd con preparedStatement y un condicional para verificar si el registro es diferente a 0
	public boolean insertar(DatosHabitacion dts) {
		sSQL = "INSERT INTO habitacion(numero, piso,descripcion,caracteristicas,precio_dia,estado,tipo_habitacion)"
				+ "values(?,?,?,?,?,?,?)";
		try {

			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setString(1, dts.getNumero());
			pst.setString(2, dts.getPiso());
			pst.setString(3, dts.getDescripcion());
			pst.setString(4, dts.getCaracteristicas());
			pst.setDouble(5, dts.getPrecio_dia());
			pst.setString(6, dts.getEstado());
			pst.setString(7, dts.getTipo_habitacion());

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
	
	
	public boolean editar(DatosHabitacion dts) {
		
		sSQL="UPDATE habitacion SET NUMERO =?, piso=?, descripcion =?, caracteristicas =?, precio_dia=?, estado=?, tipo_habitacion=?"+
		"WHERE idhabitacion =?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setString(1, dts.getNumero());
			pst.setString(2, dts.getPiso());
			pst.setString(3, dts.getDescripcion());
			pst.setString(4, dts.getCaracteristicas());
			pst.setDouble(5, dts.getPrecio_dia());
			pst.setString(6, dts.getEstado());
			pst.setString(7, dts.getTipo_habitacion());
			pst.setInt(8, dts.getIdhabitacion());

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
        
        
        public boolean desocupar(DatosHabitacion dts) {
		
		sSQL="UPDATE habitacion SET  estado='Disponible'"+
		"WHERE idhabitacion =?";
		
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
        
        
         public boolean ocupar(DatosHabitacion dts) {
		
		sSQL="UPDATE habitacion SET  estado='Ocupado'"+
		"WHERE idhabitacion =?";
		
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
        
        
	
	public boolean eliminar(DatosHabitacion dts) {
		
		sSQL="DELETE FROM habitacion WHERE idhabitacion=?";
		
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
        
        public DefaultTableModel mostrarVista(String buscar) {
		DefaultTableModel modelo;

		String[] titulos = { "id", "Número", "piso", "Descripcion", "Carateristicas", "Precio", "Estado",
				"Tipo de habitación" };

		String[] registro = new String[8];
		totalregistros = 0;
		modelo = new DefaultTableModel(null, titulos);

		sSQL = "SELECT * FROM habitacion Where piso LIKE '%" + buscar + "%' and estado='Disponible' ORDER BY idhabitacion";

		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);

			////bucle para recorrer el resultSet y que muestre las habitaciones
			while (rs.next()) {
				registro[0] = rs.getString("idhabitacion");
				registro[1] = rs.getString("numero");
				registro[2] = rs.getString("piso");
				registro[3] = rs.getString("descripcion");
				registro[4] = rs.getString("caracteristicas");
				registro[5] = rs.getString("precio_dia");
				registro[6] = rs.getString("estado");
				registro[7] = rs.getString("tipo_habitacion");

				totalregistros = totalregistros++;
				modelo.addRow(registro);

			}

			return modelo;

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
			return null;
		}
	}
        
        
    
}
