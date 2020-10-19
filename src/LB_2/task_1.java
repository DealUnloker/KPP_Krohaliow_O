package LB_2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class task_1 {

    public static boolean isDateCorrect(String date){
        return date.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public static boolean isDateValid(String date) {
        try {
            final String DATE_FORMAT = "dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static String getUserInfo(){
        Scanner in = new Scanner(System.in);
        System.out.print("Input name: ");
        return in.nextLine();
    }
    public static void main() {

        String input;
        boolean check;
        do {
            input = getUserInfo();
            check = isDateCorrect(input);
            if (!check)
                System.out.println("Некорнектно введена дата");
        } while (!check);

        if(isDateValid(input)) {
            System.out.println("Такая дата существует");
        }else {
            System.out.println("Такой даты не существует");
        }
    }

}
