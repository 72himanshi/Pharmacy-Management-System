import java.util.Random;
import java.util.Scanner;

// interface
interface Manageable 
{
    void displayInfo();
}


class Medicine implements Manageable {
    String medName;
    int medId;
    double medPrice;

    public void setMedicineDetails(String name, int id, double price) {
        medName = name;
        medId = id;
        medPrice = price;
    }

    
    public void displayInfo() {
        System.out.println("Name: " + medName);
        System.out.println("ID: " + medId);
        System.out.println("Price: $" + medPrice);
    }
}


class PrescriptionMedicine extends Medicine {
    String docName;

    public void setPrescriptionDetails(String name, int id, double price, String doctor) {
        setMedicineDetails(name, id, price);
        docName = doctor;
    }

    
    public void displayInfo() {
        System.out.println("Name: " + medName);
        System.out.println("ID: " + medId);
        System.out.println("Price: $" + medPrice);
        System.out.println("Prescribed by Doctor: " + docName);
    }
}


class OverTheCounterMedicine extends Medicine {
    String usageInstructions;

    public void setOTCDetails(String name, int id, double price, String instructions) {
        setMedicineDetails(name, id, price);
        usageInstructions = instructions;
    }

    
    public void displayInfo() {
        System.out.println("Name: " + medName);
        System.out.println("ID: " + medId);
        System.out.println("Price: $" + medPrice);
        System.out.println("Usage Instructions: " + usageInstructions);
    }
}


public class PharmacyManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        
        PrescriptionMedicine presMedicine = new PrescriptionMedicine();

        
        System.out.println("Enter the name of the prescription medicine:");
        String presName = scanner.nextLine();
        System.out.println("Enter the ID of the prescription medicine:");
        int presId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter the doctor's name for the prescription medicine:");
        String doctorName = scanner.nextLine();
        double presPrice = 10 + (50 - 10) * random.nextDouble(); // Random price between 10 and 50

        presMedicine.setPrescriptionDetails(presName, presId, presPrice, doctorName);

        
        OverTheCounterMedicine otcMedicine = new OverTheCounterMedicine();

        
        System.out.println("Enter the name of the over-the-counter medicine:");
        String otcName = scanner.nextLine();
        System.out.println("Enter the ID of the over-the-counter medicine:");
        int otcId = scanner.nextInt();
        scanner.nextLine(); //  newline
        System.out.println("Enter the usage instructions for the over-the-counter medicine:");
        String usageInstructions = scanner.nextLine();
        double otcPrice = 5 + (20 - 5) * random.nextDouble(); // Random price between 5 and 20

        otcMedicine.setOTCDetails(otcName, otcId, otcPrice, usageInstructions);

        
        System.out.println("\nPrescription Medicine Details:");
        presMedicine.displayInfo();
        System.out.println("------------------");
        System.out.println("Over-the-Counter Medicine Details:");
        otcMedicine.displayInfo();
    }
}
