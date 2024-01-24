import java.io.FileWriter;
import java.io.IOException;
public class Save  {
    private StringBuilder build;
    private Input user;

    public Save() throws Exception {
        build = new StringBuilder();
        user = new Input();
    }

    public void saveUser() {
        String str = build.append(user.getInfo().get(0)).append(" ")
                .append(user.getInfo().get(1)).append(" ")
                .append(user.getInfo().get(2)).append(" ")
                .append(user.getBirthDay1()).append(" ")
                .append(user.getPhoneNumber()).append(" ")
                .append(user.getMale()).toString();

        try (FileWriter writer = new FileWriter
                (   "./src/" + user.getInfo().get(0) + ".txt",true)) {
            writer.write(str);
            writer.write("\n");

        } catch (IOException e) {
            System.out.println("Ошибка при записи файла!");
            e.printStackTrace();
        }
    }
}
