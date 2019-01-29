public class Main {

    static int binarySearch(String arr[], int l, int r, String x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid].compareTo(x) == 0)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid].compareTo(x) > 0)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }


    public static void main(String[] args) {

        int result;
        String[] test = {"10","testing", "new"};
        String target = "10";
        result = binarySearch(test, 0, 3, target);
                if(result != -1) {
                    System.out.println(target + " found on line ");
                }
                else{
                    System.out.println(target + " not found");
                }
    }
}
