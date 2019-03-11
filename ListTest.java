public class ListTest {
    public static void main(String[] args){
        List<String> A = new List<String>();
        List<Integer> B = new List<Integer>();

        int i, j, k;

        A.add(1, "one");
        A.add(2, "two");
        A.add(3, "three");
        B.add(1, 10);
        B.add(2, 20);
        B.add(3, 30);

        System.out.println("A: "+A);
        System.out.println("B: "+B);
        System.out.println("A.equals(A) is "+A.equals(A));
        System.out.println("A.equals(B) is "+A.equals(B));
        System.out.println("A.size() is "+A.size());
        System.out.println("B.size() is "+B.size());

        A.remove(1);
        B.remove(2);

        System.out.println("A: "+A);
        System.out.println("B: "+B);

        try{
            System.out.println(A.get(200));
        }catch(ListIndexOutOfBoundsException e){
            System.out.println("Caught Exception: ");
            System.out.println(e);
            System.out.println("Continuing without interruption");
        }
        System.out.println();
        System.out.println("A.get(2) is "+A.get(2));
        System.out.println("B.get(1) is "+B.get(1));



    }
}
