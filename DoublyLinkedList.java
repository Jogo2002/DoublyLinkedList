import edu.princeton.cs.algs4.Stack;
import java.awt.image.CropImageFilter;


public class DoublyLinkedList<Item> {
    private Item item;

    private DoubleNode<Item> head;
    private DoubleNode<Item> tail;
    private int n;

    public Item get(Integer index) {
        DoubleNode currentNode = head;
        int counter = 0;
        while (currentNode.next != null) {
            if (counter == index) {
                return (Item) currentNode.item;
            }
            currentNode = currentNode.next;
            counter++;
        }
        return null;
    }

    public void set(Integer index, Item newItem) {
        DoubleNode currentNode = head;
        int counter = 0;
        while (currentNode.next != null) {
            if (counter == index) {
                currentNode.item = newItem;
            }
            currentNode = currentNode.next;
            counter++;
        }
    }

    private static class DoubleNode<Item> {
        private Item item;
        private DoublyLinkedList.DoubleNode<Item> next;

        private DoublyLinkedList.DoubleNode<Item> previous;
    }

    public void ExtraSpecialInsertFirst(Item item) {
        DoubleNode newFirst = new DoubleNode<Item>();
        newFirst.item = item;
        if (head == null) {
            head = newFirst;
            tail = newFirst;
        } else {
            DoubleNode oldFirst = head;
            head = newFirst;
            newFirst.next = oldFirst;
            oldFirst.previous = newFirst;
            newFirst.previous = null;
        }
    }


    public void InsertLast(Item item) {
        DoubleNode newLast = new DoubleNode<Item>();
        newLast.item = item;
        if (tail == null) {
            tail = newLast;
            head = newLast;
            newLast.next = null;
            newLast.previous = null;
        } else {
            newLast.previous = tail;
            tail.next = newLast;
            tail = newLast;
            newLast.next = null;
        }
    }

    public void InsertAfterGiven(Integer index, Item newItem) {
        DoubleNode currentNode = head;
        int counter = 0;
        counter++;

        while (currentNode != null) {
            if (counter == index) {
                DoubleNode newNode = new DoubleNode<Item>();
                newNode.item = newItem;

                newNode.next = currentNode.next;
                currentNode.next = newNode;
                newNode.previous = currentNode;

                if (tail == currentNode) {
                    tail = newNode;
                } else {
                newNode.next.previous = newNode;
            }
            return;
        }

        counter++;
        currentNode = currentNode.next;
    }

}


    public void RemoveExtraSpecialBeginning() {
        if (head == null){
            return;
        } else {
            DoubleNode newFirst = head.next;
            head.next = null;
            newFirst.previous = null;
            head = newFirst;
        }
    }

    public void RemoveCaboose() {
        if (tail == null) {
            return;
        } else if (tail.previous == null) {
            tail = null;
            head = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
    }

    public void ExtraSpecialInsertBeforeGiven(Item item){

    }

    public void ExtraSpecialInsertAfterGiven(Item item){


    }

    public void ExtraSpecialRemoveGiven(){

    }




    public static void main(String[] args) {
        DoublyLinkedList testList = new DoublyLinkedList<String>();
        testList.InsertLast("Planters Peanut");
        testList.ExtraSpecialInsertFirst("Brazil");
        testList.ExtraSpecialInsertFirst("Argentina");
        testList.ExtraSpecialInsertFirst("China Walnode");
        testList.ExtraSpecialInsertFirst("Green Goldnut");
        testList.InsertLast("Walnut");
        testList.InsertLast("rihanna 4head");
        testList.InsertLast("lebruh jahames");
        testList.ExtraSpecialInsertFirst("Switzerland");
        testList.RemoveCaboose();
        testList.RemoveCaboose();
        testList.RemoveExtraSpecialBeginning();
        testList.InsertAfterGiven(4, "schmunk2000");
        testList.InsertAfterGiven(1, "schmunktastic01");


        DoubleNode CurNode = testList.head;
        while (CurNode.next != null) {

            System.out.println(CurNode.item);
            CurNode = CurNode.next;
        }
        System.out.println(CurNode.item);

    }
}