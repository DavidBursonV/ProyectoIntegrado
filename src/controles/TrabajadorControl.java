/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import datos.DatosCliente;
import datos.DatosTrabajador;
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
public class TrabajadorControl {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public int totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Primer Apellido", "Segundo Apellido",
            "Documento", "Num Documento", "Direccion", "Telefono", "Email", "Sueldo", "Acceso", "Login", "Contraseña","Estado"};

        String[] registro = new String[14];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT p.idpersona,p.nombre,p.primer_apellido, p.seg_apellido, p.tipo_documento, p.num_dni,"
                + " p.direccion, p.telefono, p.email, t.sueldo, t.acceso, t.login, t.password, t.estado FROM persona p inner join trabajador t"
                + " on p.idpersona=t.idpersona Where num_dni LIKE '%"
                + buscar + "%' ORDER BY idpersona desc";
        
        

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            //bucle para recorrer el resultSet y que muestre los productos
            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("primer_apellido");
                registro[3] = rs.getString("seg_apellido");
                registro[4] = rs.getString("tipo_documento");
                registro[5] = rs.getString("num_dni");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("sueldo");
                registro[10] = rs.getString("acceso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("password");
                registro[13] = rs.getString("estado");
                

                
                modelo.addRow(registro);
                totalregistros = rs.getRow();
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    //Método para insertar datos en la bd con preparedStatement y un condicional para verificar si el registro es diferente a 0
    public boolean insertar(DatosTrabajador dts) {
        sSQL = "INSERT INTO persona (nombre, primer_apellido ,seg_apellido,tipo_documento, num_dni, direccion, telefono, email)"
                + "values(?,?,?,?,?,?,?,?)";

        sSQL2 = "INSERT INTO trabajador (idpersona, sueldo, acceso, login, password, estado)"
                + "values((SELECT idpersona FROM persona ORDER BY idpersona DESC LIMIT 1),?,?,?,?,? )";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getPrimer_apellido());
            pst.setString(3, dts.getSeg_apellido());
            pst.setString(4, dts.getTipo_documneto());
            pst.setString(5, dts.getNum_dni());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());

            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(DatosTrabajador dts) {

        sSQL = "UPDATE persona SET nombre=?, primer_apellido=?, seg_apellido=?, tipo_documento=?, num_dni=?, direccion=?, telefono=?,email=?"
                + "WHERE idpersona=?";

        sSQL2 = "UPDATE trabajador SET sueldo=?, acces=?, login=?, password=?, estado=? WHERE idpersona=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getPrimer_apellido());
            pst.setString(3, dts.getSeg_apellido());
            pst.setString(4, dts.getTipo_documneto());
            pst.setString(5, dts.getNum_dni());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            pst.setInt(9, dts.getIdpersona());

            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());
            pst2.setInt(6, dts.getIdpersona());
            
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(DatosTrabajador dts) {

        sSQL = "DELETE FROM trabajador WHERE idpersona=?";
        sSQL2 = "DELETE FROM persona WHERE idpersona=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setInt(1, dts.getIdpersona());

            pst2.setInt(1, dts.getIdpersona());
            
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }
    
    
    
     public DefaultTableModel login (String login, String password) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Primer Apellido", "Segundo Apellido","Acceso", "Login", "Contraseña","Estado"};

        String[] registro = new String[8];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT p.idpersona,p.nombre,p.primer_apellido, p.seg_apellido,"
                + " t.acceso, t.login, t.password, t.estado FROM persona p inner join trabajador t"
                + " on p.idpersona=t.idpersona Where t.login ='"
                + login + "' and t.password='" +password+ "' and t.estado='Activado'";
        
        

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            //bucle para recorrer el resultSet y que muestre los productos
            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("primer_apellido");
                registro[3] = rs.getString("seg_apellido");
                registro[4] = rs.getString("acceso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("estado");
                

                
                modelo.addRow(registro);
                totalregistros = rs.getRow();
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
}
