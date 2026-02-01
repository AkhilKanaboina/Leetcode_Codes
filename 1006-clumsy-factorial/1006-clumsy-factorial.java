class Solution {
    public int clumsy(int n) {
        Stack<Integer> stack = new Stack<>();
        int i = n;
        boolean first = true;

        while (i > 0) {
            int val = i;
            if (i - 1 > 0) val = val * (i - 1);
            if (i - 2 > 0) val = val / (i - 2);
            if (!first) val = -val;

            stack.push(val);

            if (i - 3 > 0) stack.push(i - 3);

            first = false;
            i -= 4;
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
