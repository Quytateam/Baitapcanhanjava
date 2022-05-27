import java.util.Arrays;

public class TwoDotNineEX {

    // Xuất mảng
    static void output2DArry(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    // Có bao nhiêu phần tử nằm trên 2 đường chéo là ký tự chữ và viết hoa
    static int sumOfUppercaseCharacter(char[][] arr) {
        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == j || i + j == n - 1) {
                    if (arr[i][j] >= 'A' && arr[i][j] <= 'Z') {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    // Chuyển tất cả các ký tự chữ viết thường ở 2 đường chéo sang ký tự viết hoa
    static void convertToUppercase(char[][] arr) {
        int n = arr.length;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == j || i + j == n - 1) {
                    if (arr[i][j] >= 'a' && arr[i][j] <= 'z') {
                        arr[i][j] -= 32;
                    }
                }
            }
        }
        System.out.println("Mảng đã chuyển đổi:");
        output2DArry(arr);
    }

    // Tìm ký tự chữ viết hoa xuất hiện nhiều nhất trong mảng
    static void findTheMostAppearingCharacter(char[] arr) {
        int max = 0;
        int point = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    if (count > max) {
                        max = count;
                        point = i;
                    }
                }
            }
        }
        System.out.println("Ký tự" + arr[point] + " xuất hiện nhiều nhất trong mảng với số lần " + max);
    }

    // Sao chép mảng
    static int getTheUppercaseCharacter(char[][] arr, char[] arr2) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] >= 'A' && arr[i][j] <= 'Z') {
                    arr2[k] = arr[i][j];
                    k++;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        char[][] arr = { { 'L', '2', 's', 'U' }, { '3', '4', 'Q', 'O' }, { 'i', 'Q', 'L', '7' },
                { 'k', 'L', '9', 'L' } };
        char[] arr2 = new char[10];

        int sum = sumOfUppercaseCharacter(arr);
        System.out.println("Có " + sum + " phần tử nằm trên 2 đường chéo là ký tự chữ và viết hoa");

        convertToUppercase(arr);

        getTheUppercaseCharacter(arr, arr2);
        System.out.println(Arrays.toString(arr2));

        findTheMostAppearingCharacter(arr2);

    }
}
