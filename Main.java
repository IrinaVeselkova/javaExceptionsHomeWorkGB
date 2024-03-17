import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.DataFormatException;

public class Main {

    /*Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:

Фамилия Имя Отчество дата _ рождения номер _ телефона пол

Форматы данных:

фамилия, имя, отчество - строки
дата _ рождения - строка формата dd.mm.yyyy
номер _ телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно распарсить полученную строку и выделить из них требуемые значения. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
<Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>
Веселкова Ирина Викторовна 26.01.1987 7914052601 f
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.*/
    public static void main(String[] args) {
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
            catch(IndexOutOfBoundsException e){
                System.out.println("Недостаточно данных");
                for (int i = 0; i < infoList.size(); i++) {
                    System.out.print(i + " ");
                    System.out.println(infoList.get(i));
                }
            }
        }
    }
}
