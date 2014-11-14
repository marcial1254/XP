package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel Rocha
 */
public class PostgresConn {
    
    private static Connection conexion;
    private static Statement sentencia;

    public static final String DRIVER = Constantes.POSTGRESQL_DRIVER;
    public static final String DBURL = Constantes.POSTGRESQL_DBURL;
    
    private static PostgresConn uniqueInstance = new PostgresConn();
    
    private PostgresConn(){};

    private static Connection createConnection() {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager
                    .getConnection(DBURL,
                            Constantes.POSTGRESQL_USER,
                            Constantes.POSTGRESQL_PASS);

            if (conexion != null) {
                System.out.println("Conexion exitosa!");
            } else {
                System.out.println("Conexion fallida!");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage()); 
        }
        return conexion;
    }

    /**
     * Executes the given SQL statement, which may be an INSERT, UPDATE, or
     * DELETE statement or an SQL statement that returns nothing, such as an SQL
     * DDL statement.
     *
     * @param sql
     * @return True if everything went well
     */
    public static boolean updateDB(String sql) {
        try {
            sentencia = createConnection().createStatement(
                    ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Executes the given SQL statement, which is a Select statement
     *
     * @param sql
     * @return
     */
    public static ResultSet consultar(String sql) {
        ResultSet resultado = null;
        try {
            sentencia = createConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La consulta fallo");
            return null;
        }
        System.out.println("La consulta Fue Exitosa");
        return resultado;
    }

    public static PostgresConn getInstance() {
        return uniqueInstance;
    }
}
