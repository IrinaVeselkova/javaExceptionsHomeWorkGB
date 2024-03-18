import java.util.ArrayList;

public class AddMethods {

    public static void addFio(ArrayList<String> array, String string, int index) {
        if (ValidDate.isDateValid(string.strip())) {
            array.set(3, string.strip());
            return;
        }
        if (isPhoneNumber(string.strip())) {
            array.set(4, string.strip());
            return;
        }
        if (isSexValid(string.strip())) {
            array.set(5, string.strip());
            return;
        }
        if (isAlphaRus(string) || isAlphaUsa(string)) {
            array.set(index, string.strip());
        }
    }

    protected static boolean isAlphaRus(String string) {
        if (string == null) return false;
        for (int i = 0; i < string.strip().length(); i++) {
            char s = string.strip().charAt(i);
            if (!(s >= 'А' && s <= 'Я') && !(s >= 'а' && s <= 'я')) {
                return false;
            }
        }
        return true;
    }

    protected static boolean isAlphaUsa(String string) {
        if (string == null) return false;
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
        if (isSexValid(string.strip())) {
            array.set(index, String.format("%s", string.strip().charAt(0)));
        }

    }
}
