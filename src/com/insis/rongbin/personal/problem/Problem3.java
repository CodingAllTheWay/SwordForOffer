package com.insis.rongbin.personal.problem;

public class Problem3 {
    /*
    找出数组中重复的数
     */
    public int solution(int[] arr, int length){
        if (length != arr.length){
            return -1;
        }
        for(int i = 0; i<length; i++){
            if(arr[i] < 0 || arr[i] > length-1){
                return -1;
            }
        }
        for(int i=0; i<length;i++){
            while(arr[i] != i){
                if(arr[i] == arr[arr[i]]){
                    return arr[i];
                }
                else{
                    int tmp = arr[i];
                    arr[i] = arr[tmp];
                    arr[tmp] = tmp;
                }
            }
        }
        return -1;
    }

    /*
    查找数组中重复的数字,且不改变数组的内容
     */
    public int solutionAnother(int[] arr, int length){
        if(length != arr.length || length == 0){
            return 0;
        }
        int[] arr_another = new int[length];
        for(int i = 0; i<length; i++){
            if(arr_another[arr[i]] == 0){
                arr_another[arr[i]] = arr[i];
            }else{
                return arr[i];
            }

        }
        return 0;
    }

    public static void main(String[] args){
        int arr[] = {2,3,5,4,3,2,6,7};
        Problem3 p = new Problem3();
        System.out.println(p.solutionAnother(arr,8));
    }

}

