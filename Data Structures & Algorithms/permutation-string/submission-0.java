class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;
        
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        
        for (int i = 0; i < n; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }
        
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == windowCount[i]) matches++;
        }
        
        if (matches == 26) return true;
        
        for (int i = n; i < m; i++) {
            int addChar = s2.charAt(i) - 'a';
            int removeChar = s2.charAt(i - n) - 'a';
            
            // Add new character
            windowCount[addChar]++;
            if (windowCount[addChar] == s1Count[addChar]) {
                matches++;
            } else if (windowCount[addChar] == s1Count[addChar] + 1) {
                matches--;
            }
            
            // Remove old character
            windowCount[removeChar]--;
            if (windowCount[removeChar] == s1Count[removeChar]) {
                matches++;
            } else if (windowCount[removeChar] == s1Count[removeChar] - 1) {
                matches--;
            }
            
            if (matches == 26) return true;
        }
        
        return false;
    }
}