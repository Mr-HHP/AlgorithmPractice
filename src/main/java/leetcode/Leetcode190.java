package leetcode;

/**
 * 颠倒二进制位
 *
 * @author Mr.黄
 * @date 2022/04/06
 **/
public class Leetcode190 {
    public int reverseBits(int n) {
        /**
         * 32位无符号整数，如 1111 1111 1111 1111 1111 1111 1111 1111
         * 表示成16进制        f    f    f    f    f    f    f   f
         * 一个16进制的f代表二进制的4位
         * ffff ffff右移16位，变成 0000 ffff
         * ffff ffff左移16位，变成 ffff 0000
         * 它们俩相或，就可以完成低16位与高16位的交换
         *
         * 之后的每次分治，都要先与上一个掩码，再进行交换
         */
        //每2位中低1位和高1位交换; 1010是a,0101是5
        n = ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
        //每4位中低2位和高2位交换; 1100是c,0011是3
        n = ((n & 0xCCCCCCCC) >>> 2) | ((n & 0x33333333) << 2);
        //每8位中低4位和高4位交换;
        n = ((n & 0xF0F0F0F0) >>> 4) | ((n & 0x0F0F0F0F) << 4);
        //每16位中低8位和高8位交换; 1111是f
        n = ((n & 0xFF00FF00) >>> 8) | ((n & 0x00FF00FF) << 8);
        //低16位与高16位交换
        n = ((n & 0xFFFF0000) >>> 16) | ((n & 0x0000FFFF) << 16);
        return n;
    }
    
    public static void main(String[] args) {
        Leetcode190 leetcode190 = new Leetcode190();
    }
}