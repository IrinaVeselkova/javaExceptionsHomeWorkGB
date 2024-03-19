
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные через пробел: фамилия имя отчество// дата рождения в формате dd.mm.YYYY // номер телефона // пол (f/m)");
        ArrayList<String> info = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        ArrayList<String> infoList = CreateInfo.createInfoList(info);
        int index = CreateInfo.checkInfo(infoList);
        while (index != -1) {
            String string = " ";
            System.out.println("Вы ввели недостаточно данных или их формат не поддерживается. " + AddMethods.DATA_RU[index] + " -> ");
            string = scanner.nextLine();
            switch (index) {
                case 0, 1, 2:
                    AddMethods.addFio(infoList, string, index);
                    break;
                case 3:
                    AddMethods.addDate(infoList, string, index);
                    break;
                case 4:
                    AddMethods.addPhoneNumber(infoList, string, index);
                    break;
                case 5:
                    AddMethods.addSex(infoList, string, index);
                    break;
            }
            index = CreateInfo.checkInfo(infoList);
        }
        scanner.close();
        try (FileWriter writer = new FileWriter(infoList.getFirst() + ".txt", true)) {
            writer.write(CreateInfo.toString(infoList).toString());
            writer.write("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());}
    }
}
