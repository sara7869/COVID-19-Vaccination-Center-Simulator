import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class VaccinationCenter 
{
    static Scanner scanner;
    static Booth[] serviceCenter;
    static FileWriter fileWriter;
    static BufferedWriter bufferedWriter;
    static FileReader fileReader;
    static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException
    {
        scanner = new Scanner(System.in);
        String choice = "";
        int vaccineCount = 150;
        serviceCenter = new Booth[6];

        initialise();

        while (!choice.equals("999") && !choice.equals("EXT")) 
        {
            // call procedure
            choice = displayMenuAndGetUserInput();
            switch (choice) {
                case "100", "VVB" -> viewAllVaccinationBooths();
                case "101", "VEB" -> viewAllEmptyBooths();
                case "102", "APB" -> vaccineCount = addPatientToBooth(vaccineCount);
                case "103", "RPB" -> removePatientFromBooth();
                case "104", "VPS" -> viewPatientsInAlphabeticalOrder();
                case "105", "SPD" -> storeProgramDataIntoFile();
                case "106", "LPD" -> loadProgramDataFromFile();
                case "107", "VRV" -> viewRemainingVaccinations(vaccineCount);
                case "108", "AVS" -> 
                {
                    vaccineCount = addVaccinationsToStock(vaccineCount);
                    scanner.nextLine();
                }
                case "999", "EXT" -> exitProgram();
            }
        }
        scanner.close();
    }

    // All booths are inialiased to "e" to show they're empty
    // @no parameters
    // @no return
    private static void initialise() 
    {
        for (int count = 0; count < 6; count++) 
        {
            serviceCenter[count] = new Booth("e");
            System.out.println("Initialised");
        }
    }

    // Display the menu options to the user and gets the input
    // @no parameters
    // @return the user input choice
    private static String displayMenuAndGetUserInput() 
    {
        String option;
        // Display menu options to user
        System.out.println("");
        System.out.println("Choose an option from the following: ");
        System.out.println("");
        System.out.println("""
                100 or VVB:     View all Vaccination Booths\s
                101 or VEB:     View all Empty Booths
                102 or APB:     Add Patient to a Booth
                103 or RPB:     Remove Patient from a Booth
                104 or VPS:     View Patients Sorted in alphabetical order
                105 or SPD:     Store Program Data into file
                106 or LPD:     Load Program Data from file
                107 or VRV:     View Remaining Vaccinations
                108 or AVS:     Add Vaccinations to the Stock
                999 or EXT:     Exit the Program""");
        // Get user input
        System.out.println("");
        System.out.println("Enter choice:");
        option = scanner.nextLine();
        // return input
        return option;
    }

    // Display all the booths in order and their current patients
    // @no parameters
    // @no return
    private static void viewAllVaccinationBooths() 
    {
        System.out.println("");
        for (int count = 0; count < 6; count++) 
        {
            if (serviceCenter[count].getPatientName().equals("e")) 
            {
                System.out.println("Booth " + count + " is empty");
            } 
            else 
            {
                System.out.println("Booth " + count + " occupied by " + serviceCenter[count].getPatientName());
            }
        }
    }

    // Display all the vaccination booths with no patients at the moment
    // @no parameters
    // @no return
    private static void viewAllEmptyBooths() 
    {
        for (int count = 0; count < 6; count++) 
        {
            if (serviceCenter[count].getPatientName().equals("e")) 
            {
                System.out.println("Booth " + count + " is empty");
            }
        }
    }

    // Get name of patient, check all the booths for an available one and add
    // patient to that booth.
    // Number of vaccines remaining is also checked and if it is less than or equal
    // to 20, a warning is displayed.
    // If all the booths are full and patient wasn't added, a warning is output.
    // @param vaccines - number of vaccines remaining
    // @return new number of vaccines
    private static int addPatientToBooth(int vaccines) 
    {
        boolean patientAdded = false;

        for (int count = 0; count < 6; count++) 
        {
            if (!serviceCenter[count].getPatientName().equals("e"))
                continue;
            System.out.println("Enter name of patient to add");
            String customerName = scanner.nextLine();
            serviceCenter[count].setPatientName(customerName);
            patientAdded = true;
            viewAllVaccinationBooths();
            vaccines = vaccines - 1;
            if (vaccines <= 20) 
            {
                System.out.println("Warning: Vaccines in stock running out. Re-order soon.");
            }
            break;

        }
        if (!patientAdded) 
        {
            System.out.println("All booths are full");
        }
        return vaccines;
    }

    // Show all the patients currently in the booths, get name of patient to remove.
    // Check all booths for that name and remove if found.
    // If not found, a message is displayed.
    // @no parameters
    // @no return
    private static void removePatientFromBooth() 
    {
        Boolean empty = true;

        for (int count1 = 0; count1 < 6; count1++) 
        {
            if (!serviceCenter[count1].getPatientName().equals("e")) 
            {
                empty = false;
            }
        }
        if (empty == false) 
        {
            System.out.println("");
            viewAllVaccinationBooths();
            System.out.println("Which patient do you want to remove?");
            String customerName = scanner.nextLine();
            boolean patientRemoved = false;
            for (int count = 0; count < 6; count++) 
            {
                if (serviceCenter[count].getPatientName().equals(customerName)) 
                {
                    serviceCenter[count].setPatientName("e");
                    patientRemoved = true;
                    viewAllVaccinationBooths();
                    System.out.println("");
                }
            }
            if (!patientRemoved) 
            {
                System.out.println("Patient not found in the booths");
            }
        } 
        else 
        {
            System.out.println("All booths are empty.");
        }
    }

    // view all current patients in aplhabetical order
    // @no parameters
    // @no return
    private static void viewPatientsInAlphabeticalOrder() 
    {
        String temp;
        String[] tempArray = { " ", " ", " ", " ", " ", " " };
        int count = 0;
        int emptyCount = 0;

        for (count = 0; count < 6; count++) 
        {
            tempArray[count] = serviceCenter[count].getPatientName();
        }

        int length = tempArray.length;
        count = 0;

        for (int i = 0; i < length; i++) 
        {
            if ((!tempArray[i].equals("e"))) 
            {
                temp = tempArray[count];
                tempArray[count] = tempArray[i];
                tempArray[i] = temp;
                count = count + 1;
            } 
            else 
            {
                emptyCount = emptyCount + 1;
            }
        }

        for (int count2 = 0; count2 < length - 1 - emptyCount; count2++) 
        {
            for (int count1 = 0; count1 < length - count2 - 1 - emptyCount; count1++) 
            {
                if (tempArray[count1].compareTo(tempArray[count1 + 1]) > 0) 
                {
                    temp = tempArray[count1];
                    tempArray[count1] = tempArray[count1 + 1];
                    tempArray[count1 + 1] = temp;
                }
            }
        }

        for (count = 0; count < 6; count++) 
        {
            if (!tempArray[count].equals("e")) 
            {
                System.out.println(tempArray[count]);
            }
        }
        System.out.println("Empty Booths: " + emptyCount);

    }

    // stores current patients in booths to a text file
    // @no parameters
    // @no return
    private static void storeProgramDataIntoFile() throws IOException 
    {
        fileWriter = new FileWriter("current_patient_information.txt");
        bufferedWriter = new BufferedWriter(fileWriter);

        for (int count = 0; count < 6; count++) 
        {
            if (serviceCenter[count].getPatientName().equals("e")) 
            {
                bufferedWriter.write("Booth " + count + " is empty");
            } 
            else 
            {
                bufferedWriter.write("Booth " + count + " is occupied by " + serviceCenter[count]);
            }
            bufferedWriter.newLine();
        }
        System.out.println("Program data written to file.");
        bufferedWriter.close();
    }

    // loads data in text file
    // @no parameters
    // @no return
    private static void loadProgramDataFromFile() throws IOException 
    {
        fileReader = new FileReader("current_patient_information.txt");
        bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) 
        {
            System.out.println(line);
        }
        bufferedReader.close();
    }

    // Display the number of remaining vaccines with a message. If less than or
    // equal to 20, display the warning.
    // @no parameters
    // @no return
    private static void viewRemainingVaccinations(int vaccines) 
    {
        System.out.println("Remaining vaccines: " + vaccines);
        if (vaccines <= 20) 
        {
            System.out.println("Warning: Vaccines in stock running out. Re-order soon.");
        }
    }

    // Get how many vaccines to add and adds them to the current vaccine count.
    // Display number of vaccines after restocking.
    // @param vaccines - number of vaccines remaining
    // @return new number of vaccines
    private static int addVaccinationsToStock(int vaccines) 
    {
        System.out.println("Enter the number of vaccines being added:");
        int vaccinesAdded = scanner.nextInt();
        int totalVaccines = vaccines + vaccinesAdded;
        System.out.println("Vaccines restocked. Number of vaccines: " + totalVaccines);
        return (totalVaccines);
    }

    // Ends the program.
    // @no parameters
    // @no return
    private static void exitProgram() 
    {
        System.out.println("Program exited.");
    }
}
