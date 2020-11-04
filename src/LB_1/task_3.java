package LB_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class task_3 {
    public static void Read_Input(int [][] array, int M, int N){
        try{
            FileReader fA = new FileReader("inputs/custom2d_array.txt");
            Scanner input = new Scanner(fA);
            for (int i=0; i < M; i++){
                for (int j = 0; j < N; j++){
                    array[i][j] = input.nextInt();
                }
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

    public static void FillBoolVector(boolean [] vector, int [][] matrix, int M, int N){
        int positive_counter = 0;
        int negative_counter = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] >= 0)
                    positive_counter++;
                else
                    negative_counter++;
            }
            vector[i] = positive_counter > negative_counter;
            positive_counter = negative_counter = 0;
        }
    }

    public static void ShowVector(boolean[] vector){
        for (boolean b : vector )
            System.out.println(b);
    }

    public static void SortColumns(int[][] array, int M, int N){
        for (int j = 0; j < N; j++) {
            int []tmp_array = new int[M];
            for (int i = 0; i < M; i++) {
                tmp_array[i] = array[i][j];
            }
            Arrays.sort(tmp_array);
            for (int i = 0; i < M; i++) {
                array[i][j] = tmp_array[i];
            }
        }
    }


    public static void ShowMatrix(int [][] array, int M, int N){
        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%d", array[i][j]);
                if (j != N - 1)
                    System.out.print("\t");
            }
            if (i != M -1)
                System.out.print("\n");
        }
    }

    public static void main() {
        final int M = 3;
        final int N = 5;

        int [][] A = new int[M][N];
        boolean [] B = new boolean[M];
        Read_Input(A, M, N);

        // Задана матрица А = {aij} размерности m*n. Составить функцию для построения логического вектора B = {bi} по следующему правилу:
        // если в строке с номером k количество положительных элементов больше, чем количество отрицательных, то bk = 1 (true), иначе bk = 0 (false).
        System.out.println("Вектор B:");
        FillBoolVector(B, A, M, N);
        ShowVector(B);

        // Затем необходимо расположить элементы каждого столбца массива А в порядке увеличения.
        System.out.println("\nОтсортированная по столбцам матрца А");
        SortColumns(A, M, N);
        ShowMatrix(A, M, N);
    }
}
