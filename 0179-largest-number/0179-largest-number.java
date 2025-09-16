class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> s=new ArrayList<>();
        for(int n:nums){
            s.add(String.valueOf(n));
        }
        s.sort((a,b)->(b+a).compareTo(a+b));
        if(s.get(0).equals("0")){
            return "0";
        }
        return String.join("",s);
    }
}