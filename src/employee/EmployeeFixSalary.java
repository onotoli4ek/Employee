package employee;

public class EmployeeFixSalary extends Employee {
    private final int fixSalary;

    public EmployeeFixSalary (String name, int salary){
        super(name);
        this.fixSalary = salary;
    }

    public int averageSalary (){
        return fixSalary;
    }
}
