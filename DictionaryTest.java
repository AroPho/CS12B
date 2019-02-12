public class DictionaryTest{
    public static void main(String[] args){
        Dictionary A = new Dictionary();
        Dictionary B = new Dictionary();
        int i, j;

        for(i=1; i<=100; i++){
            j = i*i;
            A.insert(Integer.toString(i), Integer.toString(j));
            B.insert(Integer.toString(i), Integer.toString(((j+i)/2)));
        }

        System.out.println(A);
        System.out.println();
        System.out.println(B);
        System.out.println();
        System.out.println(A.equals(B));
        System.out.println();
        System.out.println(A.size());
        System.out.println();
        System.out.println(B.size());
        System.out.println();

        for(i=1; i<=10; i++){
            A.delete(Integer.toString(9*i));
            B.delete(Integer.toString(8*i-3));
        }

        System.out.println(A.size());
        System.out.println();
        System.out.println(B.size());
        System.out.println();
        System.out.println(B.lookup("37"));
        System.out.println();
        try{
            System.out.println(A.lookup("200"));
        }catch(IndexOutOfBoundsException e){
            System.out.println("Caught Exception " + e);
            System.out.println("Continuing without interruption");
        }
        System.out.println();
        System.out.println(A.lookup("20"));
    }


}
