/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Conexion {
    
        public String db="proyectointegrado";
        public String url="jdbc:mysql://192.168.0.20/" + db ;
	public String user="usuario1";
	public String password="usuario-1";
        
    public Conexion() {
		
	}
	
	public Connection conectar() {
		Connection link=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			link=DriverManager.getConnection(this.url, this.user, this.password);
		} catch ( ClassNotFoundException | SQLException e) {
			JOptionPane.showConfirmDialog(null, e);
		}
	return link;
	}
    
}

