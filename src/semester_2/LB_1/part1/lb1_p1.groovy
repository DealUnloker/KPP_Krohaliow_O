package semester_2.LB_1.part1

//  Создать класы: Company, Employer, President, Manager, Worker
//  Создать объект Company
//  Релиазовать запросы: получить информацию про число работников, объем зп который нужно выплатить


class lb1_p1 {
    static void main(String[] args) {
        Company company = new Company(true)
        company.invest(20_000)
        println "Now in our company is ${company.getEmployersQuantity()}"

        company.StartWork()
        println "Debt to employers is ${company.currentDebt} people"

        company.GiveEmployersSalary()
        company.StartWork()
        company.GiveEmployersSalary()

        println "Our expenses is ${company.expenses}"
//        workForAllMoney(company)
    }

    static void workForAllMoney(Company company) {
        while (company.expenses < company.budget) {
            company.StartWork()
            company.GiveEmployersSalary()
        }
    }
}
