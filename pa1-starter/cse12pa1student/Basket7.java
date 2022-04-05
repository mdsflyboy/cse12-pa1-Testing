package cse12pa1student;

import java.util.ArrayList;
import java.util.Arrays;

public class Basket7 implements Basket {

    public Basket7() {
        this.items = new ArrayList<ArrayList<Item>>();
    }

    ArrayList<ArrayList<Item>> items;

    @Override
    public int count() {
        int count = 0;
        for (int i = 1; i < this.items.size(); i++) {
            count += this.items.get(i).size() * i;
        }
        return count;
    }

    @Override
    public int countItem(Item i) {
        for (int j = 0; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i))
                return j;
        }
        return 0;
    }

    @Override
    public int totalCost() {
        int totalCost = 0;
        for (int i = 1; i < this.items.size(); i++) {
            for (Item item : this.items.get(i)) {
                totalCost += item.priceInCents * i;
            }
        }
        return totalCost;
    }

    // Basically, this Basket determines the count of identical items by moving them to a later sublist
    @Override
    public void addToBasket(Item i) {
        for (int j = 1; j < this.items.size(); j++) { // Loop through lists
            if (this.items.get(j).contains(i)) { // If the current list has the current item
                this.items.get(j).remove(i); // Remove that item from the sub list
                if (j + 1 == this.items.size()) { // If we are at the end of the lists of lists
                    ArrayList<Item> temp = new ArrayList<Item>(); // create a temporary list
                    temp.add(i); // add the current item to the temporary list
                    this.items.add(temp); // then add the temp list to the lists of lists
                } else{
                    this.items.get(j + 1).add(i); // Just add that item to the next sub list
                }
                return;
            }
        }
        // Basically, make sure the number of lists is at least 2
        // while the number of lists is either 1 or 0
        while(this.items.size() <= 1)
            this.items.add(new ArrayList<Item>()); // add a new blank list
        // 
        this.items.get(1).add(i);
    }

    @Override
    public boolean removeFromBasket(Item i) {
        for (int j = 1; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i)) {
                this.items.get(j).remove(i);
                this.items.get(j - 1).add(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAllFromBasket(Item i) {
        for (int j = 1; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i))
                return this.items.get(j).remove(i);
        }
        return false;
    }

    @Override
    public void empty() {
        this.items.clear();
    }
}
