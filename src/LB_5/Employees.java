package LB_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Employees {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id){ return employees.get(id); }

    public void ShowSurNamesEmployees(){
        for (Employee employee : employees){
            System.out.println(employee.getSurname());
        }
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public int getCountOfEmployees(){
        return employees.size();
    }

    public void deleteEmployeeBySurname(String surname){
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).getSurname().equals(surname)){
                employees.remove(i);
                return;
            }
        }
        System.out.println("Employee is not found!");
    }

    public void deleteEmployeeById(int id){
        employees.remove(id);
    }

    public void saveToFile(String fileName){
        File file = new File(fileName);

        try{
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
            for(Employee employee : employees){
                outputStream.writeObject(employee);
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл для записи данных не создан - " + e.getMessage());
        } catch (IOException e){
            System.out.println("Ошибка записи данных - " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName){
        File file = new File(fileName);
        employees = new ArrayList<>();
        Employee employee = null;
        ObjectInputStream inputStream = null;
        try{
            FileInputStream fileIn = new FileInputStream(file);
            inputStream = new ObjectInputStream(fileIn);
            while (true){
                try {
                    employee = (Employee) inputStream.readObject();
                    employees.add(employee);
                } catch (EOFException e){
                    break;
                }
            }
            inputStream.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public void sort(){
        for (int k=0; k < employees.size() - 1; k++){
            Employee min = employees.get(k);
            int iMin = k;
            for (int i = k; i<employees.size(); i++){
                if (min.compareTo(employees.get(i))> 0){
                    min = employees.get(i);
                    iMin = i;
                }
            }
            employees.remove(iMin);
            employees.add(k, min);
        }
    }

    public String[][] GetArrayOfSurnamesAndDepartments(){
        String[][] array = new String[employees.size()][2];
        for (int i = 0; i < employees.size(); i++){
            array[i][0] = employees.get(i).getSurname();
            array[i][1] = employees.get(i).getDepartment();
        }
        return array;
    }

    public int size(){
        return employees.size();
    }
}
