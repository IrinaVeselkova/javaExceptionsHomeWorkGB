import java.util.ArrayList;

public class AddMethods {

    public static void addFio(ArrayList<String> array, String string,int index) {
        if(ValidDate.isDateValid(string.strip()))
        {array.set(3, string.strip());
        return;}
        if (isAlphaRus(string) || isAlphaUsa(string)) {
            array.set(index, string.strip());
        } 
    }

    protected static boolean isAlphaRus(String string) {
        if (string == null) return false;
        for (int i = 0; i < string.length(); i++) {
            char s = string.charAt(i);
            if (!(s >= 'А' && s <= 'Я') && !(s >= 'а' && s <= 'я')) {
                return false;
            }
        }
        return true;
    }

    protected static boolean isAlphaUsa(String string) {
        if (string == null) return false;
        for (int i = 0; i < string.length(); i++) {
            char s = string.charAt(i);
            if (!(s >= 'A' && s <= 'Z') && !(s >= 'a' && s <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPhoneNumber(String string) {
        long phoneNumber = 0;
        try {
            phoneNumber = Long.parseLong(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Формат номера телефона не поддерживается");
        }
        return false;
    }

    public static void addPhoneNumber(ArrayList<String> array, String string,int index) {

        if (isPhoneNumber(string) && (string.length() >= 5 && string.length() <= 20)) {
            array.set(index,string);
        } 
    }

    public static void addDate(ArrayList<String> array, String string,int index) {
        if (ValidDate.isDateValid(string)) {
            array.set(index,string);
        } 
    }

    public static final void addSex(ArrayList<String> array, String string,int index) {
        String[] sex = {"f", "m", "female", "male", "ж", "м", "жен", "муж", "женский", "мужской"};
        String res = null;
        for (String s : sex) {
            if (s.equals(string)) {
                res = s;
                break;}
        }
        try{
            array.set(index,String.format("%s",res.charAt(0)));}
        catch(NullPointerException e){
            System.out.println("Неверно указан пол");
           }
    }
}
