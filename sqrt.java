package dsatask2;
public class sqrt {
    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        long left = 0;
        long right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }

    public static void main(String[] args) {
        int x = 16; 
        System.out.println( mySqrt(x));
        x = 4;
        System.out.println(mySqrt(x));
    }
    
}
