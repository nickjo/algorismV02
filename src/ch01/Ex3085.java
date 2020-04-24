package ch01;

import java.util.Scanner;

public class Ex3085 {
    static int maxResult;
    static int rlCandyCnt = 1;
    static int btCandyCnt = 1;
    static char[][] list;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new char[n][n];
        for(int i=0; i < n; i++){
            list[i] = sc.next().toCharArray();
        }

        searchAll();
        System.out.println(maxResult);
    }

    // 전체 조회
    static void searchAll(){
        for (int i=0; i < list.length; i++){
            for (int j=0; j < list[i].length; j++){
                calMaxCandy(i, j);
            }
        }
    }

    // 가장 긴 캔디 계산
    static void calMaxCandy(int i, int j) {
        for (int allQuarters = 0; allQuarters < 2; allQuarters++) {
            swapCandy(i, j, allQuarters); // 스왑
            chkMaxCandy();
            swapCandy(i, j, allQuarters); // 롤백
        }
    }

    // 스왑 or 롤백
    static void swapCandy(int i, int j, int allQuarters){
        char origin  = list[i][j];
        char temp;

        switch (allQuarters){
            case 0: //right
                if(j+1 < list.length){
                    temp = origin;
                    list[i][j] = list[i][j+1];
                    list[i][j+1] = temp;
                }
                break;
            case 1: // bottom
                if(i+1 < list.length){
                    temp = origin;
                    list[i][j] = list[i+1][j];
                    list[i+1][j] = temp;
                }
                break;
        }
    }

    // 가장 긴 캔디 수를 계산
    static void chkMaxCandy(){
        for (int x=0; x < list.length; x++){
            for (int y=0; y < list[x].length; y++){
                for (int allQuarters = 0; allQuarters < 4; allQuarters++) {
                    switch (allQuarters){
                        case 0: //right
                            for (int k=y+1; k < list[x].length; k++){
                                if(list[x][y] == list[x][k]){ // 동일 사탕
                                    rlCandyCnt++;
                                }else{
                                    break;
                                }
                            } // end for
                            for (int k=y-1; k >= 0; k--){
                                if(list[x][y] == list[x][k]){ // 동일 사탕
                                    rlCandyCnt++;
                                }else{
                                    break;
                                }
                            } // end for
                            break;
                        case 1: //bottom
                            for (int k=x+1; k < list[x].length; k++){
                                if(list[x][y] == list[k][y]){ // 동일 사탕
                                    btCandyCnt++;
                                }else{
                                    break;
                                }
                            }
                            for (int k=x-1; k >= 0; k--){
                                if(list[x][y] == list[k][y]){ // 동일 사탕
                                    btCandyCnt++;
                                }else{
                                    break;
                                }
                            }
                            break;
                    } // end switch
                }
                if(maxResult < rlCandyCnt){
                    maxResult = rlCandyCnt;
                }
                if(maxResult < btCandyCnt){
                    maxResult = btCandyCnt;
                }
                rlCandyCnt = 1;
                btCandyCnt = 1;
            }
        } // end for
    } //  end chkMaxCandy()
}
