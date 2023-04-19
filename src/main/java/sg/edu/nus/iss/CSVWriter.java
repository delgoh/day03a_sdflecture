package sg.edu.nus.iss;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String FILE_HEADER = "staffNo,fullName,department,role,emailAddress,salary";

    public List<Employee> employees = null;
    
    public List<Employee> generateEmployees() {
        employees = new ArrayList<>();
        Employee emp1 = new Employee("11111", "Hellow", "Computer Science", "Worker", "hellow@visa.com", 23000);
        Employee emp2 = new Employee("22222", "Helloow", "Computer Engineering", "Worker", "helloow@visa.com", 24000);
        Employee emp3 = new Employee("33333", "Hellooow", "Computer Science", "Boss", "hellooow@visa.com", 100000);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        return employees;
    }

    public void writeToCSV(List<Employee> employees, String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        fw.append(FILE_HEADER + NEW_LINE_SEPARATOR);
        for (Employee employee : employees) {
            // fw.append(employee.toString());
            fw.append(employee.getStaffNo());
            fw.append(COMMA_DELIMITER);
            fw.append(employee.getFullName());
            fw.append(COMMA_DELIMITER);
            fw.append(employee.getDepartment());
            fw.append(COMMA_DELIMITER);
            fw.append(employee.getRole());
            fw.append(COMMA_DELIMITER);
            fw.append(employee.getEmailAddress());
            fw.append(COMMA_DELIMITER);
            fw.append(String.valueOf(employee.getSalary()));
            fw.append(NEW_LINE_SEPARATOR);
        }
        fw.flush();
        fw.close();
    }
}
