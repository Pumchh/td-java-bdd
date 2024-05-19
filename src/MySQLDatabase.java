import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class MySQLDatabase {
    private String host;
    private int port;
    private String databaseName;
    private String user;
    private String password;
    private Connection connection = null;
    private static boolean driverLoaded =  false;

    public MySQLDatabase(String host, int port, String databaseName, String user, String password) {
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
        this.user = user;
        this.password = password;
    }

    public void connect(){
        try{
            connection = DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?allowMultiQueries=true",
                user,
                password);
            System.out.println("Connection established successfully");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        
    }

    public Statement createStatement(){
        try{
            return connection.createStatement();
        }catch(Exception SQLException){
            System.out.println("Error: " + SQLException);
            return null;
        }
    }

    private static void loadDriver(){
        try{
            if(driverLoaded == false){
                Class.forName("com.mysql.cj.jdbc.Driver");
                driverLoaded = true;
                System.out.println("Driver loaded successfully");
            }            
        }catch(Exception e){
            System.out.println("Error: " + e);
        }

    }

    public PreparedStatement prepareStatement(String request){
        try{
            return connection.prepareStatement(request);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
