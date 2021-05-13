package semester_2.LB_1.part1.Employers

class Manager extends Employer{
    private String SpecialManagerTrick;

    Manager(String name, String secondName, String middleName, float salary, String specialManagerTrick) {
        super(name, secondName, middleName, salary)
        SpecialManagerTrick = specialManagerTrick
    }

    @Override
    void DoWork() {
        println "I am ${this.getClass().getSimpleName()} managing here"
        println "->>> ${SpecialManagerTrick} <<<-"
    }

    @Override
    public String toString() {
        return "Manager{" +
                "Name='" + Name + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", Salary=" + Salary +
                ", SpecialManagerTrick='" + SpecialManagerTrick + '\'' +
                '}';
    }
}
