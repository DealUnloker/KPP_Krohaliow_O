package semester_1.LB_6.Printings

class Textbook extends Printing implements IBook{

    int forClass

    @Override
    void Rename(String name) {
        this.Name = name
    }

    @Override
    void ChangePrice(Float price) {
        this.Price = price
    }

    @Override
    String toString() {
        return "Учебник ${this.Name} от ${this.Author} для ${this.forClass} класса.\n" +
                "Количество ${this.count}\n" +
                "Цена - ${this.Price}. Дата выпуска - ${this.ManufactureDate}.\n"
    }
}
