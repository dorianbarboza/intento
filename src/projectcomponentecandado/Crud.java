/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectcomponentecandado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dorian Barboza
 */
public class Crud {
    private ConexionMysql conexion = new ConexionMysql();
    private Connection con;
    private Statement st, st2;
    private ResultSet rs;

    public Crud() {
        try {
            if ((con = conexion.getConexionMYSQL()) == null) {
                JOptionPane.showMessageDialog(null, "ERROR: Coneccion Base de datos");
                return;
            }
            st = con.createStatement();
            st2 = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void passwordErroneosIngresados(String password_tusuario){
        try{
           String query = "INSERT INTO `tabla_login`(`password_tusuario`) VALUES ('"+password_tusuario+"');";
           //String query = "INSERT INTO `tabla_login`(`password_tusuario`,`user_tusuario`) VALUES ('"+password_tusuario+"','"+user_tusuario+"'); ";
           st.execute(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /*
    public void insertarDatos(String nombre_tdpersonales){
        try{
           String query = "INSERT INTO `TabladatosPersonales`"
                   + "(`nombre_tdpersonales`) "
                   + "VALUES ('"+nombre_tdpersonales+"',";
           st.execute(query);
        }catch(Exception e){
            e.printStackTrace();
        }

    
    }*/
    /*
    create table TabladatosPersonales (
nombre_tdpersonales varchar(20),
apellido_tdpersonales varchar(20),
carrera_tdpersonales varchar(20),
numcontrol_tdpersonales int
    );
    */
    //Devuelve el resultset con la lista de productos registrados en almacen con sus unidades
    public boolean passwordIngresados(String password_tusuario/*, String user_tusuario*/) {
        try {
            boolean condicion = false;
            String query = "SELECT * FROM tabla_usuario";
            rs = st.executeQuery(query);
           
            while(rs.next()){
                if(password_tusuario.equals(rs.getString("password_tusuario"))){
                    //if(user_tusuario.equals(rs.getString("user_tusuario"))){
                    condicion = true;
                    break;
                }
       //     }
            }
            return condicion;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

   /* boolean passwordIngresados(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/



    

    
}
