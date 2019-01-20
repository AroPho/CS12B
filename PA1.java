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

    private void Merge(String[] words, int[] lineNumber, int l, int r, int m){
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        String Ls[] = new String [n1];
        String Rs[] = new String [n2];
        int Li[] = new int[n1];
        int Ri[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) {
            Ls[i] = words[l + i];
            Li[i] = lineNumber[l + i];
        }
        for (int j=0; j<n2; ++j) {
            Rs[j] = words[m + 1 + j];
            Ri[j] = lineNumber[m + 1 + j];
        }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (Ls[i].compareTo(Rs[j]) < 0)
            {
                words[k] = Ls[i];
                lineNumber[k] = Li[i];
                i++;
            }
            else
            {
                words[k] = Rs[j];
                lineNumber[k] = Ri[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            words[k] = Ls[i];
            lineNumber[k] = Li[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            words[k] = Rs[j];
            lineNumber[k] = Ri[j];
            j++;
            k++;
        }
    }

    private void Sort(String[] words, int[] lineNumber, int l, int r) {
        if (l < r) {
            int m = (l + r)/2;

            Sort(words, lineNumber, l, m);
            Sort(words, lineNumber, m + 1, r);

            Merge(words, lineNumber, l, r, m);
        }
    }

    public static void main (String [] args) {
        File file = new File("C:/Users/aaron/Desktop/text.txt");
      	try {
      	    int x = LC(file);
      	    int numbas[] = new int[x];
      	    for(int s = 0; s < x; s++){
      	        numbas[s] = s + 1;
            }
            String[] words = transfer(file).toArray(new String[x]);
            /*for(int c = 0; c <= x - 1 ; c++){
                System.out.println(words[c]);
            }*/
            Search sorting = new Search();
            sorting.Sort(words, numbas, 0, x - 1);
            for(int c = 0; c <= x - 1 ; c++){
                System.out.print(words[c] + " ");
                System.out.println(numbas[c]);
            }

        }catch(IOException e){
	          System.out.println("fuck");
	      }
    }
}


