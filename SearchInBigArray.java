/**
 * Definition of ArrayReader:
 *
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        if (reader.get(0) > target){
            return -1;
        } else if (reader.get(0) == target){
            return 0;
        }

        int i = 1;
        while ( reader.get(i) < target){
            i = 2 * i;
        }
        int flag = 1;
        int start = 1;
        int end = i;
        while (start  < end){
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target){
                end =  mid;
            } else if(reader.get(mid) > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (reader.get(start) == target){
            return start;
        }
        return -1;
    }
}