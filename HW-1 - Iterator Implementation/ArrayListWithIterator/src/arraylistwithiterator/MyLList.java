/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistwithiterator;

import java.util.*;

/**
 *
 * @author kmehta
 */
public class MyLList<E extends Comparable<? super E>> implements ListInterface<E> {

    private boolean integrityOK;
    private ListNode firstNode; // reference to first node of the list
    private ListNode lastNode; // reference to last node of the list
    private int numberOfEntries; // number of entries in list

    // constructor
    public MyLList() {
        clear();
    } // end default constructor

    // clear list. Set firstNode to NULL
    public final void clear() {

        integrityOK = false;

        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;

        integrityOK = true;
    } // end clear

    private void checkIntegrity() {

        if (!integrityOK)
            throw new SecurityException("Corrupt Linked List.. cannot continue..");

    }// end checkIntegorty

    public boolean isEmpty() {

        return (firstNode == null);

    } // end isEmpty

    public int getLength() {
        return numberOfEntries;
    }

    public boolean contains(E anEntry) {

        checkIntegrity();
        ListNode fn = firstNode;

        if (fn == null)
            return false;
        else if (fn.getData().equals(anEntry))
            return true;
        else {
            do {
                fn = fn.next;
                if (anEntry.equals(fn.getData()))
                    return true;
            } while (fn.next != null);
        }
        return false;
    }

    /*
     * public void printAll() {
     * 
     * E[] arr = this.toArray();
     * for(int i = 0; i < arr.length; i++) {
     * System.out.println(arr[i]);
     * }
     * }
     * 
     * public String toArray() {
     * 
     * boolean done = false;
     * if(firstNode == null) return null;
     * 
     * String outputStr = "[";
     * 
     * int count = 0;
     * ListNode currentNode = firstNode;
     * 
     * do {
     * outputStr += currentNode.getData().toString();
     * count++;
     * if(currentNode.next == null)
     * done = true;
     * else currentNode = currentNode.next;
     * } while (!done);
     * 
     * return outputStr += "]";
     * 
     * }// end toArray
     * 
     */

