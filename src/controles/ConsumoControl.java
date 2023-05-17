
package controles;

import datos.DatosConsumo;
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
public class ConsumoControl {
    
     private Conexion mysql = new Conexion();
     private Connection cn=mysql.conectar();
     private String sSQL="";
     public int totalregistros;
     public Double totalconsumo;
	
	public DefaultTableModel mostrar(String buscar) {
		DefaultTableModel modelo;

		String[] titulos = { "ID", "idreserva", "idproducto", "producto", "cantidad", "precio_venta", "estado" };

		String[] registro = new String[7];
		totalregistros = 0;
                totalconsumo=0.0;
		modelo = new DefaultTableModel(null, titulos);

		sSQL = "SELECT c.idconsumo,c.idreserva,c.idproducto,p.nombre,c.cantidad,c.precio_venta,"
                        + "c.estado FROM consumo c inner join producto p on c.idproducto=p.idproducto"
                        + " Where c.idreserva =" + buscar + " ORDER BY c.idconsumo desc";

		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);

			//bucle para recorrer el resultSet y que muestre los productos
			while (rs.next()) {
				registro[0] = rs.getString("idconsumo");
				registro[1] = rs.getString("idreserva");
				registro[2] = rs.getString("idproducto");
				registro[3] = rs.getString("nombre");
				registro[4] = rs.getString("cantidad");
                                registro[5] = rs.getString("precio_venta");
                                registro[6] = rs.getString("estado");

				totalregistros = totalregistros++;
                                totalconsumo = totalconsumo+ (rs.getDouble("cantidad") * rs.getDouble("precio_venta"));
                                
				modelo.addRow(registro);

			}

			return modelo;

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
			return null;
		}
	}
	
	//Método para insertar datos en la bd con preparedStatement y un condicional para verificar si el registro es diferente a 0
	public boolean insertar(DatosConsumo dts) {
		sSQL = "INSERT INTO consumo (idreserva, idproducto, cantidad, precio_venta, estado)"
				+ "values(?,?,?,?,?)";
		try {

			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setInt(1, dts.getIdreserva());
			pst.setInt(2, dts.getIdproducto());
			pst.setDouble(3, dts.getCantidad());
			pst.setDouble(4, dts.getPrecio_venta());
                        pst.setString(5, dts.getEstado());

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
	
	
	public boolean editar(DatosConsumo dts) {
		
		sSQL="UPDATE consumo SET idreserva =?, idproducto =?, cantidad =?, precio_venta=?,estado=?"+
		"WHERE idconsumo =?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setInt(1, dts.getIdreserva());
			pst.setInt(2, dts.getIdproducto());
			pst.setDouble(3, dts.getCantidad());
			pst.setDouble(4, dts.getPrecio_venta());
                        pst.setString(5, dts.getEstado());
                        
                        pst.setInt(6, dts.getIdconsumo());

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
	
	public boolean eliminar(DatosConsumo dts) {
		
		sSQL="DELETE FROM consumo WHERE idconsumo=?";
		
		try {
			PreparedStatement pst = cn.prepareStatement(sSQL);
			pst.setInt(1, dts.getIdconsumo());

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
