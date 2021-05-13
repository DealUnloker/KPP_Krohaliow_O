package semester_2.LB_1.part2.HouseEntity.Parts

class Roof implements IPart{
    private def isBuilt = false
    String feature = 'default'

    @Override
    void setBuilt() {
        isBuilt = true
    }

    @Override
    boolean status() {
        return isBuilt
    }

    @Override
    void usePart() {
        println "Using Roof"
    }
}
