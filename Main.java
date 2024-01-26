import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        int quarters = 0; //declare counters for each type of coin
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;
        System.out.print("Enter your money amount: $"); //prompts user to write the amount
        Scanner sc = new Scanner(System.in); //scanner to receive user input
        double input = sc.nextDouble(); //stores the double the user inputs
        System.out.println("Enter Y to include quarters, dimes, and nickels, respectively, on the next 3 lines" +
                ", or enter anything else to exclude the coin type: ");
        Scanner coin = new Scanner(System.in); //new scanner to receive user input
        char qinclude = coin.next().charAt(0); //stores inclusion of quarters
        char dinclude = coin.next().charAt(0); //stores inclusion of dimes
        char ninclude = coin.next().charAt(0); //stores inclusion of nickels
        int amount = (int)(input * 100); //converts the input to an int representing cents
        if(qinclude == 'Y')
        {
            while (amount >= 25)
            { //while loop to add to the quarter counter and subtract from the remaining amount
                quarters++;
                amount -= 25;
                System.out.println(amount);
            }
        }
        if(dinclude == 'Y')
        {
            while (amount >= 10)
            { //while loop to track dimes
                dimes++;
                amount -= 10;
                System.out.println(amount);
            }
        }
        if(ninclude == 'Y')
        {
            while (amount >= 5)
            { //while loop to track nickels
                nickels++;
                amount -= 5;
                System.out.println(amount);
            }
        }
        while (amount > 0)
        { //while loop to track pennies
            pennies++;
            amount -= 1;
            System.out.println(amount);
        }
        System.out.println("You have:"); //outputs the amounts of each coin
        if (quarters == 1)
            System.out.println(quarters + " quarter");
        else if (quarters > 1)
            System.out.println(quarters + " quarters");
        if (dimes == 1)
            System.out.println(dimes + " dime");
        else if (dimes > 1)
            System.out.println(dimes + " dimes");
        if (nickels == 1)
            System.out.println(nickels + " nickel");
        else if (nickels > 1)
            System.out.println(nickels + " nickels");
        if (pennies == 1)
            System.out.println(pennies + " penny");
        else if (pennies > 1)
            System.out.println(pennies + " pennies");
    }
}