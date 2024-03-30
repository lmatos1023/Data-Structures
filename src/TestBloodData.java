import java.util.Scanner;

public class TestBloodData
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); //scanner to get user input
        System.out.print("Enter a blood type (do not include the Rh factor): "); //prompting user then storing the data
        String inputType = sc.nextLine();
        System.out.print("Enter a + or - for Rh factor: ");
        char inputRh = sc.next().charAt(0);
        BloodData bd1 = new BloodData(); //creating default object
        BloodData bd2 = new BloodData(inputType, inputRh); //creating overloaded object with user input
        System.out.println("BloodData 1: " + bd1.getBloodType() + bd1.getRhFactor()); //printing details from both BloodData objects
        System.out.println("BloodData 2: " + bd2.getBloodType() + bd2.getRhFactor());
        bd1.setBloodType(bd2.getBloodType()); //changing default object values to user input values
        bd1.setRhFactor(bd2.getRhFactor());
        System.out.println("Altering blood data...");
        System.out.println("BloodData 1: " + bd1.getBloodType() + bd1.getRhFactor()); //printing details from both BloodData objects after alteration
        System.out.println("BloodData 2: " + bd2.getBloodType() + bd2.getRhFactor());
    }
}
