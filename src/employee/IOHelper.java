package employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class IOHelper {


    public static void writeListToFile(List<Employee> employeeList, String fileName){

        File file = new File(fileName);
        try {
            if(!file.exists()){
                file.createNewFile();
            }

            try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
                out.println("id" + "Name" + "Month salary" + "Type of salary" );
                for (Employee i : employeeList) {
                    out.println(i.id() + i.getName() + i.averageSalary() + i.getEmployeeTypeOfSalary());
                }

            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Employee> readListFromFile(String fileName) throws FileNotFoundException {
        List<Employee> outEmployeeList = new ArrayList<>();

        exists(fileName);
        try {
            try (BufferedReader in = new BufferedReader(new FileReader( new File(fileName).getAbsoluteFile()))) {
                String s;
                while ((s = in.readLine()) != null) {
                    String nameInString = s.substring(s.indexOf("Name: ") + "Name: ".length(), s.indexOf("Month"));
                    String nameToEmployee = nameInString.substring(0,nameInString.indexOf("\t"));
                    int salaryToEmployee = new Integer(s.substring(s.indexOf("Month salary:  ") + "Month salary:  ".length() ));
                    Collections.addAll(outEmployeeList, new EmployeeFixSalary(nameToEmployee, salaryToEmployee));
                }
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        return outEmployeeList;
    }
    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }

    public static void outFirstItemsFromCollection(List<? > listNames, int amountOfItem){
        ListIterator<? > it = listNames.listIterator();
        for (int k = 0 ; it.hasNext() && k < amountOfItem; k++ ){
            System.out.println(it.next() + " ");
        }
    }

    public static void outLastItemsFromCollection(List<? > listNames, int amountOfItem){
        ListIterator<? > it = listNames.listIterator(listNames.size() - amountOfItem);
        while (it.hasNext())   {
            System.out.println(it.next());
        }

    }

}

