package Tries;

import java.io.*;
import java.util.*;

public class AutoComplete {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	
	public static void main(String[] args) throws IOException{
		AutoComplete t = new AutoComplete();
		int n = Integer.parseInt(br.readLine().trim());
        ArrayList<String> input = new ArrayList<String>();
        String[] words = br.readLine().split("\\s");
		for(int i = 0; i < n; i++) {
			
			input.add(words[i]);
		}
		String pattern = br.readLine();
		t.autoComplete(input, pattern);
	}

    private TrieNode root;
	public int count;
    
	public AutoComplete() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}
    public void autoComplete(ArrayList<String> input, String word) {
        for(String w : input) {
            add(w);
        }
        TrieNode node = findRoot(root, word);
        if(node == null || node.childCount == 0) {
            return;
        }
        String output = "";
        allRootToLeafPaths(node, output, word);
    }
    
    public TrieNode findRoot(TrieNode root, String word) {
        if(word.length() == 0){
            return root;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return null;
        }
        return findRoot(child, word.substring(1));
    }
    
    private void allRootToLeafPaths(TrieNode node, String output, String word) {
        if(node.childCount == 0) {
            if(output.length() > 0) {
                System.out.println(word + output);
            }
            return;
        }
        if(node.isTerminating == true) {
            System.out.println(word + output);
        }
        for(int i = 0; i < node.children.length; i++) {
            if(node.children[i] != null) {
                String ans = output + node.children[i].data;
                allRootToLeafPaths(node.children[i], ans, word);
            }
        }
    }
    
    /*public void autoComplete(ArrayList<String> input, String word) {
        // change with Trie
        Trie trie = new Trie();
        for(String string : input ) {
            trie.add(string);
        }
        TrieNode t = trie.search(word);
        if(t==null) {
            return ;
        }
        printPossibleWords(t,word,"");
    }
    
    public void printPossibleWords(TrieNode root, String word,String output ) {
        if(root.isTerminating) {
            System.out.println(word + output);
        }
        for(int i=0;i<root.children.length;i++) {
            if(root.children[i]!=null){
                printPossibleWords(root.children[i], word, output + root.children[i].data  );
            }
        }
    }*/
    
}
