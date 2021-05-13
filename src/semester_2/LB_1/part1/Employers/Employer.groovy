package semester_2.LB_1.part1.Employers

abstract class Employer {
    protected String Name
    protected String SecondName
    protected String MiddleName
    protected float Salary
    public float cash

    Employer(String name, String secondName, String middleName, float salary) {
        Name = name
        SecondName = secondName
        MiddleName = middleName
        Salary = salary
    }

    abstract void DoWork()

    String getName() {
        return Name
    }

    void setName(String name) {
        Name = name
    }

    String getSecondName() {
        return SecondName
    }

    void setSecondName(String secondName) {
        SecondName = secondName
    }

    String getMiddleName() {
        return MiddleName
    }

    void setMiddleName(String middleName) {
        MiddleName = middleName
    }

    float getSalary() {
        return Salary
    }

    void setSalary(float salary) {
        Salary = salary
    }

    abstract String toString()
}
