package com.insis.rongbin.personal.problem;

public class Problem4 {
    /*
    二维数组中数的查找
     */
    public boolean searchInArray(int [][] arr, int width, int height, int number){
        int w = arr.length;
        int h;
        if(w == 0){
            return  false;
        }else{
            h = arr[0].length;
            if(h == 0){
                return false;
            }
        }
        if(width != w || height != h){
            return false;
        }
        int i = 0;
        int j = height - 1;
        while (i <= width-1 && j >= 0){
            if(arr[i][j] == number){
                System.out.printf("i = %d, j =%d \n",i,j);
                return true;
            }else if(arr[i][j] > number){
                j --;
            }else{
                i++;
            }
        }
        return false;

    }

    public static void main(String[] args){
        int [][]arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Problem4 p = new Problem4();
        System.out.println(p.searchInArray(arr, 4,4,7));
    }
}

