import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        
        PolySportsDatabase base = PolySportsDatabase.getInstance();
        base.connect();
        base.createStatement();
        SportDAO dao = new SportDAO(base);
        System.out.println(dao.findAll());
        System.out.println(dao.findById(1).getName());
        System.out.println(dao.findById(14));
        System.out.println(dao.findByName("Basket"));

        System.out.println("Entrez un nom de sport : ");
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();

        System.out.println(dao.findByName(input));

    }

}


