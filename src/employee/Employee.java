package employee;

public abstract class Employee implements Comparable<Employee> {

    private final char employeeTypeOfSalary;

    private static int counter;
    private final int id = counter++;
    private final String name;

    public Employee(String name, char typeSalary){
        employeeTypeOfSalary = typeSalary;
        this.name = name;
    }
    public int id(){
        return id;
    }

    public String getName() {
        return name;
    }
    public char getEmployeeTypeOfSalary() {
        return employeeTypeOfSalary;
    }

    abstract int averageSalary();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employeeTypeOfSalary != employee.employeeTypeOfSalary) return false;
        if (!name.equals(employee.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) employeeTypeOfSalary;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public int compareTo(Employee entry) {
        int result = entry.averageSalary() - averageSalary();
        return result != 0
                ? result
                : name.compareTo(entry.name);
    }

    @Override
    public String toString() {
        return "id: " + id() + "\t" + "Name: " + this.name + "\t" + "Month salary:  " + averageSalary() + "\n";
    }
}
