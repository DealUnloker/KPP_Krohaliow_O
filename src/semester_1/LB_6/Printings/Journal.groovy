package semester_1.LB_6.Printings

class Journal extends Printing{

    String edition;

    String getEdition() {
        return edition
    }

    @Override
    String toString() {
        return "Журнал ${this.Name} ${this.edition} от ${this.Author}.\n" +
                "Количество ${this.count}\n" +
                "Цена - ${this.Price}. Дата выпуска - ${this.ManufactureDate}.\n"
    }
}
