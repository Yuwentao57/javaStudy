package algo;

import java.util.ArrayList;
import java.util.List;

public class LC816 {
}

class Solution816 {
    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 2) return ans;
        int len = s.length();
        for (int i = 2; i < len - 1; i++) {
            String part = s.substring(1, i);
            List<String> up = enumSubString(part);
            part = s.substring(i, s.length() - 1);
            List<String> down = enumSubString(part);
            if (up.size() == 0 || down.size() == 0){
                continue;
            }
            for (String l : up) {
                for (String r : down) {
                    ans.add('(' + l + ',' + ' ' + r + ')');
                }
            }
        }
        return ans;
    }

    private List<String> enumSubString(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() == 1) {
            ans.add(s);
            return ans;
        }
        StringBuilder sbd = new StringBuilder();
        String t = null;
        if (s.charAt(0) == '0') {
            sbd.append('0').append('.').append(s.substring(1));
            t = sbd.toString();
            if (t.charAt(t.length() - 1) != '0') ans.add(t);
            return ans;
        }
        ans.add(s);
        for (int i = 1; i < s.length(); i++) {
            sbd.append(s.substring(0, i)).append('.').append(s.substring(i));
            t = sbd.toString();
            if (t.charAt(t.length() - 1) != '0') ans.add(t);
            sbd.setLength(0);
        }
        return ans;
    }
}
