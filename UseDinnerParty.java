import java.util.Scanner;

public class UseDinnerParty
{
    public static void main (String []args)
    {
        int guests;
        int choices;
        Party userParty = new Party();
        DinnerParty userDinnerParty = new DinnerParty();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of guests you'd like at your party: ");
        guests = sc.nextInt();
        userParty.setGuestNum(guests);
        if(guests != 1)
            System.out.println("Your party has " + guests + " guests.");
        else
            System.out.println("Your party has 1 guest.");
        userParty.displayInvitation();
        System.out.print("Enter the number of guests you'd like at your dinner party: ");
        guests = sc.nextInt();
        userDinnerParty.setGuestNum(guests);
        System.out.print("Enter the number of your desired menu choice (1 for chicken, 2 for veggie, 3 for beef): ");
        choices = sc.nextInt();
        userDinnerParty.setDinnerChoice(choices);
        if(guests != 1)
            System.out.println("Your dinner party has " + guests + " guests.");
        else
            System.out.println("Your dinner party has 1 guest.");
        System.out.println("Menu option " + choices + " will be served.");
        userDinnerParty.displayInvitation();
    }
}
