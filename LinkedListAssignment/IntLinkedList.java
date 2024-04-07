public class IntLinkedList //class for a LinkedList of only ints, containing all required methods that are applicable to ints
{
    private IntNode head;
    private IntNode tail;
    public IntLinkedList()
    {
        head = null;
        tail = null;
    }
    public void insertNode(int value){  //method to add a node at the end of the LinkedList
        IntNode node = new IntNode(value);
        if(head == null){
            head = node;
        }
        else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
    }
    public IntNode searchNode(int value){  //method to search for a return a node by the int value
        IntNode current = head;
        if(current.getValue() != value){
            while(current.getNext() != null){
                int value2 = current.getNext().getValue();
                if(value2 == value){
                    System.out.println("Current Node : " + current.getNext().getValue());
                    return current.getNext();
                }
                else
                    current = current.getNext();
            }
        }
        return current;
    }
    public void deleteNode(int value){  //deletes the first node encountered in the LinkedList with a value matching the int input by the user
        IntNode current = head;
        if(current.getValue() != value){
            while(current.getNext() != null){
                int value2 = current.getNext().getValue();
                if(value2 == value){
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
    public void printList(){  //method to print the LinkedList
        IntNode current = head;
        System.out.println("========Print Start=============");
        while(current.getNext() != null){
            int currentNodeValue = current.getValue();
            if(current.getPrev() != null)
                System.out.println(currentNodeValue  + " <==> " + current.getPrev().getValue());
            else
                System.out.println(currentNodeValue + " Does not have Previous node");
            System.out.println(currentNodeValue + " <==> " + current.getNext().getValue());
            current = current.getNext();

        }
        System.out.println("========Print End=============");
    }
    public void removeAfter(IntNode node){  //method to remove the node after the input node
        if (node != null && node.getNext() != null)
        {
            if(node.getNext().getNext() != null) {
                node.setNext(node.getNext().getNext()); //sets the 'next' part of the node to the node after the one we are deleting
                node.getNext().setPrev(node);  //sets the 'prev' part of the node after the one we are deleting to the input node, effectively removing the desired node from the LinkedList
            }
            else
            {
                tail = node;
                node.setNext(null);
            }
        }
    }
    public IntLinkedList copy(){ //creates a copy of the LinkedList, starting at the head and continuing until the LinkedList's tail
        IntLinkedList copied = new IntLinkedList();
        IntNode current = head;
        while(current.getNext() != null){
            copied.insertNode(current.getValue());
            current = current.getNext();
        }
        return copied;
    }
    public int max(){ //method to return the maximum value stored in the LinkedList
        if(head == null)
            return 0; //returns 0 if the LinkedList is empty
        else {
            IntNode current = head; //sets the max to the value of the first node, then loops through the LinkedList, altering the max value if a Node's value is greater than the current max
            int max = current.getValue();
            while(current.getNext() != null){
                if(current.getNext().getValue() > max){
                    max = current.getNext().getValue();
                }
                current = current.getNext();
            }
            return max;
        }
    }
}
