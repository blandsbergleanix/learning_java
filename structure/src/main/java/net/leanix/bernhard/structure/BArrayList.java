package net.leanix.bernhard.structure;

/**
 * Created by bernhardlandsberg on 12.07.17.
 */
public class BArrayList {

    private String[] elements;

    private int size = 0;

    public BArrayList() {
        this(10);
    }

    public BArrayList(int initialSize) {
        elements = new String[initialSize];
    }

    public int size() {
        return size;
    }

    public void add(String aString) {
        String[] temparray = new String[size + 1];
        temparray[size] = aString;

        if (first.data.length < 1) {
            first.data = temparray;
        }
        else {
            for (int i = 0; i < size; i++) {
                temparray[i] = first.data[i];
            }
            first.data = temparray;
        }
        size++;
    }

    public String get(int index) {
        if (index > size - 1) {
            return null;
        }

        String result = first.data[index];
        return (result != null) ? result : null;
    }

    public void deleteElement(int toBeDeletedElement) {
        if (size == 0 || toBeDeletedElement < 0 || toBeDeletedElement > size - 1) {
            return;
        }
        String[] tempArray = new String[first.data.length - 1];
        first.data[toBeDeletedElement] = null;
        int indexOrigin = 0;
        int indexTarget = 0;

        while (indexOrigin < size) {
            if (first.data[indexOrigin] != null) {
                tempArray[indexTarget] = first.data[indexOrigin];
                indexOrigin++;
                indexTarget++;
            }
            else {
                indexOrigin++;
            }
        }
        first.data = tempArray;
        size--;
    }

    public void clear() {
        BElement temp = new BElement();
        first = temp;
        size = 0;
    }

    public void addAll(String[] severalStrings) {
        int numberOfStrings = severalStrings.length;
        for (int i = 0; i < numberOfStrings; i++) {
            add(severalStrings[i]);
        }
    }

    public void insert(int insertIndex, String aString) {
        if (insertIndex > size - 1 || insertIndex < 0) {
            return;
        }

        String[] tempArray = new String[size + 1];
        tempArray[insertIndex] = aString;
        int indexOrigin = 0;
        int indexTarget = 0;
        while (indexOrigin < size) {
            if (indexTarget != insertIndex) {
                tempArray[indexTarget] = first.data[indexOrigin];
                indexOrigin++;
                indexTarget++;
                }
            else {
                indexTarget++;
            }
        }
        first.data = tempArray;
        size++;
    }
}
