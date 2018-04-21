package com.thoughtworks.collection;

import java.util.LinkedList;

public class MySingleLink<T> implements SingleLink<T>{
    private LinkedList<T> list = new LinkedList<>();
    @Override
    public T getHeaderData() {
        return list.getFirst();
    }

    @Override
    public T getTailData() {
        return list.getLast();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean deleteFirst() {
        return list.pollFirst() != null;
    }

    @Override
    public boolean deleteLast() {
        return list.pollLast() != null;
    }

    @Override
    public void addHeadPointer(T item) {
        list.addFirst(item);
    }

    @Override
    public void addTailPointer(T item) {
        list.addLast(item);
    }

    @Override
    public T getNode(int index) {
        return null;
    }
}
