// leetcode 1363 Largest Multiple of Three

/*
time: O()
space: O()
*/

class Solution {
    public String largestMultipleOfThree(int[] digits) {
        // Step 1: sort the array in non-decreasing order  
        Arrays.sort(digits); 
        // Create 3 queues to store numbers with remainder 0, 1 and 2 respectively  
        Queue<Integer> queue0 = new LinkedList<>(); 
        Queue<Integer> queue1 = new LinkedList<>(); 
        Queue<Integer> queue2 = new LinkedList<>(); 
  
        // Step 2 and 3 get the sum of numbers and place them in corresponding queues  
        int sum = 0; 
        for (int i = 0; i < digits.length; i++) {  
            sum += digits[i];  
            if ((digits[i] % 3) == 0) {
                queue0.add(digits[i]);
            } else if ((digits[i] % 3) == 1) {
                queue1.add(digits[i]);  
            } else {
                queue2.add(digits[i]);
            }
        } 
        
        if (sum == 0) return "0";
  
        // Step 4.2: The sum produces remainder 1  
        if ((sum % 3) == 1)  {  
            // either remove one item from queue1  
            if (!queue1.isEmpty()) queue1.poll();  
  
            // or remove two items from queue2  
            else {  
                if (!queue2.isEmpty())  
                    queue2.poll();  
                else
                    return "";  
  
                if (!queue2.isEmpty())  
                    queue2.poll();  
                else
                    return "";  
            }  
        } 
        // Step 4.3: The sum produces remainder 2  
        else if ((sum % 3) == 2) {  
            // either remove one item from queue2  
            if (!queue2.isEmpty()) queue2.poll();  
            // or remove two items from queue1  
            else {  
                if (!queue1.isEmpty())  
                    queue1.poll();  
                else
                    return "";  
  
                if (!queue1.isEmpty())  
                    queue1.poll();  
                else
                    return "";  
            }  
        } 
          
        int[] aux = new int[digits.length]; 
        // Empty all the queues into an auxiliary array  
        // and get the number of integers added to aux[] 
        int top = populateAux(aux, queue0, queue1, queue2); 
  
        Arrays.sort(aux, 0, top); 
        StringBuilder sb = new StringBuilder();
        for (int i = top - 1; i >= 0; i--) {
            sb.append(aux[i]);
        }  
  
        return sb.length() == 0 ? "" : sb.toString(); 
    }
    
    // This function puts all elements of 3 queues in the array auxiliary 
    public int populateAux(int[] aux, Queue<Integer> queue0, Queue<Integer> queue1, Queue<Integer> queue2) { 
        int top = 0; 
        while (!queue0.isEmpty()) { 
            aux[top++] = queue0.poll(); 
        } 
  
        while (!queue1.isEmpty()) { 
            aux[top++] = queue1.poll(); 
        } 

        while (!queue2.isEmpty()) { 
            aux[top++] = queue2.poll(); 
        } 
  
        return top; 
    } 
  
}