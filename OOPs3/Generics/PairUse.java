// package OOPs3.Generics;

// public class PairUse {

//     public static void main(String[] args) {
//         Pair<String,Integer> p = new Pair<String,Integer>("first",1);
//         p.setFirst("abc");
//         String s = p.getFirst();

//         Pair<Integer,Character> p1  = new Pair<Integer,Character>(1,'a');
//         Pair<Character,String> p2 = new Pair<>('a',"generics");

//         int a = 10;
//         int b = 20;
//         int c = 30;
//         Pair<Integer,Integer> internalPair = new Pair<>(a,b);
//         Pair<Pair<Integer,Integer>,Integer> p3 = new Pair<>(internalPair,c);

//         System.out.println(p3.getSecond());
//         System.out.println(p3.getFirst().getFirst());
//         System.out.println(p3.getFirst().getSecond());
//     }
// }