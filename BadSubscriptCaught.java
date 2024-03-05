import java.util.Scanner;
public class BadSubscriptCaught {
    public static void main(String[] args)
    {
        String [] names = {"Kate", "Quentin", "Claudette", "Dwight", "Meg",
        "Jake", "David", "Bill", "Yui", "Jane"};
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter a number to receive the name in the requested position! ");
            int input = sc.nextInt();
            System.out.println(names[input]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid number received!");
        }
    }
}