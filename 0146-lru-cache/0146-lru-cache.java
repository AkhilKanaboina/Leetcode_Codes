class node{
    int key;
    int data;
    node Next;
    node Prev;
    public node(int key,int data){
        this.key=key;
        this.data=data;
        this.Next=null;
        this.Prev=null;
    }
}
class LRUCache {
    HashMap<Integer,node> map=new HashMap<>();
    node head=new node(-1,-1);
    node tail=new node(-2,-2);
    int capacity=0;
    int actualSize=0;
    public LRUCache(int capacity) {
       this.capacity=capacity;
       actualSize=0;
       map.clear();
       head.Next=tail;
       tail.Prev=head;
    }
    
    public int get(int key) {
       if(!map.containsKey(key)){
          return -1;
       }
       node pointer=map.get(key);
       deleteNode(pointer);
       InsertAfterHead(pointer);
       return pointer.data;
    }
    
    public void put(int key, int value) {

     if(!map.containsKey(key) && actualSize<capacity){
        node newNode=new node(key,value);
        InsertAfterHead(newNode);
        actualSize++;
        map.put(key,newNode);
     }else if(!map.containsKey(key)){
        node newNode=tail.Prev;
        deleteNode(newNode);
        InsertAfterHead(newNode);
        map.remove(newNode.key);
        newNode.key=key;
        newNode.data=value;
        map.put(key,newNode);
     }else{
        node newNode =map.get(key);
        deleteNode(newNode);
        InsertAfterHead(newNode);
        newNode.data=value;
     }
    }
    public void deleteNode(node pointer){
        node pre=pointer.Prev;
        node next=pointer.Next;
        pre.Next=next;
        next.Prev=pre;
        pointer.Prev=null;
        pointer.Next=null;
    }
    public void InsertAfterHead(node pointer){
        pointer.Next=head.Next;
        head.Next.Prev=pointer;
        head.Next=pointer;
        pointer.Prev=head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */