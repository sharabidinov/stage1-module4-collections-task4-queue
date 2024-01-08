package com.epam.collections.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            queue.offer(i);
        }
        int size = queue.size();
        List<Integer> list = new LinkedList<>();
        while (list.size()!= size) {
            Integer element = null;
            for (int i = 0; i < everyDishNumberToEat; i++) {
                element = queue.poll();
                if(i != everyDishNumberToEat - 1) {
                    queue.offer(element);
                }
            }
            list.add(element);
        }
        return list;
    }
}
