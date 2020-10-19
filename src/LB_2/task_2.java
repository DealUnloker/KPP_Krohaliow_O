package LB_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task_2 {

    public static void GetLinesFromUser(List<String> lines, int limit){
        boolean gonext = true;
        Scanner in = new Scanner(System.in);
        String line;
        do {
            line = in.nextLine();
            if (line.equals("break"))
                gonext = false;
            else if (limit < line.length() || line.length() == 0)
                System.out.println("String is wrong!");
            else
                lines.add(line);
        }while(gonext);
        in.close();
    }

    public static void CutString(List<String> lines, int end){
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, lines.get(i).substring(0, end));
        }
    }

    public static int GetMinimumStringLength(List<String> lines){
        int minimum = lines.get(0).length();
        for (int i = 1; i < lines.size(); i++) {
            if(lines.get(i).length() < minimum)
                minimum = lines.get(i).length();
        }
        return minimum;
    }


    public static void main() {
        final int LIMIT = 40;

        List<String> lines = new ArrayList<>();

        GetLinesFromUser(lines, LIMIT);

        int minimum_length = GetMinimumStringLength(lines);
        CutString(lines, minimum_length);

        System.out.println(lines);
    }
}
