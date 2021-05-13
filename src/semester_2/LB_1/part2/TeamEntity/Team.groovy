package semester_2.LB_1.part2.TeamEntity

import semester_2.LB_1.part2.HouseEntity.House
import semester_2.LB_1.part2.TeamEntity.Workers.IWorker
import semester_2.LB_1.part2.TeamEntity.Workers.TeamLeader
import semester_2.LB_1.part2.TeamEntity.Workers.Worker

class Team {
    private House house
    private def workers = new ArrayList<IWorker>()

    Team() {
        workers.add(new Worker())
        workers.add(new Worker())
        workers.add(new Worker())
        workers.add(new TeamLeader())
    }

    void setNewHouse(House house) {
        this.house = house
    }

    void Work() {
        if (!house.isDone) {
            workers.each { it.Work(house) }
            this.Save()
        }
        else{
            println "Mission completed, House is built"
        }
    }

    private void Save() {
        house.SaveData()
    }

    void LoadHouse() {
        house = new House()
    }

    static void main(String[] args) {
        Team team = new Team()
//        team.setNewHouse(new House(2, 2, 2, 2, 2))
        team.LoadHouse()
        team.Work()
    }
}
