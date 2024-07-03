import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {

    // Hàm chính để gọi đệ quy và lưu trữ kết quả đã tính
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        return wordBreakHelper(s, wordDict, new HashMap<>());
    }

    // Hàm đệ quy với memoization
    private static List<String> wordBreakHelper(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        // Kiểm tra nếu kết quả cho chuỗi này đã được tính toán
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        // Nếu chuỗi là rỗng, trả về danh sách chứa chuỗi rỗng
        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        // Duyệt qua tất cả các từ có thể từ chuỗi con
        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);
            if (wordDict.contains(word)) {
                // Gọi đệ quy cho phần còn lại của chuỗi sau từ hiện tại
                List<String> subList = wordBreakHelper(s.substring(i), wordDict, memo);
                for (String sub : subList) {
                    // Kết hợp từ hiện tại với các phần của chuỗi còn lại
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }

        // Lưu trữ kết quả vào memo để sử dụng lại
        memo.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> wordDict = new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));

        List<String> result = wordBreak(s, wordDict);
        System.out.println(result);
    }
}
