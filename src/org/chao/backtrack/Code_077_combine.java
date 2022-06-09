package org.chao.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Code_077_combine {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k){
        backtrack(1, n, k);
        return ans;
    }

    public void backtrack(int cur, int n, int k){
        if (temp.size() + (n - cur + 1)< k){
            return;
        }
        if (temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(cur);
        backtrack(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        backtrack(cur + 1, n, k);
    }
}
