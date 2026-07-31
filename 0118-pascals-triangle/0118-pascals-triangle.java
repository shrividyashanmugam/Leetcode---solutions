import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                // First and last element of each row are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of two numbers directly above
                    int prevRowSum = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(prevRowSum);
                }
            }
            
            triangle.add(row);
        }
        
        return triangle;
    }
}