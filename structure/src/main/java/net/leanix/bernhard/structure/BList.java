package net.leanix.bernhard.structure;

public class BList {

    private BElement first;
    private BElement last;
    private int size = 0;

    public int size() {
        return size;
    }

    public void add(String aString) {
        BElement element = new BElement();
        element.data = aString;

        if (first == null) {
            first = element;
            last = element;
        } else {
            last.connectNextElement(element);
            last = element;
        }
        size++;
    }

    public void addAll(String[] severalStrings) {
        int numberOfStrings = severalStrings.length;
        for (int i = 0; i < numberOfStrings; i++) {
            add(severalStrings[i]);
        }
    }
    //obsolet
    private BElement findLast() {
        BElement current = first;
        while (current.hasNext()) {
            current = current.next;
        }
        return current;
    }

    public String get(int index) {
        BElement result = findElement(index);
        return (result != null) ? result.data : null;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public void deleteElement(int elementIndex) {
        if (size == 0) {
            return;
        }

        if (elementIndex != 0) {
            BElement toBeDeleted = findElement(elementIndex);
            if (toBeDeleted == null) {
                return;
            }

            BElement previousElement = toBeDeleted.prev;
            BElement nextElement = toBeDeleted.next;
            if (!toBeDeleted.hasNext()) {
                last = toBeDeleted.prev;
            }
            toBeDeleted.disconnect();
            previousElement.connectNextElement(nextElement);
        }
        else {
            first = first.next;
        }
        size--;
    }

    private BElement findElement(int elementIndex) {
        if (elementIndex >= size) {
            return null;
        }

        BElement current = first;
        for (int i = 0; i < elementIndex; i++) {
            current = current.next;
        }
        return current;
    }

    public void insert(int elementIndex, String aString) {
        if (size == 0 || elementIndex > size) {
            return;
        }

        BElement toBeAdded = new BElement();
        toBeAdded.data = aString;
        if (elementIndex != 0) {
            BElement nextElement = findElement(elementIndex);
            BElement prevElement = nextElement.prev;
            toBeAdded.connectNextElement(nextElement);
            prevElement.connectNextElement(toBeAdded);
        }
        else {
            toBeAdded.connectNextElement(first);
            first = toBeAdded;
        }

        size++;
    }

    private class BElement {
        String data;
        BElement next;
        BElement prev;

        public boolean hasNext() {
            return next != null;
        }

        public boolean hasPrev() {
            return prev != null;
        }

        public void connectNextElement(BElement nextElement) {
            if (nextElement == null) {
                return;
            }

            this.next = nextElement;
            nextElement.prev = this;
        }

        public void disconnect() {
            if (this.hasNext()) {
                next.prev = null;
            }

            if (this.hasPrev()) {
                prev.next = null;
            }

            this.prev = null;
            this.next = null;
        }


    }
}
