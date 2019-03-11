public class Queue implements  QueueInterface{

    private class Node{
        Object job;
        Node next;

        Node(Object j){
            job = j;
            next = null;
        }
    }

    private Node head, tail;
    private int numItems;

    public Queue(){
        head = null;
        tail = null;
        numItems = 0;
    }

    // isEmpty()
    // pre: none
    // post: returns true if this Queue is empty, false otherwise
    public boolean isEmpty() {
        return numItems == 0;
    }
    // length()
    // pre: none
    // post: returns the length of this Queue.
    public int length(){
        return numItems;
    }
    // enqueue()
    // adds newItem to back of this Queue
    // pre: none
    // post: !isEmpty()
    public void enqueue(Object newItem){
        if(numItems == 0){
            Node N = new Node(newItem);
            head = N;
            tail = N;
        }else{
            Node N = new Node(newItem);
            Node P = tail;
            P.next = N;
            tail = P.next;
        }
        numItems++;
    }
    // dequeue()
    // deletes and returns item from front of this Queue
    // pre: !isEmpty()
    // post: this Queue will have one fewer element
    public Object dequeue() throws QueueEmptyException{
        if(isEmpty()){
            throw new QueueEmptyException("cannot dequeue() empty queue");
        }
        else if(head == tail) {
            Node N = head;
            head = null;
            tail = null;
            numItems--;
            return N.job;
        }else{
            Node N = head;
            head = N.next;
            numItems--;
            return N.job;
        }
    }
    // peek()
    // pre: !isEmpty()
    // post: returns item at front of Queue
    public Object peek() throws QueueEmptyException{
        if(isEmpty()){
            throw new QueueEmptyException("cannot dequeue() empty queue");
        }else{
            Node N = head;
            return N.job;
        }
    }
    // dequeueAll()
    // sets this Queue to the empty state
    // pre: !isEmpty()
    // post: isEmpty()
    public void dequeueAll() throws QueueEmptyException{
        if(isEmpty()){
            throw new QueueEmptyException("cannot dequeue() empty queue");
        } else{
            head = null;
            tail = null;
            numItems = 0;
        }
    }
    // toString()
    // overrides Object's toString() method
    public String toString(){
        String result = "";
        Node current = head;
        while(current != null){
            result += current.job;
            if(current.next != null){
                result += " ";
            }
            current = current.next;
        }
        return result;
    }

}
