package edu.princeton.cs.algs4;

/**
 * set
 * bit_fld |= (1<<n)
 * clear
 * bit_fld &= ~(1<<n)
 * toggle
 * bit_fld ^= (1<<n)
 * test
 * bit_fld & (1<<n)
 */
public class BitwiseOps {
    /**
     * convert to binary format
     */
    public static void convert(int n){
        if(0==n) return;
        convert(n/2);
        //like stack, but since it is in recursion, it's in frame stack
        System.out.print(n%2);
    }

    public static boolean isPowerOf2(int x){
        return (x & (x-1)) ==0;
    }

    public static boolean isKBitSet(int x, int k){
        return (x & 1<<(k-1))!=0;

    }

    /**
     * for any integer x, it diffs with x-1 on lowest bit.
     */
    public static int stripLowestOneOff(int x){
        return x & (x-1);

    }
    public static int extractLowestBit(int x){
        return x ^ (x &(x-1));
    }

    public static int forceKBitSet(int x,int k){
        return x | (1 <<(k-1));
    }

    /**
    0 ^ 1 = 1
    1 ^ 1 = 0
     **/
    public static int toggleKbitInX(int x,int k){
        return x ^ (1<<(k-1));
    }

    public static void main(String[] args) {
        convert(10);
//        System.out.println(isPowerOf2(64));
//        System.out.println(Integer.toBinaryString(34));
//        System.out.println(isKBitSet(34,3));
//        System.out.println(extractLowestBit(64));
    }
}
