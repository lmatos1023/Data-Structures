import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Objects;
public class TestWedding extends JFrame implements ActionListener
{
    JLabel title = new JLabel("Plan a Wonderful Wedding!"); //creating JFrame objects
    JLabel datePrompt = new JLabel("When's the big day? Enter the day, then month, then year.");
    JLabel brideFirstPrompt = new JLabel("The bride's first name?");
    JLabel brideLastPrompt = new JLabel("The bride's last name?");
    JLabel groomFirstPrompt = new JLabel("The groom's first name?");
    JLabel groomLastPrompt = new JLabel("And the groom's last name?");
    JLabel locationPrompt = new JLabel(" What's the Venue?");
    JLabel dayPrompt = new JLabel("Enter the day as a number here.");
    JLabel monthPrompt = new JLabel("Enter the month as a number here.");
    JLabel yearPrompt = new JLabel("Enter the year as a number here.");
    JLabel bridesmaidsPrompt = new JLabel("The number of bridesmaids?"); //extra feature adds bridesmaid and groomsmen count
    JLabel groomsmenPrompt = new JLabel("And groomsmen?");
    JTextField bridesmaidCount = new JTextField();
    JTextField groomsmenCount = new JTextField();
    JTextField brideFirstName = new JTextField();
    JTextField groomFirstName = new JTextField();
    JTextField brideLastName = new JTextField();
    JTextField groomLastName = new JTextField();
    JTextField locationName = new JTextField();
    JTextField inputDay = new JTextField();
    JTextField inputMonth = new JTextField();
    JTextField inputYear = new JTextField();

    JButton button = new JButton("Confirm All Inputs");
    JLabel display1 = new JLabel(""); //displays all wedding info at the end
    JLabel display2 = new JLabel("");
    JLabel display3 = new JLabel("");
    JLabel display4 = new JLabel("");
    final int FRAME_WIDTH = 700; //makes dimensions of the frame
    final int FRAME_HEIGHT = 500;
    public TestWedding()
    {
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title.setFont(new Font("Algerian", Font.BOLD, 32));
        display1.setFont(new Font("Arial", Font.BOLD, 12));
        display2.setFont(new Font("Arial", Font.BOLD, 12));
        display3.setFont(new Font("Arial", Font.BOLD, 12));
        setLayout(new FlowLayout());
        Panel titlePanel = new Panel((new GridLayout(1,1))); //adding objects and perfecting layout
        titlePanel.add(title);
        Panel names = new Panel((new GridLayout(2, 4)));
        names.add(brideFirstPrompt);
        names.add(brideLastPrompt);
        names.add(groomFirstPrompt);
        names.add(groomLastPrompt);
        names.add(brideFirstName);
        names.add(brideLastName);
        names.add(groomFirstName);
        names.add(groomLastName);
        Panel venue = new Panel((new GridLayout(3,1)));
        venue.add(locationPrompt);
        venue.add(locationName);
        venue.add(datePrompt);
        Panel datePicker = new Panel((new GridLayout(2, 3)));
        datePicker.add(dayPrompt);
        datePicker.add(monthPrompt);
        datePicker.add(yearPrompt);
        datePicker.add(inputDay);
        datePicker.add(inputMonth);
        datePicker.add(inputYear);
        Panel bridalParty = new Panel((new GridLayout(2,2)));
        bridalParty.add(bridesmaidsPrompt);
        bridalParty.add(groomsmenPrompt);
        bridalParty.add(bridesmaidCount);
        bridalParty.add(groomsmenCount);
        button.addActionListener(this);
        add(titlePanel);
        add(names);
        add(venue);
        add(datePicker);
        add(bridalParty);
        add(button);
        add(display1);
        add(display2);
        add(display3);
        add(display4);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String bFirst = brideFirstName.getText(); //storing the inputs from textfields in variables
        String bLast = brideLastName.getText();
        String gFirst = groomFirstName.getText();
        String gLast = groomLastName.getText();
        String location = locationName.getText();
        int day = Integer.parseInt(inputDay.getText()); //converting the numbers in the date textfields into integers so they can be put into the LocalDate variable
        int month = Integer.parseInt(inputMonth.getText());
        int year = Integer.parseInt(inputYear.getText());
        int bridesmaids = Integer.parseInt(bridesmaidCount.getText());
        int groomsmen = Integer.parseInt(groomsmenCount.getText());
        Person bride = new Person(bFirst, bLast); //creating Person objects
        Person groom = new Person(gFirst, gLast);
        Couple newlyweds = new Couple (bride, groom); //creating a Couple and Date
        LocalDate weddingDate = LocalDate.of(year,month,day);
        Wedding createdWedding = new Wedding(weddingDate, newlyweds, location); //creating a Wedding object from the user's input!
        display1.setText("Congratulations on your wedding! In holy matrimony, we bring together ") ;
        display2.setText(bFirst+ " " +bLast+ " and "+ gFirst+ " " +gLast+ " on " + month + "/"+day+"/"+year+". ");
        display3.setText("We have a bridal party of " + bridesmaids + " bridesmaids and " + groomsmen + " groomsmen.");
        display4.setText("Come join us in celebrating their union at "+location+".");
    }
    public static void main(String[] args) {
        TestWedding example = new TestWedding();
        example.setVisible(true);

    }
}
