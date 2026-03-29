class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        char alphbets[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(String s:wordList){
            set.add(s);
        }
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);

        int counter=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String str=queue.poll();
                set.remove(str);
                if(endWord.equals(str)){
                    return counter;
                }
                char c[]=str.toCharArray();
                for(int j=0;j<str.length();j++){
                    char orginal=c[j];
                    for(char alphbet:alphbets){
                        c[j]=alphbet;
                        if(set.contains(new String(c))){
                            queue.add(new String(c));
                            set.remove(new String(c));
                        }
                    }
                    c[j]=orginal;
                }
            }
            counter++;
        }
        return 0;
    }
}