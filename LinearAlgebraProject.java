import java.util.Scanner;
// This class will only check span for Square Matrices
class SquareClass {
    int column, rows;
    public SquareClass(int col, int r) {
        column = col;
        rows = r;
    }
    // For Checking Span
    public static void CheckSpan(double D) {
        if (D == 0.0) {
            System.out.println("Matrix does not span the vector space,because the value of determinant is equal to 0");
        } else {
            System.out.println("Matrix does span the vector space,because the value of determinant is not equal to 0");
        }
    }
    // kindly enter the coefficient Matrix  (row wise)
    // 1  0  1  1
    // 0  0  1  0
    // -1 1  1  0
    // 1  0  0  1
    public void CM(int rows, int columns) {
        Scanner q = new Scanner(System.in);
        double determinant;
        System.out.println("\nPlease Enter the co-efficient Matrix Elements: ");
        double[][] arr = new double[rows][columns];

        for (rows = 0; rows < 4; rows++) {
            System.out.println("Enter the first row of co-efficient Matrix " + (rows + 1) + " :");
            for (columns = 0; columns < 4; columns++) {
                System.out.print("Enter the " + (rows + 1) + " element of " + (columns + 1) + " matrix: " + (columns + 1) + " : ");
                arr[rows][columns] = q.nextDouble();
            }
            System.out.println();
        }
        // code for determinant
        double ax = (arr[2][2] * arr[3][3]) - (arr[2][3] * arr[3][2]);
        double ay = (arr[1][2] * arr[3][3]) - (arr[1][3] * arr[3][2]);
        double az = (arr[1][2] * arr[2][3]) - (arr[1][3] * arr[2][2]);

        double a = (arr[1][1] * ax) - (arr[2][1] * ay) + (arr[3][1] * az);
        double d1 = a * arr[0][0];

        double bx = (arr[2][2] * arr[3][3]) - (arr[2][3] * arr[3][2]);
        double by = (arr[0][2] * arr[3][3]) - (arr[0][3] * arr[3][2]);
        double bz = (arr[0][2] * arr[2][3]) - (arr[0][3] * arr[2][2]);

        double b = (arr[0][1] * bx) - (arr[2][1] * by) + (arr[3][1] * bz);
        double d2 = b * arr[1][0];

        double cx = (arr[1][2] * arr[3][3]) - (arr[2][3] * arr[3][2]);
        double cy = (arr[0][2] * arr[3][3]) - (arr[0][3] * arr[3][2]);
        double cz = (arr[0][2] * arr[1][3]) - (arr[0][3] * arr[1][2]);

        double c = (arr[0][1] * cx) - (arr[1][1] * cy) + (arr[3][1] * cz);
        double d3 = c * arr[2][0];

        double dx = (arr[1][2] * arr[2][3]) - (arr[1][3] * arr[2][2]);
        double dy = (arr[0][2] * arr[2][3]) - (arr[0][3] * arr[2][2]);
        double dz = (arr[0][2] * arr[1][3]) - (arr[0][3] * arr[1][2]);

        double d = (arr[0][1] * dx) - (arr[1][1] * dy) + (arr[2][1] * dz);
        double d4 = d * arr[3][0];

        determinant = d1 + d2 + d3 + d4;
        System.out.println("determinant:" + determinant + "\n");
        System.out.println("The determinant is: " + determinant);
        CheckSpan(determinant);
    }
}
// This class will only check span for Rectangular Matrices
class RectangularClass {
    int column, rows;

    public RectangularClass(int r, int col) {
        column = col;
        rows = r;
    }
    // kindly enter the coefficient Matrix  (row wise)
    // 2  -1   3  4  9
    // 1   0  -2  7  11
    // 3  -3   1  5  8
    // 2   1   4  4 10
    public void gauss_jordan(int rows, int column) {
        Scanner hg = new Scanner(System.in);
        double[][] arr = new double[rows][column];
        for (int a = 0; a < rows; a++) {
            System.out.println("Enter the first row of co-efficient Matrix " + (a + 1) + " :");
            for (int b = 0; b < column; b++) {
                System.out.print("Enter the " + (a + 1) + " element of " + (b + 1) + " matrix: " + (b + 1) + " : ");
                arr[a][b] = hg.nextDouble();
            }
            System.out.println();
        }
        // Reduce Row Echelon
        for (int i = 0, j = 0; i < column && j < rows; i++, j++) {
            double ox = arr[j][i];
            if (ox != 0) {
                for (int cd = 0; cd < column; cd++) {
                    arr[j][cd] = arr[j][cd] / ox;
                }
            }
            for (int T = 0; T < rows; T++) {
                if (T != j) {
                    double G = arr[T][i];
                    for (int W = 0; W < column; W++)
                        arr[T][W] = arr[T][W] - G * arr[j][W];
                }
            }
        }
        System.out.println("Reduce Row Echelon");
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < column; b++) {
                System.out.print(arr[a][b] + "   ");
            }
            System.out.println();
        }
        // checking for span
        double v1 = 0.0, v2 = 0.0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 3) {
                    if (j == column) {
                        v2 = arr[i][j];
                    }
                    if (j == column - 2) {
                        v1 = arr[i][j];

                    }

                }

            }
        }
        if (v1 == 1.0 && (v2 == 0.0 || v2 != 0.0)) {
            System.out.println("System has unique solution ,does span the vector space.");
        } else {
            System.out.println("System is inconsistent ,does not span the vector space.");
        }
    }
}
public class LinearAlgebraProject {
    public static void main(String[] args) {
        Display();
        for (; ; ) {
            Scanner input = new Scanner(System.in);
            System.out.println("How many Matrices do you want to enter: ");
            int no_of_columns = input.nextInt();
            System.out.println("Enter the no. of elements in matrix"); // no. of elements in matrices should always be 4
            int r = input.nextInt();                                  //                OR
            SquareClass RE = new SquareClass(no_of_columns, r);      // Matrix should be in 2*2 order
            // checking for square Matrix
            if (r == 4 && no_of_columns == 4) {
                RE.CM(r, no_of_columns);
            }
            // checking for Rectangular Matrix
            else{
                RectangularClass RC = new RectangularClass(r, no_of_columns);
                RC.gauss_jordan(r, no_of_columns);
            }
            System.out.println("\nDo you wish to continue?");
            System.out.println("Press Y for Yes\nPress N for NO");
            char ans;
            ans = input.next().charAt(0);
            if ((ans == 'Y') || (ans == 'y')) {
                continue;
            } else if ((ans == 'N') || (ans == 'n')) {
                break;
            }
        }
    }
    public static void Display() {
        System.out.println("\t\t\t\t\tSemester project\n\t\t\t\t\tLinear Algebra");
        System.out.println("\t\t\t\t\tK21-3906 Aiman\n\t\t\t\t\tK21-3907 Huda");
        System.out.println("\nIdentify the give set of matrices, span the vector space M m*n");

    }
}

