class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> ans=new ArrayList<>();
        int n=code.length;
        // HashSet<String> set=new HashSet<>();
        // set.add("electronics");
        // set.add("grocery");
        // set.add("pharmacy");
        // set.add("restaurant");
        List<String> electronics=new ArrayList<>();
        List<String> grocery=new ArrayList<>();
        List<String> pharmacy=new ArrayList<>();
        List<String> restaurant=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isValidCoupon(code[i]) && isActive[i]){
                if(businessLine[i].equals("electronics")){
                    electronics.add(code[i]);
                }else if(businessLine[i].equals("grocery")){
                    grocery.add(code[i]);
                }else if(businessLine[i].equals("pharmacy")){
                    pharmacy.add(code[i]);
                }else if(businessLine[i].equals("restaurant")){
                    restaurant.add(code[i]);
                }
            }
        }
        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);
        for(String str: electronics){
            ans.add(str);
        }
        for(String str: grocery){
            ans.add(str);
        }
        for(String str: pharmacy){
            ans.add(str);
        }
        for(String str: restaurant){
            ans.add(str);
        }
        return ans;
    }
    public boolean isValidCoupon(String str){
        return !str.isEmpty() && str.matches("[a-zA-Z0-9_]+");
    }
}