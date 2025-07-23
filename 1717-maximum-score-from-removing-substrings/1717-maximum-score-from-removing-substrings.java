class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int score = 0;

        // First remove the higher-value pair
        char firstChar, secondChar;
        int firstVal, secondVal;

        if (x > y) {
            firstChar = 'a'; secondChar = 'b';
            firstVal = x; secondVal = y;
        } else {
            firstChar = 'b'; secondChar = 'a';
            firstVal = y; secondVal = x;
        }

        // Phase 1: Remove higher-value pair
        for (char ch : s.toCharArray()) {
            if (!stack1.isEmpty() && stack1.peek() == firstChar && ch == secondChar) {
                stack1.pop();
                score += firstVal;
            } else {
                stack1.push(ch);
            }
        }

        // Phase 2: Remove lower-value pair from remaining string (in correct order)
        while (!stack1.isEmpty()) {
            char ch = stack1.pop();
            if (!stack2.isEmpty() && ch == secondChar && stack2.peek() == firstChar) {
                stack2.pop();
                score += secondVal;
            } else {
                stack2.push(ch);
            }
        }

        return score;
    }
}
