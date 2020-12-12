package LB_3;

public class lb3 {

    public static void ShowEmployeesIn(Employee[] employees){
        System.out.println("\nПрисутствующие работники:");
        for(Employee employee : employees){
            if(employee.isLocatedAtWork()){
                System.out.println(employee.getSurname());
            }
        }
    }

    public static void ShowEmployeesOut(Employee[] employees){
        System.out.println("\nОтсутствующие работники:");
        for(Employee employee : employees){
            if(!employee.isLocatedAtWork()){
                System.out.println(employee.getSurname());
            }
        }
    }

    public static void FindEmployee(Employee[] employees, String surname){
        for(Employee employee : employees){
            if (employee.getSurname().equals(surname)){
                System.out.println("\nInformation about employee: ");
                System.out.println(employee.getSurname());
                System.out.println(employee.getPosition());
                System.out.println(employee.getCertificate_number());
                System.out.println(employee.getDepartment());
                System.out.println(employee.getLast_entrance());
                System.out.println(employee.getLast_exit());
                break;
            }
        }
        System.out.println("\nNo results");
    }

    public static void main(String[] args) {

//        Предметна область: прохідна підприємства, клас: працівник, орієнтовний перелік полів:
//        прізвище, посада, відділ, номер посвідчення, присутній на території чи вийшов за межі,
//        час останнього входу чи виходу. Вивести окремо список працівників, присутніх на
//        території, та відсутніх. Реалізувати пошук даних працівника за вказаним прізвищем.


        Employee[] employees =  {
                new Employee("Krohaliow", true),
                new Employee("Okumura", true),
                new Employee("Uzumaki", false),
                new Employee("Shevchenko", false),
                new Employee("Light", true),
                new Employee("Ruzaki", false)
        };

        ShowEmployeesIn(employees);
        ShowEmployeesOut(employees);

        FindEmployee(employees, "Krohaliow");
    }
}
