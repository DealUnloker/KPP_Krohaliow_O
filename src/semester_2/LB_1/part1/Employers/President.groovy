package semester_2.LB_1.part1.Employers

class President extends Employer {
    private String PresidentSpell

    President(String name, String secondName, String middleName, float salary, String presidentSpell) {
        super(name, secondName, middleName, salary)
        PresidentSpell = presidentSpell
    }

    @Override
    void DoWork() {
        println "I am ${this.getClass().getSimpleName()}, ruling the company"
        println "!!! ${PresidentSpell} !!!"
    }

    @Override
    public String toString() {
        return "President{" +
                "Name='" + Name + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", Salary=" + Salary +
                ", PresidentSpell='" + PresidentSpell + '\'' +
                '}';
    }
}
