class Solution {
    public int[] plusOne(int[] digits) {
       boolean counter=true;
       int n=digits.length;
       int i=n-1;
       ArrayList<Integer> list=new ArrayList<>(n);
       while(i>=0){
            int num=digits[i];
            i--;
            if(counter&&num!=9){
                list.add(0,num+1);
                counter=false;
                continue;
            }
            if(num==9&&counter){
                list.add(0,0);
                continue;
            }
            list.add(0,num);
       }
       if(counter){
        list.add(0,1);
       }
       n=list.size();
       int arr[]=new int[n];
       for( i=0;i<n;i++){
            arr[i]=list.get(i);
       }
       return arr;
    }

}