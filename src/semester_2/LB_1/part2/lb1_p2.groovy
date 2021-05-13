package semester_2.LB_1.part2

import semester_2.LB_1.part2.HouseEntity.House
import semester_2.LB_1.part2.TeamEntity.Team

// Реализовать программу "Строительство дома"

// Реализовать
// Класы: House, Basement, Walls, Door, Window, Roof;
//        Team, Worker, TeamLeader
// Интерфейсы: IWorker, IPart



class lb1_p2 {
    static void main(String[] args) {
        House house = new House(1, 4, 1, 4, 1)
        Team team = new Team()
        team.setNewHouse(house)
        team.Work()

        team = new Team()
        team.LoadHouse()
        team.Work()

        team = new Team()
        team.LoadHouse()
        team.Work()

        team = new Team()
        team.LoadHouse()
        team.Work()

        team.Work()
    }
}
