package employee;

import java.io.*;
import java.util.ArrayList;
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
                String regEx = "^(\\d+)\t(\\D+)\t(\\d+)\t([hf])";
                Pattern pattern = Pattern.compile(regEx);
                if (in.readLine().equals("id\tName\tMonth salary\tType of salary")){
                    Matcher matcher;
                    while ((s = in.readLine()) != null && pattern.matcher(s).matches() ) {
                        matcher = pattern.matcher(s);
                        matcher.matches();
                        String nameInString = matcher.group(2);
                        if (matcher.group(4).equals("f"))   {
                            Collections.addAll(outEmployeeList, new EmployeeFixSalary(nameInString, new Integer(matcher.group(3))));
                        } else if (matcher.group(4).equals("h"))   {
                            int salary = (int)(new Integer(matcher.group(3))/(EmployeeWithHourlyPay.HOURSE_PER_DAY*EmployeeWithHourlyPay.DAYS_PER_MONTH));
                            Collections.addAll(outEmployeeList, new EmployeeWithHourlyPay(nameInString, salary));
                        }
                    }
                }

            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

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

