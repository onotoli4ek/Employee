package employee;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOHelper {

    public static void writeListToFile(List<Employee> employeeList, String fileName){
        File file = new File(fileName);
        try {
            if(!file.exists()){
                file.createNewFile();
            }

            try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
                out.println("id" + "\t" + "Name" + "\t" + "Month salary" + "\t" + "Type of salary");
                for (Employee i : employeeList) {
                    out.println(i.id()+ "\t" + i.getName()+ "\t" + i.averageSalary()+ "\t" + i.getEmployeeTypeOfSalary());
                }
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readListFromFile(List<Employee> outEmployeeList, String fileName) throws FileNotFoundException {
        exists(fileName);
        try {
            try (BufferedReader in = new BufferedReader(new FileReader( new File(fileName).getAbsoluteFile()))) {
                String s;
                String regEx = "^(\\d+)\t(\\D+)\t(\\d+)\t([fh])";
                Pattern pattern = Pattern.compile(regEx);
                if (in.readLine().equals("id\tName\tMonth salary\tType of salary")){
                    Matcher matcher;
                    System.out.println("!!!!!!");

                    while ((s = in.readLine()) != null && pattern.matcher(s).matches() ) {
//                        while ((s = in.readLine()) != null) {
                        System.out.println("!!");
                        matcher = pattern.matcher(s);
                        matcher.matches();
//                        int idInString = new Integer(matcher.group(1));
                        String nameInString = matcher.group(2);
                        int salaryInString = new Integer(matcher.group(3));
                        String typeSalaryInSting = matcher.group(4);
                        Employee currentEmployee;
                        System.out.println(typeSalaryInSting);

                        if (typeSalaryInSting.equals("f"))   {
                            System.out.println("Go f");
                            currentEmployee = new EmployeeFixSalary(nameInString,salaryInString);
//                            System.out.println(currentEmployee);
                            Collections.addAll(outEmployeeList, currentEmployee);
//                            System.out.println(amountSameItemsInList(outEmployeeList, currentEmployee));
//                            System.out.println(outEmployeeList.size());
//                            System.out.println(outEmployeeList.get(outEmployeeList.size()-1));
//                            System.out.println("count" + Employee.getCounter());

                            if (amountSameItemsInList(outEmployeeList, currentEmployee) > 1){
                                System.out.println(amountSameItemsInList(outEmployeeList, currentEmployee));
                                System.out.println(outEmployeeList.get(outEmployeeList.size()-1));
//                                outEmployeeList.remove(outEmployeeList.size()-1);
                                outEmployeeList.remove(outEmployeeList.size()-1);

                            } else {
//                                Employee.nextCounter();
                            }
                        } else if (typeSalaryInSting.equals("h"))   {
                            System.out.println("Go h");
                            salaryInString = (int) salaryInString/(EmployeeWithHourlyPay.HOURSE_PER_DAY*EmployeeWithHourlyPay.DAYS_PER_MONTH);
                            currentEmployee = new EmployeeWithHourlyPay(nameInString, salaryInString);
                            Collections.addAll(outEmployeeList, currentEmployee);
                            if (amountSameItemsInList(outEmployeeList, currentEmployee) > 1){
//                                outEmployeeList.remove(Employee.getCounter());
                                System.out.println(outEmployeeList.get(outEmployeeList.size()-1));
                                outEmployeeList.remove(outEmployeeList.size()-1);
                            }
                        }
                    }
                }

            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int amountSameItemsInList (List<Employee> employeeList, Employee employee){
        int sameItems = 0;
        for (Employee i : employeeList)  {
            if (i.equals(employee)){
                sameItems++;
            }
        }
        return sameItems;
    }

    public static boolean correctFormatOfFileEmployees (String path) {
        boolean correctFile = false;
        try {
            exists(path);
        } catch(FileNotFoundException e) {
            System.err.format("Error: %s",e);
            return false;
        }
        try (BufferedReader in = new BufferedReader(new FileReader( new File(path).getAbsoluteFile()))) {
            String s;
            String regEx = "^(\\d+)\t(\\D+)\t(\\d+)\t([hf])";
            Pattern pattern = Pattern.compile(regEx);
            if (in.readLine().equals("id\tName\tMonth salary\tType of salary")){
                Matcher matcher;
                while ((s = in.readLine()) != null) {
                    matcher = pattern.matcher(s);
                    if (matcher.matches()){
                        correctFile = true;
                    } else {
                        correctFile = false;
                        break;
                    }
                }
            }

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return correctFile;
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

