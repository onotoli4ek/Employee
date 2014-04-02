package employee;

public class EmployeeWithHourlyPay extends Employee {
    private static final char EMPLOYEE_TYPE_OF_SALARY = 'h';
    public static final int DAYS_PER_MONTH = 20;
    public static final int HOURSE_PER_DAY = 8;
    private final int hourlyPay;

    public EmployeeWithHourlyPay (String name, int salary){
        super(name,EMPLOYEE_TYPE_OF_SALARY);
        this.hourlyPay = salary;
    }

    public int averageSalary (){
        return DAYS_PER_MONTH * HOURSE_PER_DAY *hourlyPay;
    }
}