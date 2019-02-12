import java.lang.String;
import java.lang.IndexOutOfBoundsException;

public class Dictionary implements DictionaryInterface {

    private class Node{
        String item;
        Node next;

        Node(String x){
            item = x;
            next = null;
        }
    }

    private Node head;
    private int numItems;

    public Dictionary(){
        head = null;
        numItems = 0;
    }

    private Node findKey(String key){
        Node N = head;
        Node P = N;
        for(int i = 1; i < numItems; i++){
            if(N.item.substring(0, N.item.indexOf(" ")).compareTo(key) == 0) {
                return N;
            }else if(Integer.parseInt(N.item.substring(0, N.item.indexOf(" "))) > Integer.parseInt(key)){

                return P;
            }
            P = N;
            N = N.next;
        }
        return N;
    }

    public boolean isEmpty(){
        return (numItems == 0);
    }
    public int size(){
        return numItems;
    }
    public String lookup(String key) throws IndexOutOfBoundsException{
        int index = Integer.parseInt(key);
        if( index<1 || index>numItems ){
            /*throw new IndexOutOfBoundsException(
                    "IntegerList Error: lookup() called on invalid index: " + index);*/
            return null;
        }
        Node N = findKey(key);
        if(N.item.substring(0, N.item.indexOf(" ")).compareTo(key)== 0){
            return N.item.substring(N.item.indexOf(" ") + 1);
        }
        return null;
    }
    public void insert(String key, String value)throws IndexOutOfBoundsException{
        int index = Integer.parseInt(key);
        if(numItems==0) {
            Node N = new Node(key + " " + value + "\n");
            N.next = head;
            head = N;
        }else if(index == 1){
            Node N = new Node(key + " " + value + "\n");
            N.next = head;
            head = N;
        }
        else{
            Node P = findKey(Integer.toString(index - 1));
            Node C = P.next;
            P.next = new Node(key + " " + value + "\n");
            P = P.next;
            P.next = C;
        }
        numItems++;
    }
    public void delete(String key) throws IndexOutOfBoundsException{
        int index = Integer.parseInt(key);
        /*if( index<1 || index>numItems ){
            throw new IndexOutOfBoundsException(
                    "IntegerList Error: remove() called on invalid index: " + index);
        }*/
        if(index==1){
            Node N = head;
            head = head.next;
            N.next = null;
        }else{
            Node P = findKey(Integer.toString(index - 1));
            Node N = P.next;
            P.next = N.next;
            N.next = null;
        }
        numItems--;
    }
    public void makeEmpty(){
        head = null;
        numItems = 0;
    }
    private String myString(Node H){
        if( H==null ){
            return "";
        }else{
            return (H.item + " " + myString(H.next));
        }
    }

    public String toString(){
        return myString(head);
    }
    public static void main(String[] args){
        Dictionary A = new Dictionary();
        A.insert("3","a");
        A.insert("5","a");
        A.insert("6","a");
        A.insert("1","a");
        //System.out.println(A);
        A.insert("4", "b");
        A.insert("2","b");
        //System.out.println(A);
        A.delete("6");
        System.out.println(A);
    }
}
