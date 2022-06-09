package org.chao.str;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 最小覆盖子串
 */
public class Code_076_minWindow {
    Map<Character, Integer> smap = new HashMap<>();
    Map<Character, Integer> tmap = new HashMap<>();
    public String minWindow(String s, String t){
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int ansL = -1;
        int length = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            if (tmap.containsKey(s.charAt(r))){
                smap.put(s.charAt(r), smap.getOrDefault(s.charAt(r), 0) + 1);
            }

            while (check() && l <= r){
                if (r - l + 1 < length){
                    length = r - l + 1;
                    ansL = l;
                }

                if (smap.containsKey(s.charAt(l))){
                   smap.put(s.charAt(l), smap.getOrDefault(s.charAt(l), 0) - 1);
                }
                l ++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(ansL, ansL + length);
    }

    public boolean check(){
        Iterator iter = tmap.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Character key =(Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (smap.getOrDefault(key, 0) < value){
                return false;
            }
        }
        return true;
    }

}
