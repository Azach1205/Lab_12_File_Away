import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        String moreData;

        do {
            System.out.println("Enter First Name:");
            String firstName = scanner.nextLine();

            System.out.println("Enter Last Name:");
            String lastName = scanner.nextLine();

            System.out.println("Enter ID Number (6 digits):");
            String idNumber = scanner.nextLine();

            System.out.println("Enter Email:");
            String email = scanner.nextLine();

            System.out.println("Enter Year of Birth:");
            String yearOfBirth = scanner.nextLine();

            String record = firstName + ", " + lastName + ", " + idNumber + ", " + email + ", " + yearOfBirth;
            records.add(record);

            System.out.println("Do you want to add another record? (yes/no):");
            moreData = scanner.nextLine();
        } while (moreData.equalsIgnoreCase("yes"));

        System.out.println("Enter the file name to save (with .csv extension):");
        String fileName = scanner.nextLine();

        try (FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/src/" + fileName)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Data saved successfully to " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while saving data.");
        }
    }
}

