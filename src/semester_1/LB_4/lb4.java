package semester_1.LB_4;

public class lb4 {

    public static void AddEmployees(Employees employees){
        employees.addEmployee(new Employee("Krohaliow", true, 5));
        employees.addEmployee(new Employee("Okumura", true, 1));
        employees.addEmployee(new Employee("Uzumaki", false, 3));
        employees.addEmployee(new Employee("Shevchenko", false, 2));
        employees.addEmployee(new Employee("Light", true, 9));
        employees.addEmployee(new Employee("Ruzaki", false));
    }

    public static void main(String[] args) {
        String filename = "data/employees.ser";
        Employees employees = new Employees();

        // Create and save employees
        AddEmployees(employees);
        employees.saveToFile(filename);

        // Load and show employees from file
        employees.loadFromFile(filename);
        employees.deleteEmployeeBySurname("Krohaliow");
        employees.addEmployee(new Employee("Mika", true, 2));
        employees.sort();
        employees.ShowSurNamesEmployees();
    }
}
