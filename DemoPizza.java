import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
public class DemoPizza extends JFrame implements ActionListener
{
    String[] selected = new String[10]; //stores the selected toppings
    int toppingIndex = 0; //tracks the index we store the newest selected topping in
    boolean quit = false; //tracks if they have selected to quit toppings yet
    String[] toppings = new String[]{"QUIT", "Pepperoni", "Extra Cheese", "Pineapple", "Sausage", "Bacon",
            "Peppers", "Onions", "Spinach", "Mushroom", "Ham", "Broccoli", "Chicken Breast", "Olives",
            "Tomato", "Beef", "Anchovies", "Basil", "Jalapeno", "Salami"}; //array of toppings
    JLabel title = new JLabel("Toppings Galore Pizza Palace!");
    JLabel toppingsPrompt = new JLabel("Add up to 10 toppings to your delicious pizza.");
    JLabel instruction = new JLabel("To add a topping, select and click Confirm.");
    JLabel quitPrompt = new JLabel("Enter the 'QUIT' option to finish adding toppings.");
    JComboBox<String> toppingList = new JComboBox<>(toppings); //combo box for the toppings
    JButton tButton = new JButton("Confirm");
    JLabel delivery = new JLabel("If this pizza is for delivery, enter your address. Otherwise, enter 'No' to indicate it is not delivery.");
    JTextField deliveryInput = new JTextField();
    JButton dButton = new JButton("Confirm");
    JLabel output = new JLabel("");
    final int FRAME_WIDTH = 800; //makes dimensions of the frame
    final int FRAME_HEIGHT = 500;
    public DemoPizza()
    {
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title.setFont(new Font("Courier", Font.BOLD, 32));
        setLayout(new FlowLayout());
        Panel text = new Panel((new GridLayout(4,1))); //adding objects and perfecting layout
        text.add(title);
        text.add(toppingsPrompt);
        text.add(instruction);
        text.add(quitPrompt);
        Panel toppingChoice = new Panel((new GridLayout(1, 2)));
        toppingChoice.add(toppingList);
        toppingChoice.add(tButton);
        Panel deliv = new Panel((new GridLayout(3,1)));
        deliv.add(delivery);
        deliv.add(deliveryInput);
        deliv.add(dButton);
        tButton.addActionListener(this);
        dButton.addActionListener(this);
        add(text);
        add(toppingChoice);
        add(deliv);
        add(output);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == tButton)
        {
            String topping = Objects.requireNonNull(toppingList.getSelectedItem()).toString();
            if((!topping.equals("QUIT") && !quit))
            {
                toppingList.removeItem((toppingList.getSelectedItem()));
                selected[toppingIndex] = topping;
                toppingIndex++;
                if(toppingIndex == 10) //forces quit once ten toppings are selected
                {
                    quit = true;
                    toppingList.removeAllItems();
                    toppingList.addItem("QUIT           ");
                }
            }
            else
            {
                quit = true;
                toppingList.removeAllItems();
                toppingList.addItem("QUIT           "); //extra spaces added to keep consistent spacing
            }
        }
        if(e.getSource() == dButton)
        {
            String[] trimmed = new String[toppingIndex];
            for (int i = 0; i < toppingIndex; i++)
                trimmed[i] = selected[i];
            String input = deliveryInput.getText();
            if (input.equals("No") || (input.equals("no")))
            {
                Pizza userPizza = new Pizza(trimmed, toppingIndex);
                output.setText(userPizza.toString());
            }
            else
            {
                DeliveryPizza userDPizza = new DeliveryPizza(trimmed, toppingIndex, input);
                output.setText(userDPizza.toString());
            }
        }
    }
    public static void main(String[] args)
    {
        DemoPizza yum = new DemoPizza();
        yum.setVisible(true);
    }
}
