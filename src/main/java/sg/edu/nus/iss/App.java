package sg.edu.nus.iss;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String filePath = args[0];
        String fileName = args[1];
        String filePathName = filePath + File.separator + fileName;

        File newPath = new File(filePath);
        if (newPath.exists()) {
            System.out.println("Directory already exists.");
        } else {
            System.out.println("New directory created.");
            newPath.mkdir();
        }

        File newFile = new File(filePathName);
        if (newFile.exists()) {
            System.out.println("File already exists.");
        } else {
            System.out.println("New file created.");
            newFile.createNewFile();
        }

        // CSVWriter csvWriter = new CSVWriter();
        // csvWriter.writeToCSV(csvWriter.generateEmployees(), filePathName);

        CSVReader csvReader = new CSVReader();
        List<Employee> employees = csvReader.readCSV(filePathName);
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
        // employees.toString();
    }
}
