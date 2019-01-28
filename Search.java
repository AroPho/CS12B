import java.io.File;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

class Search {
    
    private static int LC(File test) throws IOException {
        LineNumberReader reader = null;
        try{
            reader = new LineNumberReader(new FileReader(test));
            while ((reader.readLine()) != null);
            return reader.getLineNumber();
        } catch (Exception ex) {
	    System.out.println(ex);
            return -1;
        } finally {
            if(reader != null)
                reader.close();
        }
    }

    private static ArrayList<String> transfer(File test) throws IOException {
        Scanner in = new Scanner(test);
        ArrayList<String> lines = new ArrayList<>();
        try{

        while (in.hasNextLine()){
            lines.add(in.nextLine());
        }
        in.close();
        return lines;
        } catch (Exception ex){
          System.out.println(ex);
          return null;
        }
    }

    static void merge(String[] word, int[] lineNumber, int p, int q, int r){
        int n1 = (q - p) + 1;
        int n2 = (r - q);

        String Ls[] = new String [n1];
        String Rs[] = new String [n2];
        int Li[] = new int[n1];
        int Ri[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int x=0; x<n1; ++x) {
            Ls[x] = word[p + x];
            Li[x] = lineNumber[p + x];
        }
        for (int y=0; y<n2; ++y) {
            Rs[y] = word[q + 1 + y];
            Ri[y] = lineNumber[q + 1 + y];
        }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int x = 0, y = 0;

        // Initial index of merged subarry array
        int k = p;
        while (x < n1 && y < n2)
        {
            if (Ls[x].compareTo(Rs[y]) < 0 || Ls[x].compareTo(Rs[y]) == 0)
            {
                word[k] = Ls[x];
                lineNumber[k] = Li[x];
                x++;
            }
            else
            {
                word[k] = Rs[y];
                lineNumber[k] = Ri[y];
                y++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (x < n1)
        {
            word[k] = Ls[x];
            lineNumber[k] = Li[x];
            x++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (y < n2)
        {
            word[k] = Rs[y];
            lineNumber[k] = Ri[y];
            y++;
            k++;
        }
    }

    static void mergeSort(String[] words, int[] lineNumber, int p, int r) {
        if (p < r) {
            int m = ((p + r)/2);

            mergeSort(words, lineNumber, p, m);
            mergeSort(words, lineNumber, m + 1, r);

            merge(words, lineNumber, p, m, r);
        }
    }
    static int binarySearch(String A[], int p, int r, String t)
    {
        if (r >= p) {
            int mid = p + ((r - p) / 2);


            if (A[mid].compareTo(t) == 0)
                return mid;


            if (A[mid].compareTo(t) > 0)
                return binarySearch(A, p, mid - 1, t);


            return binarySearch(A, mid + 1, r, t);
        }


        return -1;
    }

    public static void main (String [] args) {
        File file = new File(args[0]);
      	try {
            if(args.length < 2){
                System.out.println("Usage: Search file target1 [target2 ..]");
                System.exit(1);
            }
      	    int x = LC(file);
      	    int count = 1;
      	    int numbas[] = new int[x];
      	    for(int s = 0; s < x; s++){
      	        numbas[s] = s + 1;
            }
            String[] words = transfer(file).toArray(new String[x]);
            Search.mergeSort(words, numbas, 0, x - 1);

      	    while(count < args.length) {
      	        int result;
      	        String target = args[count];
                result = binarySearch(words, 0, x-1, target);
                if(result != -1) {
                    System.out.println(target + " found on line " + numbas[result]);
                    count++;
                }
                else{
                    System.out.println(target + " not found");
                    count++;
                }
            }

        }catch(IOException e){
	          System.out.println("fuck");
	      }
    }
}


