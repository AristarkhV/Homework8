package mateacademy.homework.homework_8;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements List<T> {

    private final static int CAPACITY = 10;
    private T[] values;
    private int size;
    private int currentCapacity;

    public MyArrayList() {
        values = (T[]) new Object[CAPACITY];
        currentCapacity = CAPACITY;
    }

    private boolean indexOutOfBounds(int index) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException("out of bounds");
        }
        return true;
    }

    private void increaseCapacity() {
        if (size >= values.length) {
            currentCapacity = currentCapacity * 3 / 2;
        }
    }

    @Override
    public void add(T value) {
        increaseCapacity();
        values = Arrays.copyOf(values, currentCapacity);
        values[size] = value;
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (indexOutOfBounds(index)) {
            increaseCapacity();
            values = Arrays.copyOf(values, currentCapacity);
            System.arraycopy(values, index, values, index + 1, size);
            values[index] = value;
        }
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        increaseCapacity();
        values = Arrays.copyOf(values, currentCapacity);
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public T get(int index) {
        if (indexOutOfBounds(index)) {
            return values[index];
        }
        throw new NoSuchElementException();
    }

    @Override
    public void set(T value, int index) {
        if (indexOutOfBounds(index)) {
            this.values[index] = value;
        }
    }

    @Override
    public T remove(int index) {
        if (indexOutOfBounds(index)) {
            T temp = values[index];
            System.arraycopy(values, index + 1, values, index, values.length - index - 1);
            values = Arrays.copyOf(values, values.length - 1);
            size--;
            return temp;
        }
        throw new NoSuchElementException();
    }

    @Override
    public T remove(T t) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(t)) {
                return remove(i);
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
