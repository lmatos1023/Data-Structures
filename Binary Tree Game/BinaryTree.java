import java.util.Scanner;

public class BinaryTree //class to build a binary tree
{
    TreeNode root; //stores the root question node

    public BinaryTree() //constructor to make an empty binary tree
    {
        root = null;
    }
    public void setRoot(TreeNode r)
    {
        root = r;
    }//method to set a node as the root
    public void ask() //method to ask the user questions until I have zeroed in on their object
    {
        Scanner sc = new Scanner(System.in); //scanner to read user input
        System.out.println("Welcome to Twenty Questions! Think of an object."); //flavor text
        System.out.println("You got it? Alright, now I'll ask a series of questions to guess your object.");
        TreeNode current = root; //sets the current node as the root
        String answer = "";
        while(!current.isLeaf()) //traverses the tree based on user answers until I have reached an answer node
        {
            System.out.println(current.getQuestion());
            System.out.print("Enter yes or no: ");
                answer = sc.nextLine();
                if(answer.equals("Yes") || answer.equals("yes"))
                    current = current.getYesNode();
                else if(answer.equals("No") || answer.equals("no"))
                    current = current.getNoNode();
        }
        System.out.println(current.getQuestion()); //asks the user if the answer matches their guess
        answer = sc.nextLine();
        if(answer.equals("Yes") || answer.equals("yes")) //if they answer yes, this method ends
            System.out.println("Knew I could do it! Thanks for playing.");
        else if(answer.equals("No") || answer.equals("no")) //if they answer no, they are prompted to give their object and a question to help differentiate it from my guess
        {
            System.out.println("Dang, you stumped me!");
            System.out.println("Help us be better guessers! What was your object?");
            String correctObject = sc.nextLine();
            System.out.println("What's a question we should use to figure out your object?");
            String question = sc.nextLine();
            addNewEdge(current, correctObject, question); //method to create a new edge for the binary tree and make it smarter
        }
    }
    public void addNewEdge(TreeNode current, String right, String question) //replaces the current guess with the user-input question, and making the user object the yesNode, and the wrong guess the noNode
    {
        TreeNode newNo = current; //saves the current node as a new NoNode
        current.setQuestion(question); //sets the current node to the user question
        current.setYesNode(new TreeNode("Is it a "+right+"?")); //sets the yesNode to the user's object
        current.setNoNode(newNo); //sets the noNode to my incorrect guess
    }
}
