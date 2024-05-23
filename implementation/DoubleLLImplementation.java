public class DoubleLLImplementation {
    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    Node head;
    int size;
    // isEmpty
    boolean isEmpty(){
        if(head==null){
            return true;
        }
        else{
            return false;
        }
    }
    // addFirst
    void addFirst(int x){
        Node newNode = new Node(x);
        if(isEmpty()){
            head=newNode;
            size++;
        }
        else{
            // update newNode.next -> head
            newNode.next = head;
            // update head.prev -> newNode
            head.prev=newNode;
            // update head -> newNode
            head=newNode;
            // increment the size by one
            size++;
        }
    }
    // add last
    // step1: check dll is empty or not
    void addLast(int data){
        if(isEmpty()){
            addFirst(data);
        }
        else{
            Node currNode=head;
            while(currNode.next!=null){
                currNode=currNode.next;
            }
            Node newNode=new Node(data);
            currNode.next=newNode;
            newNode.prev=currNode;
        }
    }
    // remove first
    void removeFirst(){
        if (isEmpty()) {
            System.out.println("dll is empty");
        }else{
            Node currNode=head;
            head=currNode.next;
            head.prev=null;
        }
    }

    // remove last
    void removeLast(){
        if (isEmpty()) {
            System.out.println("dll is empty");
        }else{
            Node currNode=head;
            while(currNode.next.next!=null){
                currNode=currNode.next;
            }
            currNode.next=null;
        }
    }

    // reverse DLL
    void reverseDll(){
       if(isEmpty()){
            System.out.println("DLL is empty");
        }
        else{
            Node currNode=head;
            Node tempNode=null;
            while (currNode!=null) {
                tempNode=currNode.prev;
                currNode.prev=currNode.next;
                currNode.next=tempNode;
                currNode=currNode.prev;
            }
            if (tempNode!=null) {
                head=tempNode.prev;
            }
        }
    }
    // print DLL
    void printDLL(){
        if (!isEmpty()) {
            Node currNode=head;
            while(currNode!=null){
                System.out.print(currNode.data+"->");
                currNode=currNode.next;
            }
            System.out.print("null");
        } else {
            System.out.println("dll is empty");
        }
    }

    void printHelper(Node currNode){
        if(currNode==null){
            return;
        }
        printHelper(currNode.next);
        System.out.print(currNode.data+"->");
    }
    void printReverseDLL(){
        if (!isEmpty()) {
            System.out.println();
            Node currNode=head;
            printHelper(currNode);
            System.out.print("null");
        } else {
            System.out.println("dll is empty");
        }
    }
    public static void main(String[] args) {
        DoubleLLImplementation dll = new DoubleLLImplementation();
        int arr[]={1,2,3,4,5,6,7};
        for (int i=arr.length-1;i>=0;i--) {
            dll.addFirst(arr[i]);
        }
        dll.addFirst(11);
        dll.addFirst(22);
        dll.addLast(33);
        dll.addLast(44);
        dll.addLast(55);
        // dll.reverseDll();
        dll.printDLL();
        dll.removeFirst();
        dll.printDLL();
        dll.removeLast();
        dll.printDLL();
        // dll.printReverseDLL();
    }
}
