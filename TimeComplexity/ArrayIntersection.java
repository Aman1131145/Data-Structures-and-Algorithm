package TimeComplexity;

// import java.io.BufferedReader;
// import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class ArrayIntersection {

    // static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // public static int[] takeInput() throws IOException {
    //     int size = Integer.parseInt(br.readLine().trim());
    //     int[] input = new int[size];

    //     if (size == 0) {
    //         return input;
    //     }
        
    //     String[] strNums; 
    //     strNums = br.readLine().split("\\s");
        

    //     for (int i = 0; i < size; ++i) {
    //         input[i] = Integer.parseInt(strNums[i]);
    //     }

    //     return input;
    // }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = 1;//Integer.parseInt(br.readLine().trim());

        while(t > 0) {
            int[] arr1 = {2,6,1,2};//takeInput();
            int[] arr2 = {1,2,3,4,2};//takeInput();
            ArrayIntersection.intersection(arr1, arr2);
            System.out.println();

            t -= 1;
        }
    }

    public static void intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        int j = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }else if(arr1[i] < arr2[j]){
                i++;
            }else{
                j++;
            }
        }
    }    
}