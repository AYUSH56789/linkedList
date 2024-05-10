import java.util.LinkedList;
public class BasicLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> ll=new LinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.add(3,0);
        System.out.println(ll);
        ll.remove(4);
        System.out.println(ll.get(3));
        System.out.println(ll);
    }
}
