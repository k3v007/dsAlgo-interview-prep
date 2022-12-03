package org.example.dsAlgo.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum3DS {

    private List<Integer> list;
    private Map<Integer, Integer> lookup;

    public TwoSum3DS() {
        list = new ArrayList<>();
        lookup = new HashMap<>();
    }

    public void add(int x) {
        list.add(x);
        int index = list.size() - 1;
        if (lookup.containsKey(x)) {
            lookup.replace(x, index);
        }
        lookup.put(x, index);
    }

    public String printList() {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < list.size(); ++i) {
            s.append(list.get(i));
            if (i != list.size() - 1) {
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }

    // Find two sum
    public boolean find(int target) {
        for (int i = 0; i < list.size(); ++i) {
            int diff = target - list.get(i);
            // Lookup should contain the diff and that same number can't be included as pair
            if (lookup.containsKey(diff) && i != lookup.get(diff)) {
                return true;
            }
        }
        return false;
    }
}
