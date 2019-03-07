import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicBoolean;

public class Simulation {

    public static Job getJob(String in) {
        String[] s = in.split(" ");
        int a = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        return new Job(a, d);
    }
    //return number of jobs arriving at current time
    public static void getAJob(Queue s, Queue[] p, int nj, int t, int np, AtomicBoolean event){
        int count = 0;
        for(int c = 0; c < nj;c++){
            if(!s.isEmpty()) {
                Job j = (Job) s.peek();
                if (j.getArrival() == t) {
                    j = (Job) s.dequeue();
                    insertJob(p, j, np, t );
                    event.set(true);
                } else if (j.getArrival() > t) {
                    break;
                }
            }else{
                break;
            }
        }
    }
    public static int proccheck(Queue s, Queue[] p, int t, int np ){
        /*for(int i = 0; i < np; i++){
            Job j = (Job) p[np].peek();
            if(j != null && j.getFinish() == t){
                Queue.
            }
        }*/
        return 1;
    }

    public static Job getProcess(Queue[] p, int[] wait, int t, int c, AtomicBoolean event){
        if(p[c]!=null && !p[c].isEmpty()){
            Job j = (Job) p[c].peek();
            if(j.getFinish() == t){
                wait[0] = wait[0] + j.getWaitTime();
                if(wait[1] < j.getWaitTime()){
                    wait[1] = j.getWaitTime();
                }
                //wait[np][2]++;
                j = (Job) p[c].dequeue();
                if(!p[c].isEmpty()) {
                    ((Job) p[c].peek()).computeFinishTime(t);
                    event.set(true);
                    return j;
                }else{
                    event.set(true);
                    return j;
                }
            }
        }
        return null;
    }
    public static void insertJob(Queue[] p, Job j, int np, int t){
        int sproc = 0; // processor with smallest queue
        int smallest; // temp variable with length of current smallest queue
        if(p[0] == null){
            p[0] = new Queue();
            smallest = p[0].length();
        }else{
            smallest = p[0].length();
        }
        for (int c = 1; c < np; c++) {
            if(p[c] == null) {
                p[c] = new Queue();
                smallest = p[c].length();
            }
            if (p[c].length() < smallest) {
                    smallest = p[c].length();
                    sproc = c;
            }
        }
        if(p[sproc].isEmpty())
        {
            j.computeFinishTime(t);
        }
        p[sproc].enqueue(j);
    }
    public static void resetQueue(Queue s , Job[] b, int nj){
        s.dequeueAll();

        for(int c = 0; c < nj;c++){
            Job j = b[c];
            j.resetFinishTime();
            //System.out.println(b[c]);
            s.enqueue(j);
        }
    }

    public static String getWait(int[] wait,int np, int nj){
        int total, max;
        double average;
        DecimalFormat numberFormat = new DecimalFormat("#0.00");
        if(np == 1){
            total = wait[0];
            max = wait[1];
            average = (double) wait[0]/nj;
            return ("1 processor: totalWait=" + total +  ", maxWait="
            + max + ", averageWait=" + numberFormat.format(average));
        }
        total = wait[0];
        max = wait[1];
        average = (double) wait[0]/nj;
        return (np + " processors: totalWait=" + total +  ", maxWait="
                + max + ", averageWait=" + numberFormat.format(average));
    }


    public static void main(String[] args) throws IOException {
        Scanner in = null;
        PrintWriter rpt = new PrintWriter(new FileWriter(args[0]+".rpt"));
        PrintWriter trc = new PrintWriter(new FileWriter(args[0]+".trc"));
        String line = null;
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
        line = in.nextLine().trim();
        numjobs = Integer.parseInt(line);
        Job[] backup = new Job[numjobs];
        int count = 0;
        while (in.hasNextLine()) {
            lineNumber++;
            line = in.nextLine().trim();
            System.out.println(line);
            if(line.length() >= 3 ){
                Job j = getJob(line);
                //System.out.println("1");
                storage.enqueue(j);
                backup[count] = j;
                count++;
            }
        }
        //System.out.println(storage);
        rpt.println("Report file: " + args[0] + ".rpt");
        rpt.println(numjobs + " Jobs:");
        rpt.println(storage + "\n");
        rpt.println("***********************************************************");
        trc.println("Trace file: " + args[0] + ".trc");
        trc.println(numjobs + " Jobs:");
        trc.println(storage + "\n");

        for(int i = 1; i < numjobs; i++){
            Queue[] processers = new Queue[i];
            int[] processwait = new int[2];
            processwait[0] = 0;
            int pjobs = 0, time = 0;
            AtomicBoolean event = new AtomicBoolean(false);

            double totalwait, maxwait, averagewait;
            while(pjobs < numjobs){
                //getAJob(storage, processers, numjobs, time, i, event);
                for(int c = 0; c < i;c++){
                    Job A = getProcess(processers, processwait, time, c, event);
                    if(A != null){
                        storage.enqueue(A);
                        pjobs++;
                    }
                }
                getAJob(storage, processers, numjobs, time, i, event);
                if(event.get() || time == 0) {
                    if(time == 0){
                        trc.println("*****************************");
                        if(i == 1){
                            trc.println("1 processor:");
                        }else{
                            trc.println(i + " processors:");
                        }
                        trc.println("*****************************");

                    }
                    trc.println("time=" + time);
                    //System.out.println("time=" + time);
                    trc.println("0: " + storage);
                    for (int c = 0; c < i; c++) {
                        if(processers[c] == null){
                            trc.println((c+1) + ": ");
                            //System.out.println((c+1) + " :");
                        }else {
                            trc.println((c+1) + ": " + processers[c]);
                            //System.out.println((c+1) + " :" + processers[c]);
                        }
                    }
                    event.set(false);
                }
                time++;
            }
            rpt.println(getWait(processwait, i, numjobs));
            resetQueue(storage, backup, numjobs);
        }
        rpt.close();
        trc.close();
        in.close();
    }

}

/*public static double totalWait(Queue s, int n){
        int tw = 0;
        Queue temp = s;
        for(int c = 0; c < n;c++){
            Job A = (Job) temp.dequeue();
            tw = tw + A.getWaitTime();
        }
        return tw;
    }
    public static int maxWait(Queue s, int nj){
        Queue temp = s;
        Job A = (Job) temp.dequeue();
        int longest = A.getWaitTime(); // temp variable with longest wait time

        for(int c = 1; c < nj;c++){
            A = (Job) temp.dequeue();
            int time = A.getWaitTime();
            if(time > longest){
                longest = time;
            }
        }
        return longest;
    }*/
