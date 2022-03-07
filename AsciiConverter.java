import java.util.Scanner;

public class AsciiConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sum += (int)c;
        }
        System.out.println(sum);
        sc.close();
    }
}
