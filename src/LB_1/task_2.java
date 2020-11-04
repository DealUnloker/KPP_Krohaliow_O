package LB_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class task_2 {
    public static void Read_Input(int [][] array){
        try{
            FileReader fA = new FileReader("inputs/2d_array.txt");
            Scanner input = new Scanner(fA);
            for (int i=0; i < array.length; i++){
                for (int j = 0; j < array.length; j++){
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

    public static float RatioOfNegativeAndPositiveNumbers(int [][] array){
        int positive_counter = 0;
        int negative_counter = 0;
        for (int []sub_array: array){
            for (int element : sub_array){
                if (element >= 0)
                    positive_counter++;
                else
                    negative_counter++;
            }
        }
        return (float) positive_counter / negative_counter;
    }

    public static void SpecialFunc(int [][] A, int[][] B){
        for (int i = 0; i < A.length; i++) {
            System.arraycopy(A[A.length - 1 - i], 0, B[i], 0, A.length);
        }
    }

    public static void ShowMatrix(int [][] array){
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.printf("%d", array[i][j]);
                if (j != array.length - 1)
                    System.out.print(" ");
            }
            if (i != array.length -1)
                System.out.print("\n");
        }
    }

    public static void main() {
        final int MATRIX_SIZE = 5;

        int [][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];

        Read_Input(matrix);

        // В матрице А найти отношение количества положительных элементов к количеству отрицательных.
        System.out.println("Соотношение положительных и отрицательных чисел");
        float numbers_ratio = RatioOfNegativeAndPositiveNumbers(matrix);
        System.out.println(numbers_ratio);


        // Матрицу В образовать из матрицы А,
        // отразив её симметрично относительно среднего строки.
        System.out.println("\nОтраженная симетрично Матрица Б");
        int [][] matrix2 = new int[MATRIX_SIZE][MATRIX_SIZE];
        SpecialFunc(matrix, matrix2);
        ShowMatrix(matrix2);

    }
}
