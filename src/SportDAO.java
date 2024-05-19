import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class SportDAO {
    private MySQLDatabase database;

    SportDAO(MySQLDatabase database){
        this.database = database;
    }

    ArrayList<Sport> findAll(){
        ArrayList<Sport> sports = new ArrayList<Sport>();
        try{
            ResultSet result = database.createStatement().executeQuery("SELECT * FROM sport;");
            while(result.next()){
                sports.add(new Sport(result.getInt("id"), result.getString("name"), result.getInt("required_participants")));
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return sports;
    }

    Sport findById(int id){
        Sport sport = null;
        try{
            String request = "SELECT * FROM sport WHERE id = " + id + ";";
            PreparedStatement statement = database.prepareStatement(request);
            ResultSet result = statement.executeQuery(request);
            if(result.next()){
                sport = new Sport(result.getInt("id"), result.getString("name"), result.getInt("required_participants"));
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return sport;
    }

    ArrayList<Sport> findByName(String name){
        ArrayList<Sport> sport = new ArrayList<Sport>();
        try{
            String request;
            request = "SELECT * FROM sport WHERE name LIKE '%" + name + "%' ORDER BY name;";
            PreparedStatement statement = database.prepareStatement(request);
            //System.out.println(request);
            ResultSet result = statement.executeQuery(request);
            while(result.next()){
                sport.add(new Sport(result.getInt("id"), result.getString("name"), result.getInt("required_participants")));
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return sport;
    }


}
