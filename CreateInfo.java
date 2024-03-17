import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateInfo {

    public static ArrayList<String> createInfoList(){
    ArrayList<String> infoList = new ArrayList<>();
    for (int i = 0; i<6;i++){
        infoList.add(null);}
        try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Введите данные через пробел: фамилия имя отчество// дата рождения в формате dd.mm.YYYY // номер телефона // пол (f/m)");
        ArrayList<String> info = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        try {
            AddMethods.addFio(infoList, info.getFirst(),0);
            AddMethods.addFio(infoList, info.get(1),1);
            AddMethods.addFio(infoList, info.get(2),2);
            AddMethods.addDate(infoList, info.get(3),3);
            AddMethods.addPhoneNumber(infoList, info.get(4),4);
            AddMethods.addSex(infoList, info.get(5),5);}
        catch(NoSuchElementException e1){
            System.out.println("Пустая строка, необходимо ввести данные");
        }catch(IndexOutOfBoundsException e){
                System.out.println("Недостаточно данных");
        }
    }return infoList;}


    public static void toString(ArrayList<String> array){
    for (int i = 0; i < array.size(); i++) {
        System.out.print(i + " ");
        System.out.println(array.get(i));}
    }
}

