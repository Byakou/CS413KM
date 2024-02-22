package arraylistwithiterator;

import java.util.*;

public class LinkedListWithIterator<E extends Comparable<? super E>> extends MyLList<E>
        implements ListWithIteratorInterface<E> {

    public LinkedListWithIterator() {
        super(); // Call the MyLList constructor
    }

    private MyLList<E> outerList; // Member variable

    private IteratorForLinkedList(MyLList<E> list) { // Modified constructor
        currentNode = list.firstNode; 
        wasNextCalled = false;
        this.outerList = list; 
    }

    @Override
    public Iterator<E> getIterator() {
        return new IteratorForLinkedList(this);
    }

    @Override
    public Iterator<E> iterator() {
        return getIterator();
    }

    private class IteratorForLinkedList implements Iterator<E> {
        private ListNode currentNode;
        private boolean wasNextCalled;

        private IteratorForLinkedList() {
            currentNode = first;
            wasNextCalled = false;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            if (hasNext()) {
                wasNextCalled = true;
                E currentData = currentNode.getData();
                currentNode = currentNode.getNextNode();
                return currentData;
            } else {
                throw new NoSuchElementException("Illegal call to next(); iterator is after end of list.");
            }
        }

        @Override
        public void remove() {
            if (wasNextCalled) {
                ListNode nodeBefore = null;

                // Edge Case: Removing the first node
                if (currentNode == first) {
                    first = first.next;
                } else { // General case: removing a middle or last node
                    nodeBefore = getNodeAt(getIteratorPosition() - 1);
                    nodeBefore.next = currentNode.next;
                    if (currentNode == lastNode) {
                        lastNode = nodeBefore;
                    }
                }

                currentNode = nodeBefore.next;
                wasNextCalled = false;
                numberOfEntries--; // Adjust the count in MyLList
            } else {
                throw new IllegalStateException("Call next() before calling remove().");
            }
        }
    }
}