    public void printAll() {

        Comparable[] arr = this.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public E[] toArray() {

        if (firstNode == null)
            return null;

        E[] arr = (E[]) new Comparable[numberOfEntries];

        int count = 0;
        ListNode currentNode = firstNode;

        do {
            arr[count] = currentNode.getData();
            count++;
            if (currentNode.next == null) {
                break;
            }
            currentNode = currentNode.next;
        } while (!(currentNode.equals(lastNode)));

        arr[count] = lastNode.getData();
        return arr;

    }// end toArray

    private ListNode getNodeAt(int givenPosition) {

        checkIntegrity();
        // use temporary node currentNode to traverse
        // list starting at firstNode
        ListNode currentNode = firstNode;
        // traverse the list to locate the desired node
        for (int counter = 1; counter < givenPosition; counter++) {
            currentNode = currentNode.next;
        }

        // currentList now refers to node at givenPosition
        return currentNode;
    } // end getNodeAt

    public E getEntry(int i) {

        Comparable[] arr = this.toArray();

        E element = null;
        if ((i > 0) && (i < arr.length)) {
            element = (E) arr[i - 1];
        }

        return element;

    } // end getEntry

    public E replace(int position, E anEntry) {

        checkIntegrity();
        boolean success = false;

        if (!((position >= 1) && (position <= numberOfEntries))) {
            return null;
        } else {

            ListNode theNode = this.getNodeAt(position - 1);
            theNode.setData(anEntry);
            success = true;
        }

        return anEntry;

    } // end replace

    public E remove(int position) {

        checkIntegrity();

        E result = null; // return value

        if ((position >= 1) && (position <= numberOfEntries)) {
            if (position == 1) { // case 1: first node, remove first entry
                result = firstNode.data; // save entry to be removed
                firstNode = firstNode.next;
            } else { // case 2: not first node
                ListNode nodeBefore = getNodeAt(position - 1);
                ListNode nodeToRemove = nodeBefore.next;
                ListNode nodeAfter = nodeToRemove.next;
                nodeBefore.next = nodeAfter; // disconnect the node to be removed
                result = nodeToRemove.getData(); // save entry to be removed
            } // end if

            numberOfEntries--;

        } else {

            System.out.println(position + ": is out of range of the list with size: " + numberOfEntries);

        } // end if

        return result; // return removed entry, or

    } // end remove(int i)

    public ListInterface<E> getAllLessThan(Comparable<E> elementToCompare) {

        ListInterface<E> resultList = new MyLList<>();
        ListNode currentNode = firstNode;
        boolean done = false;

        do {
            E currentElement = currentNode.getData();
            if (elementToCompare.compareTo(currentElement) > 0)
                resultList.add(currentElement);
            if (currentNode.getNextNode() == null)
                done = true;
            currentNode = currentNode.getNextNode();
        } while (!done);

        return resultList;

    } // end getAllLessThan

    /**
     * add an existing entry of this list.
     * The list size is increased by 1.
     * 
     * @param anEntry The object to be added as a new entry.
     */
    public void add(E anEntry) {

        checkIntegrity();

        // get new node to hold newEntry
        ListNode newNode = new ListNode(anEntry);

        // adding to empty list
        if (isEmpty()) {
            firstNode = newNode;
        }

        // add to non-empty list
        else {
            ListNode lastNode = getNodeAt(numberOfEntries);
            lastNode.next = newNode; // make last node reference new node
        } // end if
        lastNode = newNode;
        numberOfEntries++;
    }

    public void add(int insertPosition, E anEntry) {

        ListNode nodeBefore, nodeAfter;

        checkIntegrity();

        if ((insertPosition >= 1) && (insertPosition <= numberOfEntries + 1)) {
            ListNode newNode = new ListNode(anEntry);
            if (isEmpty() || (insertPosition == 1)) {
                newNode.next = firstNode;
                firstNode = newNode;
                lastNode = newNode;
            } else {
                nodeBefore = getNodeAt(insertPosition - 1);

                if (nodeBefore.next == null) {
                    nodeBefore.next = newNode;
                    newNode.next = null;
                    lastNode = newNode;
                } else {
                    nodeAfter = nodeBefore.next;
                    newNode.next = nodeAfter;
                    nodeBefore.next = newNode;
                    lastNode = nodeAfter;
                }
            }

            numberOfEntries++;

        } else {
            System.out.println("Invalid insert position.");
        }
    }

    public ListNode getFirstNode() {
        return firstNode;
    }

    public void printLinkedList() {

        int nodeCount = 1;
        ListNode currentNode = firstNode;
        E data = (E) currentNode.getData();

        System.out.println("Node[1]: " + data);

        while ((currentNode.getNextNode() != null)) {

            currentNode = currentNode.getNextNode();
            data = (E) currentNode.getData();
            System.out.println("Node[" + (++nodeCount) + "]: " + data);

        }
    }

    /**
     *
     * @author kmehta
     */
    public class ListNode {

        public E data; // entry in queue
        public ListNode next; // link to next node

        public ListNode(E anEntry) {
            this(anEntry, null);
        }

        public ListNode(E anEntry, ListNode n) {
            this.data = anEntry;
            this.next = n;
        }

        public E getData() {
            return data;
        }

        public ListNode getNextNode() {
            return this.next;
        }

        public void setNextNode(ListNode anEntry) {
            this.next = anEntry;
        }

        public void setData(E anEntry) {
            this.data = anEntry;
        }

    } // end QueueNode

    public Iterator<E> getIterator() {
        return new IteratorForLinkedList();
    }

    public Iterator<E> iterator() { // If you prefer using iterator() method
        return getIterator();
    }

    private class IteratorForLinkedList implements Iterator<E> {
        private ListNode currentNode; // Keeps track of the current position
        private boolean wasNextCalled; // Flag for tracking calls to next() for remove()

        private IteratorForLinkedList() {
            currentNode = firstNode;
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
                E data = currentNode.getData();
                currentNode = currentNode.getNextNode();
                return data;
            } else {
                throw new NoSuchElementException("Iterator is past end of the list.");
            }
        }

        @Override
        public void remove() {
            if (wasNextCalled) {
                ListNode nodeBefore = null;

                // Edge Case: Removing the first node
                if (currentNode == firstNode) {
                    firstNode = firstNode.next;
                } else { // General case: removing a middle or last node
                    nodeBefore = getNodeAt(getIteratorPosition() - 1); // Get node before `currentNode`
                    nodeBefore.next = currentNode.next; // Bypass `currentNode`
                    if (currentNode == lastNode) {
                        lastNode = nodeBefore; // Update lastNode if necessary
                    }
                }

                currentNode = nodeBefore.next; // Move to the element that's now after the removed element
                wasNextCalled = false;
                numberOfEntries--; // Adjust the count in MyLList
                wasNextCalled = false;
            } else {
                throw new IllegalStateException("Call next() before calling remove().");
            }
        }

        // Helper method for the iterator to get the correct position in the list
        private int getIteratorPosition() {
            ListNode iterNode = firstNode;
            int count = 1;
            while (iterNode != currentNode) {
                iterNode = iterNode.next;
                count++;
            }
            return count;
        }
    } // End of IteratorForLinkedList

}// end MyLList
