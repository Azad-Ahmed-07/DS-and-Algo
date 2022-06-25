package dsa.algo.bitmagic;

/*
 * Power set P(S) is all the subset of set S.
 * if S = {a,b,c}
 * then P(S) = {{},{a},{b},{c},{a,b},{a,c},{b,c},{a,b,b}}
 * 
 * If S has N element then P(S) will have 2^N element.
 */

 /*
  * Set  = [a,b,c]
  * power_set_size = pow(2, 3) = 8
  * Run for binary counter = 000 to 111
  *
  *   Int    Binary   Bit-Represntation 
  *    0       000         {}
       1       001         {a}
       2       010         {b}
       3       011         {a,b}
       4       100         {c}
       5       101         {a,c}
       6       110         {b,c}
       7       111         {a,b,c}
  */
public class Powerset {
    public static void main(String args[]){
        char[] charArr = "abc".toCharArray();
        PrintPowerSet(charArr, charArr.length);
        
    }

    public static void PrintPowerSet(char[] set, int setSize){
        int pow_set_size = 1 << setSize; // This is equivalent to Math.pow(2,setSize) or 2^3
        // Run loop from 000000....   to 1111111....
        for(int counter = 0; counter < pow_set_size; counter++){
            for(int b = 0; b < setSize;b++){
                // Loop through every bit and check b^th bit of counter is set or not
                if( (counter & (1 << b)) > 0){
                    System.out.print(" "+ set[b] + " ");
                }
            }
            System.out.println();
        }
    }
}
