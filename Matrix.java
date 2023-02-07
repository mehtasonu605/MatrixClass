import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        int n1,m1;
        int n2, m2;
        int operation;
        Scanner scanner = new Scanner(System.in);
        operation = scanner.nextInt();

        n1 = scanner.nextInt();
        m1 = scanner.nextInt();

        int [][]A = new int[n1][m1];
        for (int i = 0; i<n1; i++)
            for (int j = 0; j < m1; j++) {
                A[i][j] = scanner.nextInt();
            }

        n2 = scanner.nextInt();
        m2 = scanner.nextInt();

        int [][]B = new int[n1][m1];
        for (int i = 0; i<n2; i++)
            for (int j = 0; j < m2; j++) {
                B[i][j] = scanner.nextInt();
            }
        if (operation == 1){
            add(A,B, n1,m1);
        } else if (operation == 2) {
            multiply(A,B,n1,m1);
        }
        else if (operation == 3){
            transpose(A,n1,m1);
            transpose(B, n2,m2);

        }
        else {
            rotateMatrix(n1,A);
            rotateMatrix(n2,A);
        }
    }

    //function to two matrix
    static void add(int A[][], int B[][],
                       int n1, int m1)
    {
        int i, j;
        int C[][] = new int[n1][m1];

        for (i = 0; i < n1; i++)
            for (j = 0; j < m1; j++)
                C[i][j] = A[i][j] + B[i][j];

        printArray(C,n1,m1);
    }

    //Function to multiply two matrix
    static void multiply(int A[][], int B[][], int n1, int m1){

        int i, j,k;
        int C[][] = new int[n1][m1];
        for (i = 0; i < n1; i++) {
            for (j = 0; j < m1; j++) {
                for (k = 0; k < n1; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }
        printArray(C,n1,m1);
    }

    //Function to transpose of Array
    static void transpose(int A[][], int n1, int m1)
    {
        int i, j;
        int C[][] = new int[n1][m1];
        for (i = 0; i < n1; i++)
            for (j = 0; j <m1; j++)
                C[i][j] = A[j][i];

        printArray(C, n1, m1);
    }

    //Function to rotate by 90 degree
    static void rotateMatrix(int n, int matrix[][]){
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]= temp;
            }
        }
        for(int i=0;i<n;i++){
            int top=0;
            int bottom = n-1;
            while(top<bottom){
                int temp = matrix[top][i];
                matrix[top][i]=matrix[bottom][i];
                matrix[bottom][i] = temp;
                top++;
                bottom--;
            }
        }
        printArray(matrix,n,n);
    }





    //Function to print array
    static void printArray(int A[][], int n1, int n2){
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

}
