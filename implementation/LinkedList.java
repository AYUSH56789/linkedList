public class LinkedList {
    // create a node
    static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // head and tail pointer
    public static Node head;
    public static Node tail;
    public static int size;

    // check ll is empty or not
    boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    // add first -> O(1)
    void addFirst(int data) {
        // step1 : check ll is empty or not
        if (isEmpty()) {
            // step2 : create node and assign to head
            head = new Node(data);
            // step3 : assign that node to tail
            tail = head;
            // step4 : icrement size by 1
            size++;
        } else {
            // step2 : create new node
            Node newNode = new Node(data);
            // step3 : link next of that node to prevous head
            newNode.next = head;
            // step4 : update the head to newNode (first node)
            head = newNode;
            // step4 : icrement size by 1
            size++;
        }
    }

    // add last -> O(1)
    void addLast(int data) {
        // step1 : create new node
        Node newNode = new Node(data);
        // step2 : updat tail.next to newNode
        tail.next = newNode;
        // step3 : update the tail to newNode (last node)
        tail = newNode;
        // step4 : icrement size by 1
        size++;
    }

    // add at any position [ worst case : O(n) & best case : O(1) ]
    void addPos(int data, int pos) {
        // step1: check the validity of pos
        if (pos < 0 || pos > size) {
            System.out.println("Invalid Position");
            return;
        }

        // step2: If pos = 0 then add at first
        if (pos == 0) {
            addFirst(data);
        }
        // step3: If pos = size then add at last
        else if (pos == size) {
            addLast(data);
        }
        // step4: Otherwise, find the node at which we need to insert the new node
        else {
            Node current = head;
            for (int i = 1; i < pos; i++) {
                current = current.next;
            }
            Node newNode = new Node(data);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    // update first : O(1)
    public void updateFirst(int data) {
        // step1 : check is ll is empty or not
        if (isEmpty()) {
            // step2 : return empty statement.
            System.out.println("sorry!, ll is already empty");
        } else {
            // step3 : update data
            head.data = data;
        }
    }

    // update last : O(n)
    public void updateLast(int data) {
        // step1 : check is ll is empty or not
        if (isEmpty()) {
            // step2 : return empty statement.
            System.out.println("sorry!, ll is already empty");
        } else {
            // step3 :
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.data = data;
        }
    }

    // update any node [ worst case : O(n) & best case : O(1) ]
    public void updatePos(int data, int pos) {
        // step1 : check is ll is empty or not
        if (isEmpty()) {
            // step2 : return empty statement.
            System.out.println("sorry!, ll is already empty");
        }
        // step2: when pos=1
        else if (pos == 1) {
            updateFirst(data);
        }
        // step3: when pos=size
        else if (pos == size) {
            updateLast(data);
        }
        // step3: Otherwise, find the node at which we need to insert the new node
        else {
            Node currNode = head;
            for (int i = 1; i < pos; i++) {
                currNode = currNode.next;
            }
            currNode.data = data;
        }
    }

    // delete first -> O(1)
    void deleteFirst() {
        // step1 : check is ll is empty or not
        if (isEmpty()) {
            // step2 : return empty statement.
            System.out.println("sorry!, ll is already empty");
        } else if (size == 1) {
            // step3 : if only one element is there in ll then make head as null and set
            // size as zero.
            head = null;
            tail = null;
            size--;
        } else {
            // step4 : update current head to next head and decrement size by 1
            head = head.next;
            size--;
        }
    }

    // delete last -> O(n)
    void deleteLast() {
        // step1 : check is ll is empty or not
        if (isEmpty()) {
            // step2 : return empty statement.
            System.out.println("sorry!, ll is already empty");
        } else if (size == 1) {
            // step3 : if only one element is there in ll then make head as null and set
            // size as zero.
            head = null;
            tail = null;
            size--;
        } else {
            // step4 : update current head to next head and decrement size by 1
            Node currNode = head;
            Node prev = currNode;
            while (currNode.next != null) {
                prev = currNode;
                currNode = currNode.next;
            }
            prev.next = null;
            tail = prev;
            size--;
        }
    }

    // delete any node [ worst case : O(n) & best case : O(1) ]
    void deletePos(int pos) {
        // step1 : check is ll is empty or not
        if (isEmpty()) {
            // step2 : return empty statement.
            System.out.println("sorry!, ll is already empty");
        }
        // step2 : check if position
        else if (pos == 1) {
            deleteFirst();
        }
        // step3 : check if position is last image
        else if (pos == size) {
            deleteLast();
        }
        // step4 : Otherwise, find the node at which we need to insert the new node
        else {
            Node currNode = head;
            Node prev = currNode;
            for (int i = 1; i < pos; i++) {
                prev = currNode;
                currNode = currNode.next;
            }
            prev.next = currNode.next;
            size--;
        }
    }

    // helper function for recursive search
    int reSearchHelper(int data, Node head, int pos) {
        if (pos > size) {
            return -1;
        } else if (head.data == data) {
            return pos;
        } else {
            return reSearchHelper(data, head.next, pos + 1);
        }

    }

    // recursive search in linked list -> O(N) [ in worst case ]
    int searchRecursive(int data) {
        return reSearchHelper(data, head, 1);
    }

    // search in linked list -> O(N) [ in worst case ]
    int search(int data) {
        int pos = 1;
        Node currNode = head;
        int currSize = size;
        while (currSize > 0) {
            if (currNode.data == data) {
                return pos;
            } else {
                currNode = currNode.next;
                pos++;
            }
            currSize--;
        }
        return -1;
    }

    // reverse linked list -> O(N)
    void reverseLL() {
        // step1: initialize currNode as head node
        Node currNode = head;
        // step2: initialize next node
        Node nextNode;
        // step3: initialize prev node to null
        Node prevNode = null;
        while (currNode != null) {
            // step6 : move currNode one step forwar
            nextNode = currNode.next;
            // step7: upadte
            currNode.next = prevNode;
            // step7 : update prev node to current node
            prevNode = currNode;
            currNode = nextNode;
            // tempSize--;
        }
        head = prevNode;
    }

    // print linked list -> O(N)
    void print() {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // find mid-helper
    Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // check palidrome
    boolean isPalindrome() {
        // step0: when
        if (head == null || head.next == null) {
            return true;
        }
        // step1: find mid
        Node mid = findMid(head);
        // step2: reverse from head to mid
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // Update the head of the second half to the new head
        mid = prev;

        // step3: check both parts are same or not
        Node left = head;
        Node right = mid;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // check cycle or not
    public static boolean hasCycle() {
        // step1: initialize slow and fast with head node
        Node slow=head;
        Node fast=head;
        // step2: move slow and fast until fast!=null && fast.next!=null
        while(fast!=null && fast.next!=null){
            // step3:move slow by one
            slow=slow.next;
            // step4:move fast by two
            fast=fast.next.next;
            // step5:check is fast and slow is point at same node oe not
            if(slow==fast){ 
                return true;
            }
        }
        // else return false
        return false;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(4);
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(0);
        // ll.addPos(10,1);
        // ll.print();
        // ll.deleteFirst();
        // ll.print();
        // ll.deleteLast();
        // ll.print();
        // ll.deletePos(3);
        // ll.print();
        // ll.updatePos(10,3);
        // ll.print();
        // ll.reverseLL();
        // ll.print();
        // System.out.println(ll.search(20)); // -1 if data not found
        // System.out.println(ll.searchRecursive(1)); // -1 if data not found
        // System.out.println(ll.isPalindrome());
        head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        // head.next.next.next.next=head;

        System.out.println(hasCycle());
        // System.out.println(ll.hasCycle());
    }
}

// position of liniked list start from 1 to n ;