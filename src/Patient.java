public class Patient
{
    private int idNumber; //declaring private data
    private int age;
    private BloodData bloodType;
    public Patient() //default constructor
    {
        idNumber = 0;
        age = 0;
        bloodType = new BloodData();
    }
    public Patient(int id, int a, BloodData bd) //overloaded constructor
    {
        idNumber = id;
        age = a;
        bloodType = bd;
    }
    public int getIdNumber() {
        return idNumber;
    } //get and set methods
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public BloodData getBloodType() {
        return bloodType;
    }
    public void setBloodType(BloodData bloodType) {
        this.bloodType = bloodType;
    }
}
