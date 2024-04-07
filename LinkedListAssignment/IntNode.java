public class IntNode //simple class for a node storing an int
{
    private int value;
    private IntNode next;
    private IntNode prev;
    public IntNode(int value)
    {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
    public int getValue()
    {
        return value;
    }
    public void setValue(int value)
    {
        this.value = value;
    }
    public IntNode getNext()
    {
        return next;
    }
    public void setNext(IntNode next)
    {
        this.next = next;
    }
    public IntNode getPrev()
    {
        return prev;
    }
    public void setPrev(IntNode prev)
    {
        this.prev = prev;
    }
}
