package ch01;

public class Ex1912 {
    public static void main(String[] args) {
        int[] list = {10, -4, 3, 1, 5, 6, -35, 12, 21, -1};
        int maxResult = 0;
        int tmp = 0;

        for(int k : list)
            System.out.print(k + " ");

        System.out.println();
        for(int i=0; i < list.length-1; i++){
            tmp = list[i] + list[i+1];
            if(tmp > maxResult){
                maxResult = tmp;
            }
        }
        System.out.println(maxResult);
    }

}
