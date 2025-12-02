class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack=new Stack<>();        
    }
    
    public int next(int price) {
        int ans=1;
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            int temp[]=stack.pop();
            ans+=temp[1];
        }
        stack.push(new int[]{price,ans});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */