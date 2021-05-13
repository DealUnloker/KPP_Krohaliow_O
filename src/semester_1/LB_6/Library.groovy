package semester_1.LB_6

import semester_1.LB_6.Printings.Book
import semester_1.LB_6.Printings.Encyclopedia
import semester_1.LB_6.Printings.Journal
import semester_1.LB_6.Printings.Printing
import semester_1.LB_6.Printings.Textbook


// Ієрархія класів: журнал, книга, друковане видання, підручник;
//Створити додаток «Бібліотека» або «Книжковий магазин».
//Варіант запита: найменування всіх книг в бібліотеці (магазині), що вийшли не раніше зазначеного року;


class Library {

    static final String filename = "data/libdata.ser"

    def collection = []

    private static def CreateBooks() {

        def collection = []

        collection << new Textbook(Name: "Математика", forClass: 6, Author: "Авраменко", Price: 56.3,
                ManufactureDate: new Date(), count: 12)

        collection << new Book(Name: "Книжечка", Author: "Автор", Price: 123.3, ManufactureDate: new Date(), count: 15)

        collection << new Journal(Name: "Forbes", Author: "IDK", Price: 1337, ManufactureDate: new Date(),
                edition: "Premium", count: 34)

        collection << new Encyclopedia(Name: "GoodEnc...", Author: "SmartHuman", Price: 500, ManufactureDate: new Date(),
                count: 53, topics: "Java, Groovy")

        return collection
    }

    Library(createFromDefault = false) {
        if (createFromDefault) {
            collection = CreateBooks()
            SaveData()
        } else
            LoadData()
    }

    def SaveData() {
        FileOutputStream fos = new FileOutputStream(filename)
        ObjectOutputStream oos = new ObjectOutputStream(fos)
        this.collection.each { oos.writeObject(it) }
        oos.flush()
        oos.close()
        fos.close()
    }

    def LoadData() {
        FileInputStream fis = new FileInputStream(filename)
        ObjectInputStream ois = new ObjectInputStream(fis)

        while (fis.available() > 0)
            this.collection << ois.readObject()
    }

    def Add(Printing print) {
        this.collection << print
    }

    def RemoveByName(String name) {
        this.collection.removeIf { it.Name == name }
    }

    def EditCountByName(String name, Integer count) {
        this.collection
                .find { it.Name == name }
                .setCount(count)
    }

    def SortByName() {
        this.collection.sort { it.Name }
    }

    def FindByName(String name) {
        this.collection.find {it.Name == name}
    }


    static void main(String[] args) {
        def lib = new Library()

//        def lib = new Library(true)
//        lib.RemoveByName("Математика")
//        lib.EditCountByName("Математика", 123333)
//        lib.SortByName()
//        println lib.FindByName("Математика")

//        lib.collection.each { println it }
    }
}
