class Solution {
   public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort by unitsPerBox in descending order
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        
        int totalUnits = 0;
        
        for (int[] box : boxTypes) {
            int numberOfBoxes = box[0];
            int unitsPerBox = box[1];
            
            // If we can take all boxes of this type
            if (truckSize >= numberOfBoxes) {
                totalUnits += numberOfBoxes * unitsPerBox;
                truckSize -= numberOfBoxes;  // subtract boxes from truck capacity
            } else {
                // Take only the remaining space
                totalUnits += truckSize * unitsPerBox;
                break;  // truck is full
            }
        }
        
        return totalUnits;
    }
}