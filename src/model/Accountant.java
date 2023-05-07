package model;

public class Accountant extends Person{
    int Salary;
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
}
