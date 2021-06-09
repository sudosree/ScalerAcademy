package greedy.practice;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    private static int getMaxValue(int[] weights, int[] values, int maxCapacity) {
        Item[] items = new Item[weights.length];
        for (int i=0;i<weights.length;i++) {
            Item item = new Item(weights[i], values[i]);
            items[i] = item;
        }
        Arrays.sort(items, new MyComparator());
        int maxValue = 0;
        for (Item item : items) {
            int currCapacity = item.weight;
            // this item can be selected as a whole
            if (maxCapacity - currCapacity >= 0) {
                maxCapacity -= currCapacity;
                maxValue += item.value;
            }
            // this item cannot be selected as a whole, break the item or take fraction of this item
            else {
                double fraction = (double)maxCapacity / (double)currCapacity;
                maxValue += (item.value * fraction);
                maxCapacity -= (currCapacity * fraction);
                break;
            }
        }
        return maxValue;
    }

    static class Item {
        int weight;
        int value;
        double ratio;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double)value / (double)weight;
        }
    }

    static class MyComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            if (o2.ratio == o1.ratio) {
                return 0;
            }
            return o2.ratio < o1.ratio ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        System.out.println(getMaxValue(weights, values, capacity));
    }
}
