// Prefix Sum of Array


// [1, 2, 3, 4] -> [1, 3, 6, 10]
public int[] makeCumul(int[] in) {
    int[] out = new int[in.length];
    int total = 0;
    for (int i = 0; i < in.length; i++) {
        total += in[i];
        out[i] = total;
    }
    return out;
}