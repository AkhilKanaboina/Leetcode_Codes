class Solution {
    public int characterReplacement(String s, int k) {
        int hash[]=new int[26];
        Arrays.fill(hash,0);
        int left=0;
        int n=s.length();
        int counter=0;
        int max=0,sum=0,lessFreq=0;
        for(int i=0;i<n;i++){
            int index=s.charAt(i)-'A';
            hash[index]+=1;
            max=0;
            sum=0;
            for(int ii=0;ii<26;ii++){
                if(hash[ii]>max){
                    max=hash[ii];
                }
                sum+=hash[ii];
            }
            lessFreq=sum-max;
            if(lessFreq>k){
                if(hash[s.charAt(left)-'A']!=max){
                    lessFreq--;
                }
                hash[s.charAt(left)-'A']-=1;
                left++;
            }
        }
        return n-left;
    }
}