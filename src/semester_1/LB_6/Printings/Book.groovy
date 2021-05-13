package semester_1.LB_6.Printings

class Book extends Printing implements IBook{
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
        return "Книга ${this.Name} от ${this.Author}\n" +
                "Количество ${this.count}\n" +
                "Цена - ${this.Price}. Дата выпуска - ${this.ManufactureDate}.\n"
    }
}
