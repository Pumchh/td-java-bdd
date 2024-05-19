
public class PolySportsDatabase extends MySQLDatabase {
    private static PolySportsDatabase instance = null;
    
    private PolySportsDatabase(){
        super("localhost", 3306, "poly_sports", "root", "");
    }

    public static PolySportsDatabase getInstance() {
        if(instance == null){
            instance = new PolySportsDatabase();
        }
    
        return instance;
    }

}
