/**
 *
 *     Create classes, which describe employees with hourly wage and fixed payment. Give your suggestions about relations between classes. Implement method for
 * calculating the average monthly salary. For employees with hourly wage use next formula: “average monthly salary= 20.8*8* hourly rate”, for employees with
 * fixed payment – “average monthly salary= fixed monthly payment”. Write well commented code for solving next problems
 * a) Sort the collection of employees in descending order by the average monthly salary. In the case of equal salary – by the name.
 * Write ID, name and monthly salary for all employees from collection.
 * b) Write information about first five employees from collection (problem a).
 * c) Write ID of three last employees from collection (problem b).
 * d) Write code for reading and writing collection of these objects from (into) file.
 * e) Write code for handling the incorrect format of incoming file.
 *
 *
 * Date: 01.04.14
 * @author Anatolii Syvashchenko
 *
 */

package employee;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main   {
    public static void main(String[] args)  throws FileNotFoundException {
        Employee emp1 = new EmployeeFixSalary("Taras", 7000);
        Employee emp2 = new EmployeeFixSalary("Ivan", 3000);
        Employee emp3 = new EmployeeFixSalary("Oleg", 3000);
        Employee emp4 = new EmployeeFixSalary("Vasya", 2000);
        Employee emp5 = new EmployeeWithHourlyPay("Dima", 50);
        Employee emp6 = new EmployeeWithHourlyPay("Anya", 40);
        Employee emp7 = new EmployeeFixSalary("Anton", 3000);

        List<Employee> employeeList = new ArrayList<>();
        Collections.addAll(employeeList, emp1, emp2, emp3, emp4, emp5, emp6, emp7);
        System.out.println("Employee's list: ");
        for (Employee i : employeeList){
            System.out.println(i);
        }
        System.out.println("Task a: ");
//        Collections.sort(employeeList);
//        for (Employee i : employeeList){
//            System.out.println(i);
//        }

//        System.out.println("Task b: ");
//        IOHelper.outFirstItemsFromCollection(employeeList, 5);
//        System.out.println("Task c: ");
//        IOHelper.outLastItemsFromCollection(employeeList, 4);
        System.out.println("Task d: ");
        String fileName = "C:/Documents and Settings/Admin/IdeaProjects/Employee/Employee/data.csv";
        System.out.println("Write from file");
        IOHelper.writeListToFile(employeeList,fileName);
        IOHelper.readListFromFile(employeeList,fileName);
        for (Employee i : employeeList){
            System.out.println(i);
        }

        System.out.println(IOHelper.correctFormatOfFileEmployees(fileName));
    }
}
