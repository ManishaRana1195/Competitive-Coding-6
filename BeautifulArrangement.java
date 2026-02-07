// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach :
// We need to find all permutations for n values. We can check if value satisfies the condition the value/position or position/value
// in the permutation, continue to check next values else skip that permutation. Once we are done evaluating all positions in a permutation,
// we add it to the final count.

// Now to create permutation, there are two methods.
// One can keep iterating through 1 to n in each recursion call. That can lead to duplicate values in the permutation, so we can
// keep boolean array to check if the value is already added in the permutation. If it is, continue recursion with the next value.

// To avoid
public class BeautifulArrangement {
    int count = 0;

    public int countArrangement(int n) {
        boolean[] isAlreadyAdded = new boolean[n + 1];
        findPermutation(n, 1, isAlreadyAdded);

        int[] tempArr = new int[n + 1];
        for (int i = 1; i < tempArr.length; i++) {
            tempArr[i] = i;
        }

        // Improving memory usage by avoid keeping isAlreadyAdded Array.
        count = 0;
        findPermutation(tempArr, 1);
        return count;
    }

    // Time Complexity : O(N!)
    // Space Complexity : O(N) - recursion stack + O(N) - boolean array
    private void findPermutation(int n, int position, boolean[] isAlreadyAdded) {
        // if the permutation has all n values, break and increase count
        if (position > n) {
            count++;
            return;
        }

        for (int curr = 1; curr <= n; curr++) {
            if (isAlreadyAdded[curr]) continue;
            // Skip the permutation if the current value doesnt satisfy the following condition
            if (position % curr == 0 || curr % position == 0) {
                isAlreadyAdded[curr] = true;
                findPermutation(n, position + 1, isAlreadyAdded);
                isAlreadyAdded[curr] = false;
            }
        }
    }

    // Time Complexity : O(N!)
    // Space Complexity : O(N) - recursion stack
    private void findPermutation(int[] arr, int position) {
        if (arr.length < position) {
            count++;
            return;
        }

        for (int i = position; i < arr.length; i++) {
            if (arr[i] % position == 0 || position % arr[i] == 0) continue;
            swap(arr, i, position);
            findPermutation(arr, position + 1);
            swap(arr, i, position);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
