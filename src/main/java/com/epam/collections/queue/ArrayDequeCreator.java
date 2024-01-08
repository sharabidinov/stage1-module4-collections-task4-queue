package com.epam.collections.queue;

import java.util.*;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> result = new ArrayDeque<>();

        result.add(Objects.requireNonNull(firstQueue.remove()));
        result.add(Objects.requireNonNull(firstQueue.remove()));
        result.add(Objects.requireNonNull(secondQueue.remove()));
        result.add(Objects.requireNonNull(secondQueue.remove()));
        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
            firstQueue.add(result.removeLast());
            result.add(Objects.requireNonNull(firstQueue.remove()));
            result.add(Objects.requireNonNull(firstQueue.remove()));
            secondQueue.add(result.removeLast());
            result.add(Objects.requireNonNull(secondQueue.remove()));
            result.add(Objects.requireNonNull(secondQueue.remove()));
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayDequeCreator tst = new ArrayDequeCreator();
        ArrayDeque<Integer> res = tst.createArrayDeque(new LinkedList<>(List.of(1, 3, 5, 4, 7, 9)),
                new LinkedList<>(List.of(4, 2, 8, 5, 8, 3)));
        System.out.println(res);
    }
}
