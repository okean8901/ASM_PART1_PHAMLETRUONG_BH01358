package Linked_List;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("list: ");
        list.traverse();
        list.delete(3);
        System.out.println("list after delete: ");
        list.traverse();
    }
}
