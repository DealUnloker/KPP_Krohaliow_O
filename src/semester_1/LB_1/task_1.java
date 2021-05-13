package semester_1.LB_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class task_1 {
    static final String filename = "inputs/1d_array.txt";
    static final Integer ARRAY_SIZE = 5;

    public static void Read_Input(Integer [] array, int size){
        try{
            FileReader fA = new FileReader(filename);
            Scanner input = new Scanner(fA);
            for (int i=0; i < size; i++){
                array[i] = input.nextInt();
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            System.exit(1);
        } catch (InputMismatchException e){
            System.out.println("Неправльная запись");
            System.exit(2);
        } catch (NoSuchElementException e){
            System.out.println("Недостаточно елементов");
            System.exit(3);
        }
    }

    public static int GetMaxValueIndex(Integer[] array) {
        int maxValue = array[0];
        int index = 0;
        for(int i=1;i < array.length;i++){
            if(array[i] > maxValue){
                maxValue = array[i];
                index = i;
            }
        }
        return index;
    }

    public static int CountNegativeNumbersUntil(Integer [] array, int end){
        int counter = 0;
        for (int i = 0; i < end; i++) {
            if (array[i] < 0)
                counter++;
        }
        return counter;
    }

    public static void PrintAnswer(Integer[] array){
        for (Integer integer : array) {
            System.out.printf("%d ", integer);
        }
    }

    public static void run() {
        Integer [] array = new Integer [ARRAY_SIZE];
        Read_Input(array, ARRAY_SIZE);

        // Орпеделение индекса максимального числа
        int max_value_index = GetMaxValueIndex(array);
        int max_value = array[max_value_index];

        // Определить число отрицательных элементов, расположенных перед самым большим положительным элементом одномерного массива, размерности N.
        int count_of_negative_numbers = CountNegativeNumbersUntil(array, max_value_index);

        // Если искомое число отрицательных элементов будет равен 0, то отсортировать в порядке убывания элементы расположеные
        // после наибольшего положительного элемента.

        if (count_of_negative_numbers == 0 && max_value > 0)
            Arrays.sort(array, max_value_index, array.length, Collections.reverseOrder());

        System.out.println("Массив чисел:");
        PrintAnswer(array);
    }
}
