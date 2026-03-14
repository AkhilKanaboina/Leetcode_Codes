class Solution {
    List<String> list;
    public String getHappyString(int n, int k) {
        list=new ArrayList<>();
        char c[]={'a','b','c'};
        recursion(n,k,0,"",c);
        if(list.size()<k) return "";
        Collections.sort(list);
        return list.get(k-1);
    }
    public void recursion(int n,int k,int len,String s,char c[]){
        if(len>n)return;
        if(len==n){
           list.add(s);
            return ;
        }
        for(int i=0;i<c.length;i++){
            if(len>0 && s.charAt(len-1)!=c[i]){
                recursion(n,k,len+1,s+c[i],c);
            }
            if(len==0){
                recursion(n,k,len+1,s+c[i],c);
            }
        }
    }
}