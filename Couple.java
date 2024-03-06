public class Couple
{
    private Person bride;
    private Person groom;
    public Couple (Person b, Person g)
    {
        bride = b;
        groom = g;
    }
    public Person getBride() {
        return bride;
    }
    public Person getGroom() {
        return groom;
    }
}
