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
        extendArray();

        if (size < 1) {
            elements[0] = aString;
        }
        else {
            elements[size] = aString;
        }

        size++;
    }

    public void extendArray() {
        if (elements.length == 0) {
            elements = new String[10];
            return;
        }


        if (elements.length == size) {
            String[] temparray = new String[elements.length * 2];
            for (int i = 0; i < size; i++) {
                temparray[i] = elements[i];
            }
            elements = temparray;
        }
    }


    public String get(int index) {
        if (index > size - 1) {
            return null;
        }

        String result = elements[index];
        return (result != null) ? result : null;
    }

    public void deleteElement(int toBeDeletedElement) {
        if (size == 0 || toBeDeletedElement < 0 || toBeDeletedElement > size - 1) {
            return;
        }
        String[] tempArray = new String[elements.length - 1];
        elements[toBeDeletedElement] = null;
        int indexOrigin = 0;
        int indexTarget = 0;

        while (indexOrigin < size) {
            if (elements[indexOrigin] != null) {
                tempArray[indexTarget] = elements[indexOrigin];
                indexOrigin++;
                indexTarget++;
            }
            else {
                indexOrigin++;
            }
        }
        elements = tempArray;
        size--;
    }

    public void clear() {
        elements = new String[10];
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
                tempArray[indexTarget] = elements[indexOrigin];
                indexOrigin++;
            }
            indexTarget++;
        }
        elements = tempArray;
        size++;
    }
}
