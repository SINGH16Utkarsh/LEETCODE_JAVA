class StockSpanner {
   private Stack<Integer> s;
   private int index;
   private int[] prices; 
    public StockSpanner() {
        s = new Stack<>();
        index = -1;
        prices = new int[10000];
    }
    
    public int next(int price) {
        index++;
        prices[index] =price;

        while(!s.isEmpty() && price >= prices[s.peek()]){
             s.pop();
        }
        int span;
        if (s.isEmpty()) {
            span = index + 1; // all previous days
        } else {
            span = index - s.peek();
        }

        s.push(index);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */