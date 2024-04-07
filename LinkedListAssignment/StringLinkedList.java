public class StringLinkedList  //class for a LinkedList of only Strings, containing all required methods that are applicable to Strings
{
    private StringNode head;
    private StringNode tail;
    public StringLinkedList()
    {
        head = null;
        tail = null;
    }
    public void insertNode(String value){ //method to add a node at the end of the LinkedList
        StringNode node = new StringNode(value);
        if(head == null){
            head = node;
        }
        else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
    }
    public StringNode searchNode(String value){ //method to search for a return a node by the String value
        StringNode current = head;
        if(!current.getValue().equals(value)){
            while(current.getNext() != null){
                String value2 = current.getNext().getValue();
                if(value2.equals(value)){
                    System.out.println("Current Node : " + current.getNext().getValue());
                    return current.getNext();
                }
                else
                    current = current.getNext();
            }
        }
        return current;
    }
    public void deleteNode(String value){ //deletes the first node encountered in the LinkedList with a value matching the String input by the user
        StringNode current = head;
        if(!current.getValue().equals(value)){
            while(current.getNext() != null){
                String value2 = current.getNext().getValue();
                if(value2.equals(value)){
                    System.out.println("Prev Node    : " + current.getValue());
                    System.out.println("Current Node : " + current.getNext().getValue());
                    if(current.getNext().getNext() != null) {
                        System.out.println("Next Node    : " + current.getNext().getNext().getValue());
                        current.setNext(current.getNext().getNext());
                    }
                    else
                    {
                        System.out.println("Next Node    : No valid node");
                        current.setNext(null);
                    }
                    System.out.println("=====================");
                    break;
                }
                else
                    current = current.getNext();
            }
        }
    }
    public void printList(){ //method to print the LinkedList
        StringNode current = head;
        System.out.println("========Print Start=============");
        while(current.getNext() != null){
            String currentNodeValue = current.getValue();
            if(current.getPrev() != null)
                System.out.println(currentNodeValue  + " <==> " + current.getPrev().getValue());
            else
                System.out.println(currentNodeValue + " Does not have Previous node");
            System.out.println(currentNodeValue + " <==> " + current.getNext().getValue());
            current = current.getNext();

        }
        System.out.println("========Print End=============");
    }
    public void removeAfter(StringNode node){  //method to remove the node after the input node
        if (node != null && node.getNext() != null)
        {
            node.setNext(node.getNext().getNext()); //sets the 'next' part of the node to the node after the one we are deleting
            node.getNext().setPrev(node); //sets the 'prev' part of the node after the one we are deleting to the input node, effectively removing the desired node from the LinkedList
        }
    }
    public StringLinkedList copy(StringNode startNode){ //creates a copy of the LinkedList, starting at the node and continuing until the LinkedList's tail
        StringLinkedList copied = new StringLinkedList();
        StringNode current = startNode;
        while(current.getNext() != null){
            copied.insertNode(current.getValue());
            current = current.getNext();
        }
        return copied;
    }
    public void removeDuplicate(String value) { //removes all nodes containing the input String by cycling through the LinkedList from head to tail
        StringNode current = head;
        int matchCt = 0; //tracks how many nodes match the value given
        if(!current.getValue().equals(value)) { //searches the linkedlist, tallying the number of matches
            while (current.getNext() != null) {
                String value2 = current.getNext().getValue();
                if (value2.equals(value)) {
                    matchCt++;
                    current = current.getNext();
                }
            }
        }
        for(int i=1; i<= matchCt; i++) //loop deletes the nodes matching the given value, cycling however many times that value appears in the linkedlist
        {
            deleteNode(value);
        }
    }
}
