import java.util.ArrayList;
import java.util.Objects;

public class AddMethods {
    static final String[] DATA_EN = {"Surname", "Name", "Lastname", "Birthday", "PhoneNumber", "Sex"};
    static final String[] DATA_RU = {"Фамилия", "Имя", "Отчество", "Дата рождения", "Номер телефона", "Пол"};

    public static void addFio(ArrayList<String> array, String string, int index) throws NullPointerException {
        if (ValidDate.isDateValid(string.strip())) {
            array.set(3, string.strip());
            return;
        }
        if (isPhoneNumber(string)) {
            array.set(4, string.strip().strip());
            return;
        }
        if (isSexValid(string)) {
            array.set(5, string.strip().strip());
            return;
        }
        if (isAlphaRus(string.strip()) || isAlphaUsa(string.strip())) {
            array.set(index, (string.strip().substring(0, 1).toUpperCase() + string.strip().substring(1)));
        }
    }

    protected static boolean isAlphaRus(String string) {
        if (string.equals(CreateInfo.OUT_DATA)) return false;
        for (int i = 0; i < string.strip().length(); i++) {
            char s = string.strip().charAt(i);
            if (!(s >= 'А' && s <= 'Я') && !(s >= 'а' && s <= 'я')) {
                return false;
            }
        }
        return true;
    }

    protected static boolean isAlphaUsa(String string) {
        if (string.equals(CreateInfo.OUT_DATA)) return false;
        for (int i = 0; i < string.strip().length(); i++) {
            char s = string.strip().charAt(i);
            if (!(s >= 'A' && s <= 'Z') && !(s >= 'a' && s <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPhoneNumber(String string) {

        for (int i = 0; i < string.length(); i++)
            try {
                int res = Integer.parseInt(String.valueOf(string.charAt(i)));

            } catch (NumberFormatException e) {
                return false;
            }
        return true;
    }

    public static boolean isSexValid(String string) {
        String[] sex = {"f", "m", "female", "male", "ж", "м", "жен", "муж", "женский", "мужской"};
        for (String s : sex) {
            if (s.equals(string.strip())) {
                return true;
            }
        }
        return false;
    }

    public static void addPhoneNumber(ArrayList<String> array, String string, int index) {
        if (isPhoneNumber(string.strip()) && (string.strip().length() >= 5 && string.strip().length() <= 20)) {
            array.set(index, string.strip());
        }
    }

    public static void addDate(ArrayList<String> array, String string, int index) {
        if (ValidDate.isDateValid(string.strip())) {
            array.set(index, string);
        }
    }


    public static void addSex(ArrayList<String> array, String string, int index) {
        String[] sex_f = {"f", "female", "ж", "жен", "женский"};

        if (isSexValid(string.strip())) {
            for (String s : sex_f) {
                if (s.equals(string.strip())) {
                    array.set(index, "f");
                    return;
                }
                array.set(index, "m");
            }

        }
    }}
