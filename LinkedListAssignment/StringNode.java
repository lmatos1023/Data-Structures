public class StringNode //simple class for a node storing a String
{
    private String value;
    private StringNode next;
    private StringNode prev;
    public StringNode(String value)
    {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
    public String getValue()
    {
        return value;
    }
    public void setValue(String value)
    {
        this.value = value;
    }
    public StringNode getNext()
    {
        return next;
    }
    public void setNext(StringNode next)
    {
        this.next = next;
    }
    public StringNode getPrev()
    {
        return prev;
    }
    public void setPrev(StringNode prev)
    {
        this.prev = prev;
    }
}
