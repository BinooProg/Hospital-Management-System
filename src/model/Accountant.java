package model;

public class Accountant extends Person{
    int Salary;
    static int noOfServedPatients=0;
    static int noOfDecribedPhar=0;
    static  int moneyPayed=0;
    public Accountant(String ID, String name, String username, String password, int age,int salary) {
        super(ID, name, username, password, age);
        this.Salary=salary;
    }
    public String toString(){
        return "Accountant ID: "+getID()+" name: "+getName()+" username: "+getUsername()+" password: "+getPassword()+" age: "+getAge()+" salary: "+getSalary();
    }
    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public static int getNoOfServedPatients() {
        return noOfServedPatients;
    }

    public static void setNoOfServedPatients(int noOfServedPatients) {
        Accountant.noOfServedPatients = noOfServedPatients;
    }

    public static int getNoOfDecribedPhar() {
        return noOfDecribedPhar;
    }

    public static void setNoOfDecribedPhar(int noOfDecribedPhar) {
        Accountant.noOfDecribedPhar = noOfDecribedPhar;
    }

    public static int getMoneyPayed() {
        return moneyPayed;
    }

    public static void setMoneyPayed(int moneyPayed) {
        Accountant.moneyPayed = moneyPayed;
    }
}
