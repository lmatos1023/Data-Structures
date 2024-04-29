public class TreeNode //class containing information and methods required for a node within the binary tree
{
    private String question; //stores the question this node asks
    private TreeNode yesNode; //stores the node that would result from the user answering yes
    private TreeNode noNode; //stores the node that would result from the user answering no
    public TreeNode(String q) //constructor method with the question as a parameter
    {
        question = q; //sets the value of question to the parameter
        yesNode = null; //sets the yes and no Nodes to null to avoid issues
        noNode = null;
    }
    //basic get and set methods
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public TreeNode getYesNode() {
        return yesNode;
    }
    public void setYesNode(TreeNode yesNode) {
        this.yesNode = yesNode;
    }
    public TreeNode getNoNode() {
        return noNode;
    }
    public void setNoNode(TreeNode noNode) {
        this.noNode = noNode;
    }
    public boolean isLeaf() //method to determine if a node is a leaf, in order to figure out which nodes are answer nodes
    {
        return yesNode == null && noNode == null;
    }
}

