import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntersectionArrays {

    // Hàm tìm kiếm nhị phân- tìm được hay không
    public static boolean binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l+r) / 2;
            if (arr[mid] == x) {
                return true;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    // Hàm tìm giao của hai mảng đã được sắp xếp
    public static List<Integer> intersectionSortedArrays(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) { 
        int num = arr1[i]; 
            if (binarySearch(arr2, num)) {
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập mảng 1
        System.out.println("1st array:");
        int m = sc.nextInt();
        int[] arr1 = new int[m];
               for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }

        // Nhập mảng 22
        System.out.println("2nd array");
        int n = sc.nextInt();
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        // Tìm giao của hai mảng
        List<Integer> intersection = intersectionSortedArrays(arr1, arr2);
        
        // In kết quả
        if (intersection.isEmpty()) {
            System.out.println("2 mảng không có phần tử chung");
        } else {
            System.out.println("Giao của hai mảng là: " + intersection);
        }
        
        sc.close();
    }
}
   