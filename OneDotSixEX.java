import java.util.Arrays;

public class OneDotSixEX {

    // Hàm đếm số ký tự chữ viết thường trong mảng
    static int sumOfLowercaseCharacters(char[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                sum++;
            }
        }
        return sum;
    }

    // Kiểm tra xem mảng ký tự trên có chứa 1 ký tự chữ cho trước hay không (không
    // phân biệt viết hoa hay thường)
    static int characterChange(char arr) {
        if (arr >= 'a' && arr <= 'z') {
            arr += 32;
        }
        return 0;
    }

    static void checkArry(char[] arr, char arr2) {
        for (int i = 0; i < arr.length; i++) {
            if (characterChange(arr[i]) == characterChange(arr2)) {
                System.out.println("mảng ký tự trên có chứa 1 ký tự chữ cho trước");
                break;
            } else {
                System.out.println("mảng ký tự trên không có chứa 1 ký tự chữ cho trước");
            }
        }
    }

    // Lấy ra tất cả các ký tự viết hoa trong mảng (kiểu trả về là mảng)
    static int getTheUppercaseCharacter(char[] arr, char[] arr2) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr2[n] = arr[i];
                n++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 0;
        char[] arr = { '1', 'L', 's', '7', 't', 'Y', 'k' };
        char arr1 = 'L';
        char[] arr2 = new char[arr.length];
        int sum = sumOfLowercaseCharacters(arr);
        System.out.println("Tổng số ký tự chữ viết thường trong mảng: " + sum);

        checkArry(arr, arr1);

        System.out.println("Mảng các ký tự viết hoa");

        getTheUppercaseCharacter(arr, arr2);

        System.out.println(Arrays.toString(arr2));
    }
}
