class Queens {

    static void placeQueen(int[][] B, int i, int j){
        int count = 0;
        int n = B.length;
        if( i > (n - 1)){
            if(B[0][1] == 1) {
                printBoard(B);
            }
            B[0][0] = B[0][0] + 1;
        }
        else{
            for( int c = 1; c < n; c++){
                if(B[i][c] == 0){
                    B[i][0] = c;
                    B[i][c] = 1;
                    for(int k = 1; k < n; k++){
                        if((i + k) < n){
                            B[i + k][c] = B[i + k][c] - 1;
                        }
                    } for( int a = 1; a < n; a++){
                        if((i + a) < n && (c + a) < n){
                            B[i + a][c + a] = B[i + a][c + a] - 1;
                        }
                    } for( int a = 1; a < n; a++) {
                        if ((i + a) < n && (c - a) > 0) {
                            B[i + a][c - a] = B[i + a][c - a] - 1;
                        }
                    }
                    placeQueen(B, i + 1, 1);
                    removeQueen(B, i, c);
                }
            }
        }

    }


    static void removeQueen(int[][] B, int i, int j){
        int n = B.length;
        B[i][0] = 0;
        B[i][j] = 0;

        for(int k = 1; k < n; k++){
            if((i + k) < n) {
                B[i + k][j] = B[i + k][j] + 1;
            }
        } for(int c = 1; c < n; c++){
            if((i + c) < n && (j + c) < n){
                B[i + c][j + c] = B[i + c][j + c] + 1;
            }
        } for(int c = 1; c < n; c++) {
            if ((i + c) < n && (j - c) > 0) {
                B[i + c][j - c] = B[i + c][j - c] + 1;
            }
        }
    }

    static void printBoard(int[][] B){
        System.out.print("(");
        for(int j = 1; j < B.length;j++){
            if( j != B.length - 1) {
                System.out.print(B[j][0] + ", ");
            }
            else{
                System.out.println(B[j][0] + ")");
            }
        }
    }

    static int findSolutions(int[][] B, int i, String mode){
        if(mode.compareTo("-v") == 0){
            B[0][1] = 1;
        }
        placeQueen(B, i, 1);
        int n = B[0][0];
        return n;
    }


    public static void main(String[] args){
        if(args.length < 1 /*|| args[0].compareTo("-v") != 0*/){
            System.out.println("Usage: Queens [-v] number\nOption: -v verbose output, print all solutions");
            System.exit(1);
        }
        int n;
        if(args[0].compareTo("-v") == 0 && args.length == 2) {
            try{
                int[][] B = new int[Integer.parseInt(args[1]) + 1][Integer.parseInt(args[1]) + 1];
                n = findSolutions(B, 1, "-v");
                System.out.println(args[1] + "-Queens has " + n + " solutions");
            }catch (NumberFormatException ex) {
                System.out.println("Usage: Queens [-v] number\nOption: -v verbose output, print all solutions");
                System.exit(1);
            }

        }
        else {
            try{
                int[][] B = new int[Integer.parseInt(args[0]) + 1][Integer.parseInt(args[0]) + 1];
                n = findSolutions(B, 1, "");
                System.out.println(args[0] + "-Queens has " + n + " solutions");

            }catch (NumberFormatException ex) {
                System.out.println("Usage: Queens [-v] number\nOption: -v verbose output, print all solutions");
                System.exit(1);
            }
        }


    }



}
