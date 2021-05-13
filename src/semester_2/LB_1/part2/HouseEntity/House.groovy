package semester_2.LB_1.part2.HouseEntity

import semester_2.LB_1.part2.HouseEntity.Parts.IPart
import semester_2.LB_1.part2.HouseEntity.Parts.Basement
import semester_2.LB_1.part2.HouseEntity.Parts.Door
import semester_2.LB_1.part2.HouseEntity.Parts.Roof
import semester_2.LB_1.part2.HouseEntity.Parts.Wall
import semester_2.LB_1.part2.HouseEntity.Parts.Window

class House {
    public def parts = new ArrayList<IPart>()
    public boolean isDone = false

    House() {
        LoadData()
    }

    House(int basement_count, int wall_count, int door_count, int window_count, int roof_count) {
        basement_count.times { parts << new Basement() }
        wall_count.times { parts << new Wall() }
        door_count.times { parts << new Door(feature: "Metallic") }
        window_count.times { parts << new Window(feature: "Special") }
        roof_count.times { parts << new Roof() }
    }


    def SaveData() {
        FileOutputStream fos = new FileOutputStream("data/house_status.set")
        ObjectOutputStream oos = new ObjectOutputStream(fos)
        this.parts.each { oos.writeObject(it) }
        oos.flush()
        oos.close()
        fos.close()
    }

    def LoadData() {
        FileInputStream fis = new FileInputStream("data/house_status.set")
        ObjectInputStream ois = new ObjectInputStream(fis)

        while (fis.available() > 0)
            this.parts << (ois.readObject() as IPart)
    }
}
