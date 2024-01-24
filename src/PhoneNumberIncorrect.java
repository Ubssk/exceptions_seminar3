import java.io.IOException;

public class PhoneNumberIncorrect extends IOException {
    public PhoneNumberIncorrect(String message) {
        super(message);
    }
}