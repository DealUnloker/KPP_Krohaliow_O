package semester_2.LB_1.part1.Employers

class Worker extends Employer {
    Worker(String name, String secondName, String middleName, float salary) {
        super(name, secondName, middleName, salary)
    }

    @Override
    void DoWork() {
        println "I am ${this.getClass().getSimpleName()}, doing work"
    }

    @Override
    public String toString() {
        return "Worker{" +
                "Name='" + Name + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}
