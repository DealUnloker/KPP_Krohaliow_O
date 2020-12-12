package LB_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class task_1 {
    public static void Read_Input(int [] array, int size){
        try{
            FileReader fA = new FileReader("inputs/1d_array.txt");
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

    public static int max(int[] array) {
        int maxValue = array[0];
        for(int i=1;i < array.length;i++){
            if(array[i] > maxValue){
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public static int GetIndex(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]){
                return i;
            }
        }
        return -1;
    }

    public static int CountNegativeNumbersUntil(int [] array, int end){
        int counter = 0;
        for (int i = 0; i < end; i++) {
            if (array[i] < 0)
                counter++;
        }
        return counter;
    }

    public static void ChangeSign(int[] array){
        for (int i = 0; i < array.length; i++){
            array[i] *= -1;
        }
    }

    public static void SpecialSort(int[] array, int max_value_index){
        ChangeSign(array);
        Arrays.sort(array, max_value_index, array.length);
        ChangeSign(array);
    }

    public static void PrintAnswer(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d", array[i]);
            if (i != array.length - 1) { //no
                System.out.print(" ");
            }
        }
    }

    public static void main() {
        final int ARRAY_SIZE = 5;

        int [] array = new int [ARRAY_SIZE];
        Read_Input(array, ARRAY_SIZE);

        // сразу определить индекс максимального числа
        int max_value = max(array);
        int max_value_index = GetIndex(max_value, array);
        // Определить число отрицательных элементов, расположенных перед самым большим положительным элементом одномерного массива, размерности N.
        int count_of_negative_numbers = CountNegativeNumbersUntil(array, max_value_index);

        // Если искомое число отрицательных элементов будет равен 0, то отсортировать в порядке убывания элементы расположеные
        // после наибольшего положительного элемента.
        if (count_of_negative_numbers == 0 && max_value > 0) {
            SpecialSort(array, max_value_index);
        }

        System.out.println("Массив чисел:");
        PrintAnswer(array);
    }
}
