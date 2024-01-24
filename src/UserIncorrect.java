import java.io.IOException;

public class UserIncorrect extends IOException {
    public UserIncorrect(String message){
        super(message);
    }
}