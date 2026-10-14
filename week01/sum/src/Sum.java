public class Sum {
    public static void main(String[] args) {
        System.out.println(sumToN(5));
    }

    static int sumToN(int n) {
        int result = 0;
        for(int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }
}
