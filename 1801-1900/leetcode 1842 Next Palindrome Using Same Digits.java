// leetcode 1842 Next Palindrome Using Same Digits

/*
time: O(n)
space: O(n)
*/

class Solution {
    public String nextPalindrome(String num) {
        int len = num.length();
        int[] arr = new int[len / 2];
        for (int i = 0; i < arr.length; i++) arr[i] = num.charAt(i) - '0';
        if (!nextPermutation(arr)) return "";
        
        StringBuilder sb = new StringBuilder();
        for (int i : arr) sb.append(i);

        if (len % 2 == 0) return sb.toString() + sb.reverse().toString();
        else return sb.toString() + num.substring(len / 2, len / 2 + 1) + sb.reverse().toString();
    }

    private boolean nextPermutation(int[] nums) {
        int firstSmall = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstSmall = i;
                break;
            }
        }
        if (firstSmall == -1) {
            reverse(nums, 0, nums.length - 1);
            return false;
        }

        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmall; i--) {
            if (nums[i] > nums[firstSmall]) {
                firstLarge = i;
                break;
            }
        }

        swap(nums, firstSmall, firstLarge);
        reverse(nums, firstSmall + 1, nums.length - 1);
        return true;
    }

    private void swap(int[]nums, int i, int j) {
        int temp = nums[i];
        nums[i++] = nums[j];
        nums[j--] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}