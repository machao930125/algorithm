package org.chao.str;

public class Code_165_compareVersion {

    public int compareVersion(String version1, String version2){
        int i = 0 , j = 0;
        int n = version1.length(), m = version2.length();

        while (i < n || j < m){
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; i++) {
                x = 10 * x + version1.charAt(i) - '0';
            }
            i ++;

            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; j++) {
                y = 10 * y + version2.charAt(j) - '0';
            }
            j ++;

            if (x != y){
                return x>y ? 1 : -1;
            }
        }
        return 0;
    }
}
