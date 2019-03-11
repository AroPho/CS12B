import java.io.*;
import java.util.Scanner;


public class Test {
    public static Job getJob(String in) {
        String[] s = in.split(" ");
        System.out.println(s[0] + s[1]);
        int a = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        return new Job(a, d);
    }

        public static void main(String[] args) throws IOException {
            Scanner in = null;
            PrintWriter out = null;
            String line = null;
            String[] token = null;
            Queue storage = new Queue();
            int lineNumber = 1;
            int numjobs;
            // check number of command line arguments is at least 2
            if (args.length < 1) {
                System.out.println("Usage: Simulation <input file>");
                System.exit(1);
            }
            // open files
            in = new Scanner(new File(args[0]));

            //out = new PrintWriter(new FileWriter(args[1]));
            line = in.nextLine().trim();
            numjobs = Integer.parseInt(line);
            while (in.hasNextLine()) {
                lineNumber++;
                line = in.nextLine().trim();
                System.out.println(line.length());
                if(line.length() == 3) {
                    storage.enqueue(getJob(line));
                }
            }

        System.out.println(storage);
    }
}
