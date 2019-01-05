public class Fibonacci {
    private static int[] args_add(int[] f1, int[] f2){

        int f3[] = new int[100];
        for (int i = 0; i < 100; i++){
            f3[i] = f1[i] + f2[i];
        }
        return f3;
    }

    private static int[] args_format(int[] args){
        int len = args.length;
        for (int i = 0; i < len; i++){
            if (args[i] >= 1000000 ){
                args[i+1] += args[i] / 1000000;
                args[i] = args[i] % 1000000;
            }
        }
        return args;
    }

    private static void calc(int n){

        int fb[][] = new int [n+1][10000];
        fb[0][0] = 0;
        fb[1][0] = 1;

        for (int i = 2; i <= n; i++){
            fb[i] = args_add(fb[i-1], fb[i-2]);
            args_format(fb[i]);
        }

        int len = 99;
        while (fb[n][len] == 0) len--;
        System.out.print(fb[n][len]);
        for (int i = len - 1; i>=0; i--){
            if ( fb[n][i] > 99999 ){
                System.out.print(fb[n][i]);
            } else if ( fb[n][i] > 9999 ){
                    System.out.print(0);
                    System.out.print(fb[n][i]);
                    } else if ( fb[n][i] > 999 ){
                        System.out.print("00");
                        System.out.print(fb[n][i]);
                            } else if ( fb[n][i] > 99 ){
                            System.out.print("000");
                            System.out.print(fb[n][i]);
                                    } else if ( fb[n][i] > 9 ){
                                            System.out.print("0000");
                                            System.out.print(fb[n][i]);
                                            }else if ( fb[n][i] > 0 ){
                                                System.out.print("00000");
                                                System.out.print(fb[n][i]);
                                                    } else {
                                                        System.out.print("000000");
                                                    }
        }
        System.out.println();
    }
    public static void main(String args[]){
        calc(10);
        calc(20);
        calc(100);
        calc(2048);
    }
}



