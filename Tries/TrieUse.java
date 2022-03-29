package Tries;

/**
 * TrieUse
 */
public class TrieUse {

    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("this");
        t.add("that");
        t.add("news");
        System.out.println(t.search("news"));
        t.remove("news");
        System.out.println(t.search("news"));
    }
}