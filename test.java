public class test {
    public static void main(String[] args) {
        int i = 47382;
        for(int n = 4; n >= 0; n--){
            System.out.println(i%10);
            i = i/10;
        }
    }
}
