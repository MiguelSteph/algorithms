/**
 * Lien du problème : https://leetcode.com/problems/generate-parentheses/
 * Youtube Video Lien:
 * Auteur de la solution : Miguel Stephane KAKANAKOU
 * Date: 10-07-2022
 */

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> resultat = new ArrayList<>();
        generate(resultat, "", n, n);
        return resultat;
    }
    
    private void generate(List<String> resultat, String str, int openCount, int closeCount) {
        if (openCount == 0 && closeCount == 0) {
            resultat.add(str);
            return;
        }
        if (openCount > 0) {
            generate(resultat, str + "(", openCount-1, closeCount);
        }
        if (openCount < closeCount) {
            generate(resultat, str + ")", openCount, closeCount-1);
        }
    }
}
