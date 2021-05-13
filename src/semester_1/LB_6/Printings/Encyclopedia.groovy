package semester_1.LB_6.Printings

class Encyclopedia extends Printing implements IBook, Serializable  {
    String topics

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
        return "Энциклопедия ${this.Name} от ${this.Author}.\n" +
                "Затрагиваемые темы - ${this.topics}\n" +
                "Количество ${this.count}\n" +
                "Цена - ${this.Price}. Дата выпуска - ${this.ManufactureDate}.\n"
    }
}
