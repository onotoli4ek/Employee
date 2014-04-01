package employee;

public class EmployeeWithHourlyPay extends Employee {
    private final int hourlyPay;

    public EmployeeWithHourlyPay (String name, int salary){
        super(name);
        this.hourlyPay = salary;
    }

    public int averageSalary (){
        return (int)20*8*hourlyPay;
    }
}