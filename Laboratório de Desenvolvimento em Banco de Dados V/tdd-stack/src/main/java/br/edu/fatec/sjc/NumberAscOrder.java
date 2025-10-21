package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<T extends Number> {

    private final CustomStack<T> stack;

    public NumberAscOrder(CustomStack<T> stack) {
        if (stack == null) {
            throw new NullPointerException("Pilha não pode ser nula");
        }
        this.stack = stack;
    }

    public List<T> sort() throws StackEmptyException {
        List<T> sortedList = new ArrayList<>();
        while (!stack.isEmpty()) {
            sortedList.add(stack.pop());
        }

        Collections.sort(sortedList, (o1, o2) -> Double.compare(o1.doubleValue(), o2.doubleValue()));
        return sortedList;
    }

}
