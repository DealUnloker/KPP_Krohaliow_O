package semester_2.LB_1.part2.TeamEntity.Workers

import semester_2.LB_1.part2.HouseEntity.House

class Worker implements IWorker {
    @Override
    void Work(House house) {
        int indOfPartToBuilt = Check(house)
        if (indOfPartToBuilt >= 0) {
            house.parts[indOfPartToBuilt].usePart()
            house.parts[indOfPartToBuilt].setBuilt()
            println "Worker built a part"
        }
        else{
            println "No parts to build, resting..."
        }
    }

    private static int Check(House house) {
        house.parts.findIndexOf { !it.status() }
    }
}
