class Solution {
    public String reverseWords(String s) {
     StringBuffer str=new StringBuffer("");
     ArrayList<String> list=new ArrayList<>();
     int n=s.length();
     int j=n;
     int i=n-1;
     for(i=n-1;i>=0;i--){
        if(s.charAt(i)==' '){
          //  str.append(s.substring(i+1,j));
            if(i+1<j)
            list.add(s.substring(i+1,j));
            j=i;
        }
     }

    //str.append(s.substring(i,j));
    int val=0;
    if(0<j)
    list.add(s.substring(0,j));
    for(String temp:list){
        str.append(temp);
        if(((val+1)!=list.size()))
        str.append(" ");
        val++;
    }
    return str.toString();
    }
}