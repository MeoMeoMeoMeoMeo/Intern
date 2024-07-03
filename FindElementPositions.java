import java.util.Scanner;

public class FindElementPositions {

    // Hàm tìm kiếm nhị phân để tìm vị trí đầu tiên của phần tử
    public static int findFirstOccurrence(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        int result = -1;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                result = mid;
                r = mid - 1; // Tiếp tục tìm về phía bên trái
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return result;
    }

    // Hàm tìm kiếm nhị phân để tìm vị trí cuối cùng của phần tử
    public static int findLastOccurrence(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        int result = -1;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                result = mid;
                l = mid + 1; // Tiếp tục tìm về phía bên phải
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập mảng
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int m = sc.nextInt();
        int[] arr = new int[m];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        // Nhập số cần tìm
        System.out.println("Nhập số cần tìm: ");
        int x = sc.nextInt();

        // Tìm vị trí đầu tiên và cuối cùng của phần tử
        int first = findFirstOccurrence(arr, x);
        int last = findLastOccurrence(arr, x);

        // In kết quả
        if (first == -1) {
            System.out.println("-1");
        } else {
            System.out.print("[" + first);
            System.out.print("," + last + "]");
        }

        sc.close();
    }
}
