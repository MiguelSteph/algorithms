/**
 * Lien du problème : https://leetcode.com/problems/koko-eating-bananas/
 * Youtube Video Lien: https://youtu.be/qnXH24_mILI
 * Auteur de la solution : Miguel Stephane KAKANAKOU
 * Date: 26-07-2022
 */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        int max = piles[0];
        
        for (int tas : piles) {
            max = Math.max(max, tas);
            sum += tas;
        }
        int min = (int) (sum / h);
        if (sum%h != 0) {
            min++;
        }
        return searchMin(piles, min, max, h);
    }
    
    private int searchMin(int[] piles, int min, int max, int h) {
        if (min == max) return max;
        int mid = (min + max) / 2;
        boolean isValid = isValidK(piles, mid, h);
        if (isValid) {
            return searchMin(piles, min, mid, h);
        } else {
            return searchMin(piles, mid+1, max, h);
        }
    }
    
    private boolean isValidK(int[] piles, int k, int h) {
        int nbrHours = 0;
        for (int tas : piles) {
            int hours = tas / k;
            if (tas%k != 0) {
                hours++;
            }
            nbrHours += hours;
        }
        return nbrHours <= h;
    }
}
