package ch01;

import java.util.Scanner;

public class Ex10448 {
    static int[] eureka = new int[44];
    static boolean[] chkList = new boolean[1001];
    static int chkListIndex = 0;
    static int n = 1;
    static int chkSum;

    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] arrInt = new int[cnt];

        for(int i=0; i < cnt; i++){
            arrInt[i] = sc.nextInt();
        }

        for(int i=0; i < cnt; i++){
            System.out.println(chkEureka(arrInt[i]));
        }
    }

    static void init(){
        while(n*(n+1)/2 < 1000){
            eureka[n-1] = n*(n+1)/2;
            n++;
        }

        while(chkListIndex < chkList.length){
            for(int i=0; i < eureka.length; i++){
                if(chkList[chkListIndex]) continue;
                for(int j=0; j < eureka.length; j++){
                    if(chkList[chkListIndex]) continue;
                    for (int k=0; k < eureka.length; k++){
                        chkSum = eureka[i]+eureka[j]+eureka[k];
                        if(chkSum == chkListIndex){
                            chkList[chkSum] = true;
                            continue;
                        }else if(chkSum > chkListIndex){
                            continue;
                        }
                    }
                }
            }
            chkListIndex++;
        }
    }

    static int chkEureka(int inputNum){
        return (chkList[inputNum] == true)?1:0;
    }
}
