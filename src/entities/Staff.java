package entities;

public class Staff {
    private String name;
    private String role;
    private double salary;

    public Staff(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Staff Name: " + name + ", Role: " + role + ", Salary: " + salary;
    }
}
