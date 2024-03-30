import java.util.Scanner;

public class TestPatient
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the patient's blood type (do not include the Rh factor): ");
        String inputType = sc.nextLine();
        System.out.print("Enter a + or - for their Rh factor: ");
        char inputRh = sc.next().charAt(0);
        System.out.print("Enter the patient's ID number: ");
        int id = sc.nextInt();
        System.out.print("Enter the patient's age: ");
        int age = sc.nextInt();
        System.out.print("Enter the next patient's ID number: ");
        int id2 = sc.nextInt();
        System.out.print("Enter the next patient's age: ");
        int age2 = sc.nextInt();
        BloodData inputBd = new BloodData(inputType, inputRh);
        Patient p1 = new Patient();
        Patient p2 = new Patient(id, age, inputBd);
        Patient p3 = new Patient(id2, age2, new BloodData());
        System.out.println("Patient Directory: ");
        System.out.println("Patient 1: ID - "+p1.getIdNumber()+", Age - "+p1.getAge()+", Blood Type - "+p1.getBloodType().getBloodType()+p1.getBloodType().getRhFactor());
        System.out.println("Patient 2: ID - "+p2.getIdNumber()+", Age - "+p2.getAge()+", Blood Type - "+p2.getBloodType().getBloodType()+p2.getBloodType().getRhFactor());
        System.out.println("Patient 3: ID - "+p3.getIdNumber()+", Age - "+p3.getAge()+", Blood Type - "+p3.getBloodType().getBloodType()+p3.getBloodType().getRhFactor());
    }
}
