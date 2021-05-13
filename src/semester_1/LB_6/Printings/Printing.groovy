package semester_1.LB_6.Printings

abstract class Printing implements Serializable{
    protected String Name
    protected String Author
    protected Float Price
    protected Date ManufactureDate
    protected Integer Count

    Integer getCount() {
        return Count
    }

    void setCount(Integer count) {
        this.Count = count
    }

    String getName() {
        return Name
    }

    String getAuthor() {
        return Author
    }

    Float getPrice() {
        return Price
    }

    Date getManufactureDate() {
        return ManufactureDate
    }

    abstract String toString()
}
