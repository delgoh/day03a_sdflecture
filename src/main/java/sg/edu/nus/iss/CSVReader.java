package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public List<Employee> readCSV(String fileName) throws FileNotFoundException, IOException {
        BufferedReader br = null;
        String line = "";
        List<Employee> employees = new ArrayList<>();
        
        br = new BufferedReader(new FileReader(fileName));
        
        line = br.readLine();
        line = br.readLine();
        while (line != null) {
            String[] empData = line.split(CSVWriter.COMMA_DELIMITER);

            if (empData.length > 0) {
                Employee employee = new Employee(empData[0], empData[1], empData[2], empData[3], empData[4], Integer.parseInt(empData[5]));
                employees.add(employee);
            }

            line = br.readLine();
        }

        br.close();

        return employees;
    }
}
