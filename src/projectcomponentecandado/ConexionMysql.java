
package projectcomponentecandado;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dorian Barboza
 */
public class ConexionMysql {
    private String userBD = "root";
    private String passwordBD = "";
    private String hostBD = "localhost";
    private String nameDatabase = "projectcomponente_bd";
    private Connection connectBd = null;
    
    public ConexionMysql(){
    }
    
    public Connection getConexionMYSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance( );
            String servidor = "jdbc:mysql://"+hostBD+"/"+nameDatabase;
            connectBd = DriverManager.getConnection(servidor,userBD,passwordBD);
            return connectBd;
        }catch(Exception e){
            e.printStackTrace();
            return connectBd;
        }
    }
    
}
