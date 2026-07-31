class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long val=1;
        row.add((int)val);
        for(int i=1;i<=rowIndex ;i++){
           val = val * (rowIndex - i + 1) / i;
            row.add((int) val);
        }
        return row;
    }
    // static int fact(int n){
    //     if(n<=1){
    //         return 1;
    //     }
    //     return n*(fact(n-1));
    }
    