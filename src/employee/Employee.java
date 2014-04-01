package employee;

public abstract class Employee implements Comparable {

    private static int counter;
    private final int id = counter++;
    private final String name;

    public Employee(String name){
        this.name = name;
    }
    public int id(){
        return id;
    }

    public String getName() {
        return name;
    }

    abstract int averageSalary();

    @Override
    public int compareTo(Object o) {
        Employee entry = (Employee) o;
        int result = entry.averageSalary() - averageSalary();
        if(result != 0) {
            return (int) result / Math.abs( result );
        }
        result = name.compareTo(entry.name);
        if(result != 0) {
            return  result;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "id: " + id() + "\t" + "Name: " + this.name + "\t" + "Month salary:  " + averageSalary() + "\n";
    }
}
