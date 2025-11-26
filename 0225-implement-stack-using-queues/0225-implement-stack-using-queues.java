class MyStack {
    Deque<Integer> queue=new ArrayDeque<>();
    Deque<Integer> temp=new ArrayDeque<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        temp.offer(x);
        while(!queue.isEmpty()){
            temp.offer(queue.poll());
        }
        Deque<Integer> temp2=queue;
        queue=temp;
        temp=temp2;
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */