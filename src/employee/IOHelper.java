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
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                for (Employee i : employeeList){
                    out.print(i);
                }

            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Employee> readListFromFile(String fileName) throws FileNotFoundException {
        List<Employee> outEmployeeList = new ArrayList<Employee>();

        exists(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader( new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    String nameInString = s.substring(s.indexOf("Name: ") + "Name: ".length(), s.indexOf("Month"));
                    String nameToEmployee = nameInString.substring(0,nameInString.indexOf("\t"));
                    int salaryToEmployee = new Integer(s.substring(s.indexOf("Month salary:  ") + "Month salary:  ".length() ));
                    Collections.addAll(outEmployeeList, new EmployeeFixSalary(nameToEmployee, salaryToEmployee));
                }
            } finally {
                in.close();
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
        ListIterator<? > it = listNames.listIterator();
        while (it.hasNext())   {
            it.next();
        }
        for (int k = 0 ; it.hasPrevious() && k < amountOfItem; k++ ){
            it.previous();
        }
        while (it.hasNext())   {
            System.out.println(it.next());
        }
    }

}

