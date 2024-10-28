package dsatask2;
public class first_bad_version {
    class versioncontrol{
    static boolean isBadVersion(int version) {
        
        return version >= 4;
    }
    }

public class Solution extends versioncontrol {
    public static int firstBadVersion(int n) {
        if (n == 1) return n;

        int start = 1;
        int end = n;
        int badVersion = 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                badVersion = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return badVersion;
    }

    public static void main(String[] args) {
        int n = 5; // Example input
        int firstBad =firstBadVersion(n);
        System.out.println("The first bad version is: " + firstBad);
    }
}
}


