package Testar;

public class BubbleSort {

    public static void main(String[] args){
        int arr[] ={66,2,35,7,450,320,44};

        for(int a = 0; a < arr.length; a++){
            System.out.print(arr[a] + " " );
        }
        System.out.print("\n");
        bubbleSort(arr);
        for(int b = 0; b < arr.length; b++){
            System.out.print(arr[b] + " ");
        }
    }

    private static void bubbleSort(int[] arr){
      int i, j, temp;
        int array = arr.length;

        for(i = 0; i < array; i++){
            for (j = 1; j < (array-1); j++){
            if(arr[j-1] > arr[j]){
                temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
            }
        }

            }
}
