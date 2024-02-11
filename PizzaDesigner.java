import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

   public class PizzaDesigner extends JFrame implements ActionListener
   {
    double price = 0.00; //tracks price
    String[] sizes = new String[]{"Small ($5)", "Medium ($10)","Large ($15)", "Super ($20)"}; //array of sizes
    String[] toppings = new String[]{"None", "Pepperoni", "Extra Cheese", "Pineapple", "Sausage", "Bacon",
            "Peppers", "Onions", "Spinach", "Mushroom", "Ham", "Broccoli", "Chicken Breast", "Olives",
            "Tomato", "Beef", "Anchovies", "Basil", "Jalapeno", "Salami"}; //array of toppings
    JLabel intro = new JLabel("Welcome to Dominoes! (not at all affiliated with Domino's)"); //creating JFrame objects
    JLabel sizePrompt = new JLabel("Choose your size:");
    JComboBox<String> sizeList = new JComboBox<>(sizes);
    JLabel toppingsPromptPt1 = new JLabel("Choose up to 3 toppings. (50 cents each. ");
    JLabel toppingsPromptPt2 = new JLabel("Extra Cheese free of charge. Get 3 non-cheese toppings for $1.25 instead!)");
    JComboBox<String> toppingList1 = new JComboBox<>(toppings); //combo boxes of the toppings
    JComboBox<String> toppingList2 = new JComboBox<>(toppings);
    JComboBox<String> toppingList3 = new JComboBox<>(toppings);
    JButton button = new JButton("Confirm All Selections");
    JLabel checkout = new JLabel(""); //label that prints price and pizza breakdown
    JLabel bonus = new JLabel(""); //bonus if all three toppings are the same!
    final int FRAME_WIDTH = 550; //makes dimensions of the frame
    final int FRAME_HEIGHT = 300;
    public PizzaDesigner()
    {
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        intro.setFont(new Font("Arial", Font.BOLD, 16));
        checkout.setFont(new Font("Arial", Font.BOLD, 12));
        setLayout(new FlowLayout());
        Panel vertical = new Panel((new GridLayout(5,1))); //adding objects and perfecting layout
        vertical.add(intro);
        vertical.add(sizePrompt);
        vertical.add(sizeList);
        vertical.add(toppingsPromptPt1);
        vertical.add(toppingsPromptPt2);
        Panel toppingBoxes = new Panel((new GridLayout(1, 3)));
        toppingBoxes.add(toppingList1);
        toppingBoxes.add(toppingList2);
        toppingBoxes.add(toppingList3);
        Panel ending = new Panel((new GridLayout(3,1)));
        ending.add(button);
        ending.add(checkout);
        ending.add(bonus);
        button.addActionListener(this);
        add(vertical);
        add(toppingBoxes);
        add(ending);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String size = Objects.requireNonNull(sizeList.getSelectedItem()).toString(); //saves selected size in variable
        String topping1 = Objects.requireNonNull(toppingList1.getSelectedItem()).toString(); //saves selected toppings in variables
        String topping2 = Objects.requireNonNull(toppingList2.getSelectedItem()).toString();
        String topping3 = Objects.requireNonNull(toppingList3.getSelectedItem()).toString();
        price = 0;
        if (!(topping1.equals("None") || topping1.equals("Extra Cheese"))) //adds 50 cents if a costly topping is selected
            price += 0.5;
        if (!(topping2.equals("None") || topping2.equals("Extra Cheese"))) //does the same for the second topping
            price += 0.5;
        if (!(topping3.equals("None") || topping3.equals("Extra Cheese"))) //does the same for the third
            price += 0.5;
        if (price == 1.5)
            price = 1.25; //if all three toppings are valid for the discount, applies the discount
        switch (size) { //adds the price of the pizza's size
            case "Small ($5)" -> price += 5.0;
            case "Medium ($10)" -> price += 10.0;
            case "Large ($15)" -> price += 15.0;
            case "Super ($20)" -> price += 20.0;
        }
        String checkoutLine = size + " Pizza"; //base sentence
        if(topping1.equals("None") && topping2.equals("None") && topping3.equals("None"))
            checkoutLine += ". No toppings."; // finishes sentence if there is no toppings
        else if (topping1.equals("None") && topping2.equals("None")) //finishes sentence with 1 topping
            checkoutLine += " with " + topping3 + ".";
        else if (topping3.equals("None") && topping2.equals("None"))
            checkoutLine += " with " + topping1 + ".";
        else if (topping3.equals("None") && topping1.equals("None"))
            checkoutLine += " with " + topping2 + ".";
        else if (topping1.equals("None"))
            checkoutLine += " with " + topping2 + " and " + topping3 + "."; //finishes sentence with 2 toppings
        else if (topping2.equals("None"))
            checkoutLine += " with " + topping1 + " and " + topping3 + ".";
        else if (topping3.equals("None"))
            checkoutLine += " with " + topping1 + " and " + topping2 + ".";
        else
            checkoutLine += " with " + topping1 + ", " + topping2 + ", and " + topping3 + "."; //finishes sentence with 3 toppings
        if((!topping1.equals("None") && (topping1.equals(topping2) && topping2.equals(topping3))))
            bonus.setText ("Wow! That's a lot of " + topping1 + "."); //bonus text if triggered
        checkoutLine += " Your total is $" + String.format("%.2f", price) + "."; //add final price to string
        checkout.setText (checkoutLine); //allows the price and order breakdown to be printed on the screen
    }
    public static void main(String[] args) {
        PizzaDesigner example = new PizzaDesigner();
        example.setVisible(true);

    }
    }