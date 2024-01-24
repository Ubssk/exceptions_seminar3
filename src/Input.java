import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Pattern;

public class Input implements Serializable {
    private Scanner scan;
    private int phoneNumber = 0;
    private String male;
    private LocalDate birthDay;
    private List<String> info;
    private DateTimeFormatter dt;
    private String birthDay1;
    String data;
    public Input() throws Exception
    {
        scan = new Scanner(System.in);
        info = new ArrayList<>();
        dt = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        data = dataUserInputInfo();
    }
    String dataUserInputInfo() throws PhoneNumberIncorrect, TimeIncorrect, SexIncorrect, UserIncorrect {
        System.out.println("Введите строку в формате Фамилия Имя Отчество датарождения(dd.mm.yyyy пол(f/m)" +
                " номертелефона через пробел ");
        String userInput = scan.nextLine();
        scan.close();
        ArrayList<String> userInfo = new ArrayList<>(List.of(userInput.split(" ")));

        if (userInfo.size() < 6) throw new RuntimeException("Error = -1 Вы ввели меньшее количество " +
                "данных, чем требуется!");
        if (userInfo.size() > 6) throw new RuntimeException("Error -2  Вы ввели большее количество данных," +
                " чем требуется или поставили больше пробелов !");
        for (int i = 0; i < userInfo.size(); i++) {
            if (userInfo.get(i).equals("f") || userInfo.get(i).equals("m")) {
                male = userInfo.get(i);

            } else if (Pattern.matches("[a-zA-Z]+", userInfo.get(i))) {
                info.add(userInfo.get(i));

            } else {

                try {
                    phoneNumber = Integer.parseInt(userInfo.get(i));

                } catch (NumberFormatException e) {
                    try {
                        birthDay = LocalDate.parse(userInfo.get(i), dt);
                    } catch (DateTimeParseException ignored) {

                    }
                }
            }
        }
        if (phoneNumber == 0) {
            throw new NumberFormatException("Не верный формат номера телефона! " +
                    "Номер телефон должен содержать только цифры!");
        }else if(String.valueOf(phoneNumber).length()!=7){
            throw new PhoneNumberIncorrect(" Не верный номер телефона! Количество цифр в номере телефона > или <  7 ");
        }else if(birthDay == null||birthDay.isAfter(LocalDate.now())){
            throw new TimeIncorrect("Не верный формат даты, либо дата больше текущей!");
        }else if(male == null){
            throw new SexIncorrect("Не определен пол, либо не корректно введен f/m");
        }else if(info.size()!=3){
            throw new UserIncorrect(" Не верно введены Ф.И.О.! Они должны содержать только английские буквы! " +
                    "Должны быть введены Фамилия Имя Отчество!");
        }
        else {
            StringBuilder str = new StringBuilder();
            str.append(info).append(" ").append(birthDay.format(dt)).append(" ").append(male)
                    .append(" ").append(phoneNumber);
            return str.toString();
        }
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getMale() {
        return male;
    }
    public LocalDate getBirthDay() {
        return birthDay;
    }

    public List<String> getInfo() {
        return info;
    }
    public DateTimeFormatter getDt(){
        return dt;
    }
    public String getBirthDay1(){
        return birthDay.format(dt);
    }
}