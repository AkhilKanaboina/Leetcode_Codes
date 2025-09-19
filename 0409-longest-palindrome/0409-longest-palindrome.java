class Solution {
    public int longestPalindrome(String s) {
        int fre[]=new int[52];
        Arrays.fill(fre,0);
        for(char c:s.toCharArray()){
            if(c>='A'&&c<='Z'){
                fre[c-'A']++;
            }else if(c>='a'&&c<='z'){
                fre[26+(c-'a')]++;
            }
        }
      int ans = 0;
boolean hasOddCenter = false;

for(int freq : fre){
    // Add the even part of the frequency
    ans += (freq / 2) * 2;
    
    // Check if there is a character for the center
    if(freq % 2 == 1){
        hasOddCenter = true;
    }
}

// If we found any character with an odd frequency, we can place one in the center.
if(hasOddCenter){
    ans++;
}

return ans;

    }
}