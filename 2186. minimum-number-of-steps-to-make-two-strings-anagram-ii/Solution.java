class Solution {
    public int minSteps(String s, String t) {
        if (s.length() == 1 && t.length() == 1) {
            // if both letter-strings are different
            // append letter in s to t and vice versa
            return (s.charAt(0) == t.charAt(0)) ? 0 : 2;
        }

        // Space Complexity: O(26)
        int[] letterFrequencyDifference = new int[26];

        int i = 0;
        // Time Complexity: O(max(m, n))
        while (i < s.length() || i < t.length()) {
            if (i < s.length()) {
                letterFrequencyDifference[s.charAt(i) - 'a']++;
            }

            if (i < t.length()) {
                letterFrequencyDifference[t.charAt(i) - 'a']--;
            }

            i++;
        }

        i = 0;
        int steps = 0;

        while (i < 26) {
            // positive number -> letter appear in s more than t
            // negative number -> letter appear in t more than s
            // zero -> letter that appear in both strings equally
            steps += Math.abs(letterFrequencyDifference[i]);
            i++;
        }

        return steps;
    }
}