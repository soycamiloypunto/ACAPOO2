/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acapoo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Access_Connection //Conexion a Base Local
{
    Connection conn = null;
    String servidor="jdbc:mysql://localhost:3306/database_cun";
    String user= "root"; //Nombre de Usuario
    String pass=""; //Clave de Usuario
    
    public Access_Connection(){
       //Verifico que haya conexión con la Base de Datos y si no existe reviento la conexión.
        try {
            conn=DriverManager.getConnection(servidor,user,pass);//establezco la conexión
        }catch ( SQLException e) {
            //System.out.println("Exception " + e);
            //return null;
        }
    }
  
    public synchronized Connection getConnection(){
        try {
            return DriverManager.getConnection(servidor,user,pass);//establezco la conexión
        }catch ( SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión con la base de datos.\nPor favor, verifique su conexión a internet o la configuración de su base de datos.");
            return null;
        }
    }

    public void desconectar(){
        try {
                conn.close();
            } catch (SQLException ex) {
            }
    } 
  
  
}
