class Solution {
    public static int candy(int[] ratings) {
          int len = ratings.length;
        int[] arr = new int[len];
        // for (int i = 0; i < len; i++) {
        //     arr[i] = 1;
        // }

        for (int i = 0; i < len - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                arr[i + 1] = arr[i] + 1;
            }
        }

        for (int i = len - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1] && arr[i] >= arr[i - 1]) {
                arr[i - 1] = arr[i] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i] +1;
        }

        return sum;
    }
    static{
        int[] arr={1,1};
        for (int i = 0; i < 100; i++) {
            candy(arr);
        }
    }
}