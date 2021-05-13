package semester_2.LB_1.part1

import semester_2.LB_1.part1.Employers.Employer
import semester_2.LB_1.part1.Employers.Manager
import semester_2.LB_1.part1.Employers.President
import semester_2.LB_1.part1.Employers.Worker

class Company {
    private def employers = []
    public float budget = 0
    public float currentDebt = 0
    public float expenses = 0

    static def generateEmployers() {
        def list = []

        list << new Worker("Христофор", "Андрианов", "Богданович", 500.3)
        list << new Worker("Диана", "Шарипова", "Кирилловна", 530.5)
        list << new Worker("Зиновий", "Данилов", "Русланович", 534.5)
        list << new Worker("Аваз", "Гуров", "Максимович", 532.2)
        list << new Worker("Вениамин", "Каменский", "Святославович", 536.5)

        list << new Manager("Изяслав", "Ковалевский", "Николаевич", 700, "Trick1")
        list << new Manager("Инна", "Фомова", "Станиславовна", 720, "Trick2")

        list << new President("Елизавета", "Леонова", "Геннадиевна", 1400, "Spell")

        return list
    }

    public Company(isExample = false) {
        if (isExample)
            employers = generateEmployers()
    }

    public Company(Collections employers) {
        this.employers.addAll(employers)
    }

    public int getEmployersQuantity() {
        employers.size()
    }

    public void invest(float money) {
        this.budget += money
        println "Ура нам инвестировали ${money}\$\n" +
                "Теперь у нас ${this.budget}\$"
    }

    public void StartWork() {
        employers.forEach {
            Employer employer ->
                employer.DoWork()
                this.currentDebt += employer.salary
        }
    }

    public void GiveEmployersSalary() {
        this.expenses += currentDebt
        employers.forEach {
            Employer employer ->
                employer.cash += employer.salary
                println "${employer.name} ${employer.secondName} получил зарплату"
                this.currentDebt -= employer.salary
        }
    }
}
