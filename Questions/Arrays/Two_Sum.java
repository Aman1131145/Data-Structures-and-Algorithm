package Questions.Arrays;
import java.util.Scanner;

public class Two_Sum {

    public static int[] twoSum(int[] nums, int target) {
        int answer[] = new int[2];        
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
				if(nums[i] + nums[j] == target){
					answer[0] = i;
					answer[1] = j;
					break;
				}
			}
        }
        return answer;
    }
	
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		int[] input = {3,4,2};//takeInput();
		int x = 6;//s.nextInt();
		int output[] = Two_Sum.twoSum(input, x);
		for(int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
        s.close();
	}
    
}
