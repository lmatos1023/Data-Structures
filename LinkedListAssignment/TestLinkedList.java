public class TestLinkedList //testing class for both Int and String linkedlists
{
    public static void main(String []args)
    {
        IntLinkedList nums = new IntLinkedList();
        nums.insertNode(5);
        nums.insertNode(12);
        nums.insertNode(2);
        nums.insertNode(36);
        nums.insertNode(100);
        nums.printList();
        IntLinkedList numCopy = nums.copy();
        numCopy.insertNode(300);
        System.out.println(numCopy.max());
        System.out.println(nums.max());
        nums.removeAfter(nums.searchNode(36));
        nums.printList();
        System.out.println(nums.max());
        numCopy.deleteNode(300);
        numCopy.printList();
        StringLinkedList rpdr16 = new StringLinkedList();
        rpdr16.insertNode("Nymphia");
        rpdr16.insertNode("Sapphira");
        rpdr16.insertNode("Plane Jane");
        rpdr16.insertNode("Plasma");
        rpdr16.insertNode("Dawn");
        rpdr16.insertNode("Plasma");
        rpdr16.insertNode("Mirage");
        rpdr16.insertNode("Plasma");
        rpdr16.printList();
        rpdr16.removeDuplicate("Plasma");
        rpdr16.printList();
    }
}
