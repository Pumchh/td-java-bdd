

public class Sport {
    private int id = 0;
    private String name;
    private int requiredParticipants;
    
    public Sport(int id, String name, int requiredParticipants){
        this.id = id;
        this.name = name;
        this.requiredParticipants = requiredParticipants;
    }

    public int getId(){
        try{
            return id;
        }catch(Exception e){
            return 0;
        }
            
    }

    public String getName(){
        try{
            return name;
        }catch(Exception e){
            return "";
        }
    }

    public int getRequiredParticipants(){
        try{
            return requiredParticipants;
        }catch(Exception e){
            return 0;
        }
    }

}
