
public class Main {
    public static void main(String[] args) {
        try {
            Save user = new Save();
            user.saveUser();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}