class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            // collision possible only if stack top > 0 and asteroid < 0
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek();
                if (top < -asteroid) {
                    // top asteroid is smaller → it explodes
                    stack.pop();
                    continue; // check again with new top
                } else if (top == -asteroid) {
                    // both explode
                    stack.pop();
                }
                destroyed = true; // current asteroid destroyed
                break;
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
        
    }
}