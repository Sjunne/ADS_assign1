package DataStructures;

import DataStructures.LinkedList;
import DataStructures.Stack;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

    private LinkedList<T> list;


    public LinkedStack() {
        list = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T elm) {
        list.addToFront(elm);
    }

    @Override
    public T pop() throws EmptyStackException {
        try {
            return list.removeFirst();
        } catch (List.EmptyListException e) {
            throw new EmptyStackException();
        }
    }
}