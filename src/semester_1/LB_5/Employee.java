package semester_1.LB_5;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable, Comparable<Employee> {
    private String surname;
    private String position = "manager";
    private String department = "UFSDF";
    private int Rank = 0;
    private int certificate_number = 1;
    private boolean isLocatedAtWork;
    private Date last_entrance = new Date(System.currentTimeMillis());
    private Date last_exit = new Date(System.currentTimeMillis());

    public String getSurname() {
        return surname;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCertificate_number() {
        return certificate_number;
    }

    public void setCertificate_number(int certificate_number) {
        this.certificate_number = certificate_number;
    }

    public boolean isLocatedAtWork() {
        return isLocatedAtWork;
    }

    public void setLocatedAtWork(boolean locatedAtWork) {
        isLocatedAtWork = locatedAtWork;
    }

    public Date getLast_entrance() {
        return last_entrance;
    }

    public void setLast_entrance(Date last_entrance) {
        this.last_entrance = last_entrance;
    }

    public Date getLast_exit() {
        return last_exit;
    }

    public void setLast_exit(Date last_exit) {
        this.last_exit = last_exit;
    }

    public Employee(String surname, boolean isLocatedAtWork) {
        this.surname = surname;
        this.isLocatedAtWork = isLocatedAtWork;
    }
    public Employee(String surname, boolean isLocatedAtWork, int Rank) {
        this.surname = surname;
        this.isLocatedAtWork = isLocatedAtWork;
        this.Rank = Rank;
    }

    public Employee(String surname, String position, String department, int rank, int certificate_number,
                    boolean isLocatedAtWork) {
        this.surname = surname;
        this.position = position;
        this.department = department;
        this.Rank = rank;
        this.certificate_number = certificate_number;
        this.isLocatedAtWork = isLocatedAtWork;
    }

    public Employee(String surname, String position, String department, int rank, int certificate_number,
                    boolean isLocatedAtWork, Date last_entrance, Date last_exit) {
        this.surname = surname;
        this.position = position;
        this.department = department;
        this.Rank = rank;
        this.certificate_number = certificate_number;
        this.isLocatedAtWork = isLocatedAtWork;
        this.last_entrance = last_entrance;
        this.last_exit = last_exit;
    }

    @Override
    public int compareTo(Employee another) {
        int result = another.Rank - Rank;
        if (result == 0) result = another.position.compareTo(position);
        if (result == 0) result = another.surname.compareTo(surname);
        return result;
    }
}
