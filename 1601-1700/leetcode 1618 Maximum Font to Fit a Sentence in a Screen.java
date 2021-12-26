// leetcode 1618 Maximum Font to Fit a Sentence in a Screen

/*
time: O(logn)
space: O(1)
*/

/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 *     // Return the width of char ch when fontSize is used.
 *     public int getWidth(int fontSize, char ch) {}
 *     // Return Height of any char when fontSize is used.
 *     public int getHeight(int fontSize)
 * }
 */

class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int l = 0;
        int r = fonts.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int fontSize = fonts[mid];
            if (possible(text, w, h, fontSize, fontInfo)) {
                ans = fontSize;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }

    private boolean possible(String text, int w, int h, int fontSize, FontInfo fontInfo) {
        int width = 0;

        if (fontInfo.getHeight(fontSize) > h) return false;

        for (int index = 0; index < text.length(); index++) {
            width += fontInfo.getWidth(fontSize, text.charAt(index));
            if (width > w) return false;
        }
        return true;
    }
}