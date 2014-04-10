package employee;

public class EmployeeFixSalary extends Employee {
    public static final char EMPLOYEE_TYPE_OF_SALARY = 'f';
    private final int fixSalary;

    public EmployeeFixSalary (String name, int salary){
        super(name , EMPLOYEE_TYPE_OF_SALARY);
        this.fixSalary = salary;
    }

    public int averageSalary (){
        return fixSalary;
    }
}
