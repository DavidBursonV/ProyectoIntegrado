/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import datos.DatosHabitacion;
import datos.DatosProducto;
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
public class ProductoControl {
    
     private Conexion mysql = new Conexion();
     private Connection cn=mysql.conectar();
     private String sSQL="";
     public int totalregistros;
	
	public DefaultTableModel mostrar(String buscar) {
		DefaultTableModel modelo;

		String[] titulos = { "ID", "Nombre", "Descripcion", "Precio venta", "Unidad medida" };

		String[] registro = new String[5];
		totalregistros = 0;
		modelo = new DefaultTableModel(null, titulos);

		sSQL = "SELECT * FROM producto Where nombre LIKE '%" + buscar + "%' ORDER BY idproducto desc";

		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);

			//bucle para recorrer el resultSet y que muestre los productos
			while (rs.next()) {
				registro[0] = rs.getString("idproducto");
				registro[1] = rs.getString("nombre");
				registro[2] = rs.getString("descripcion");
				registro[3] = rs.getString("precio_venta");
				registro[4] = rs.getString("unidad_medida");

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
	public boolean insertar(DatosProducto dts) {
		sSQL = "INSERT INTO producto(nombre, descripcion,unidad_medida,precio_venta)"
				+ "values(?,?,?,?)";
		try {

			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setString(1, dts.getNombre());
			pst.setString(2, dts.getDescripcion());
			pst.setString(3, dts.getUnidad_medida());
			pst.setDouble(4, dts.getPrecio_venta());

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
	
	
	public boolean editar(DatosProducto dts) {
		
		sSQL="UPDATE producto SET nombre =?, descripcion =?, unidad_medida =?, precio_venta=?"+
		"WHERE idproducto =?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setString(1, dts.getNombre());
			pst.setString(2, dts.getDescripcion());
			pst.setString(3, dts.getUnidad_medida());
			pst.setDouble(4, dts.getPrecio_venta());
                        pst.setInt(5,dts.getIdproducto());

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
	
	public boolean eliminar(DatosProducto dts) {
		
		sSQL="DELETE FROM producto WHERE idproducto=?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setInt(1, dts.getIdproducto());

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
