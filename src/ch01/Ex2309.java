package ch01;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[9];
        int totalSum = 0;
        boolean chk = false;

        for(int inputNum=0; inputNum < 9; inputNum++){
            nums[inputNum] = sc.nextInt();
            totalSum += nums[inputNum];
        }
        for(int i=0; i < nums.length-1; i++){
            for(int j=i+1; j < nums.length; j++){
                if((totalSum-nums[i]-nums[j]) == 100){
                    chk = true;
                    nums[i] = Integer.MIN_VALUE;
                    nums[j] = Integer.MIN_VALUE;

                    Arrays.sort(nums);
                    for(int r:nums){
                        if(r != Integer.MIN_VALUE)System.out.println(r);
                    }
                }
                if(chk) break;
            }
        }
    }
}
