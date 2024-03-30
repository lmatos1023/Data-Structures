
enum Type //enum class of blood types
{
    A, B, AB, O
}
public class BloodData
{
    private static final String A = "A"; //Strings corresponding to each type
    private static final String B = "B";
    private static final String AB = "AB";
    private static final String O = "O";
    private String bloodType;
    private char rhFactor;
    public BloodData() //default constructor
    {
        bloodType = O;
        rhFactor = '+';
    }
    public BloodData(String bt, char rh) //overloaded constructor
    {
        bloodType = bt;
        rhFactor = rh;
    }
    public String getBloodType() {
        return bloodType;
    } //get and set methods for private data
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    public char getRhFactor() {
        return rhFactor;
    }
    public void setRhFactor(char rhFactor) {
        this.rhFactor = rhFactor;
    }
}
