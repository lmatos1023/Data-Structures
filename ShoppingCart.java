import java.util.ArrayList;

public class ShoppingCart
{
    private ArrayList<ItemOrder> list= new ArrayList<>();
    public ShoppingCart()
    {
        ArrayList<ItemOrder> list = new ArrayList<>();
    }
    public void addItem(ItemOrder item)
    {
        list.add(item);
    }
    public void removeItem(int index)
    {
        list.remove(index);
    }
    public ItemOrder find(String name) //method to find item by product name
    {
        for (ItemOrder itemOrder : list)
        {
            if(itemOrder.getProduct().getName().equals(name))
                return itemOrder;
        }
        return null;
    }
    public ItemOrder find(int index) //method to find item by index
    {
        return list.get(index);
    }
    public ItemOrder[] toArray() //converts shopping cart to array from arraylist
    {
        ItemOrder[] cart = new ItemOrder[list.size()];
        for(int i = 0; i < cart.length; i++)
        {
            cart[i] = list.get(i);
        }
        return cart;
    }
    public int cartTotal()
    {
        int total = 0;
        for (ItemOrder itemOrder : list)
            total += itemOrder.getTotalPrice();
        return total;
    }
}
