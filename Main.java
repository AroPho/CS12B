public class Main{

    public static int getValue(int a, int b, int n){
        int x, c;
        System.out.println("arrive: a = " + a + " b = " + b);
        c = (a+b)/2;
        if( c*c <= n ){
            x = c;
        }else{
            x = getValue(a, c-1, n);
        }
        System.out.println("depart: a = " + a + " b = " + b);
        return x;
    }
    static String displayOctal(int n, int b){
        String test = new String();
        if(n>0){
            if(n/b>0){
                test = displayOctal(n/b, b);
            }
            return test = test +  digit(n%b, b);
        }
        return null;
    }
    static String digit(int n , int b){
        if(n < 10){
            return String.valueOf(n);
        }
        else{
            return String.valueOf((char)((n-9) + 64));
        }
    }

    public static void main(String[] args){
        System.out.println(displayOctal(1000000000, 16));
    }
}