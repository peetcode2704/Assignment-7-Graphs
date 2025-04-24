import java.util.Scanner;

public class GraphDirectionCheck {
    public static boolean isDirected(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the matrix ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];
        System.out.println("Enter" + n + "x" + n + " adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        if (isDirected(matrix)) {
            System.out.println("The matrix is a directed graph.");
        } else {
            System.out.println("The matrix is an undirected graph.");
        }
        scanner.close();
    }
}