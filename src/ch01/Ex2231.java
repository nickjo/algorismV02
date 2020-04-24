package ch01;

import java.util.Scanner;

public class Ex2231 {
    public static void main(String[] args) {
        int num;
        int numLength;
        int minNum;
        int chkNum;
        int sum = 0;
        int resultNum = 0;

        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        numLength = (int)(Math.log10(num)+1);

//        System.out.println("numLength: " + numLength);

        minNum = numLength * 9;

        for(int i=num-minNum; i < num; i++){
//            System.out.printf(i + " ");
            chkNum = i;

            while(chkNum != 0){
                sum += chkNum % 10;
                chkNum /= 10;
            }

            if(i + sum == num){
//                System.out.println(i);
                resultNum = i;
                break;
            }else {
                sum = 0;
                resultNum = 0;
            }
        }
        System.out.println(resultNum);

    }
}
