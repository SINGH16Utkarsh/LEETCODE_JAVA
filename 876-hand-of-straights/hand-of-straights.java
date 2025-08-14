class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for(int cards : hand){
            count.put(cards, count.getOrDefault(cards,0)+1);
        } 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(count.keySet());
        while (!minHeap.isEmpty()) {
            int first = minHeap.peek(); // smallest card
            for (int card = first; card < first + groupSize; card++) {
                if (!count.containsKey(card)) return false;
                count.put(card, count.get(card) - 1);
                if (count.get(card) == 0) {
                    count.remove(card);
                    minHeap.remove(card); // remove from heap directly
                }
            }
        }
        return true;
    }
}