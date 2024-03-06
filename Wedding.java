import java.time.LocalDate;
public class Wedding
{
    private LocalDate date;
    private Couple spouses;
    private String location;
    public Wedding(LocalDate d, Couple s, String l)
    {
        date = d;
        spouses = s;
        location = l;
    }
    public LocalDate getDate() {
        return date;
    }
    public Couple getSpouses() {
        return spouses;
    }
    public String getLocation() {
        return location;
    }
}
