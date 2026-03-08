class Solution {
    public String findDifferentBinaryString(String[] nums) {
        List<String> list=new ArrayList<String>();
        generateAll(list,"",nums[0].length());
        HashSet<String> set=new HashSet<>();
        for(String str:nums){
            set.add(str);
        }
        int n=list.size();
        for(int i=0;i<n;i++){
            if(!set.contains(list.get(i))){
                return list.get(i);
            }
        }
        return "";
    }
    public void generateAll(List<String> list,String str,int n){
        if(n==str.length()){
            list.add(str.toString());
            return;
        }
        generateAll(list,str+"0",n);
        generateAll(list,str+"1",n);
    }
}