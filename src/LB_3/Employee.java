package LB_3;

import java.util.Date;

public class Employee {
    private String surname;
    private String position;
    private String department;
    private int certificate_number;
    private boolean isLocatedAtWork;
    private Date last_entrance;
    private Date last_exit;

    public String getSurname() {
        return surname;
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
        this.isLocatedAtWork = locatedAtWork;
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


    public Employee(String surname, String position, String department, int certificate_number) {
        this.surname = surname;
        this.position = position;
        this.department = department;
        this.certificate_number = certificate_number;
    }
}
