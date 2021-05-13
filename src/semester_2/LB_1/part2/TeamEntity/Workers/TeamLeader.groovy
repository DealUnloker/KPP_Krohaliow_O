package semester_2.LB_1.part2.TeamEntity.Workers

import semester_2.LB_1.part2.HouseEntity.House

class TeamLeader implements IWorker {
    @Override
    void Work(House house) {
        def info = CountCompletedParts(house.parts)

        println "###### REPORT ########"
        info.take(5).each {
            println "${it.value} ${it.key} built"
        }

        int count = house.parts.size()
        int total = info['Total']

        def percent = total * 100 / count
        println "Total = ${total}/${count} (${percent}%)"
        println "#####################"
        if (total == count){
            house.isDone = true
        }
    }

    static void main(String[] args) {
        TeamLeader teamlead = new TeamLeader()
        House house = new House(2, 2, 2, 2, 2)
        house.parts[0].setBuilt()
        house.parts[4].setBuilt()
        house.parts[3].setBuilt()
        teamlead.Work(house)
    }

    private static def CountCompletedParts(def parts) {
        def info = ["Basement": 0, "Wall": 0, "Door": 0,
                    "Window"  : 0, "Roof": 0, "Total": 0]

        parts.each {
            if (it.status()) {
                info[it.getClass().getSimpleName()] = info[it.getClass().getSimpleName()] + 1
                info['Total'] = info['Total'] + 1
            }
        }

        return info
    }
}
