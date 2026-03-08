import java.util.HashMap;
import java.util.Scanner;

public class LoginService {
    HashMap<String, String> users = new HashMap<>();

    public LoginService() {

        // Default admin login
        users.put("admin", "1234");
    }

    public boolean login() {

        Scanner sc = new Scanner(System.in);

        int attempts = 3;

        while (attempts > 0) {

            System.out.println("===== LOGIN SYSTEM =====");

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            if (users.containsKey(username) && users.get(username).equals(password)) {

                System.out.println("Login Successful\n");
                return true;
            }

            else {

                attempts--;

                System.out.println("Invalid Login. Attempts left: " + attempts);
            }
        }

        System.out.println("Too many failed attempts. System Exit.");

        return false;
    }
}
