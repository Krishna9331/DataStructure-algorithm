package chapter15;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mishrk3 on 4/8/2017.
 */
public class Trie {

	private static class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			this.children = new HashMap<>();
			this.endOfWord = false;
		}
	}

	private final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	/**
	 * O(n) where n is length of word
	 * 
	 * @param word
	 *            to be inserted in trie
	 */
	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}

	/**
	 * Time Complexity: O(n) where n is length of word to be searched
	 * 
	 * @param word
	 *            the word to be searched
	 * @return true if word exists in trie
	 */
	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode node = current.children.get(word.charAt(i));
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.endOfWord;
	}

	/**
	 * @param word
	 */
	public void delete(String word) {
		delete(root, word, 0);

	}

	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			if (!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			return current.children.size() == 0;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(node, word, index + 1);
		if (shouldDeleteCurrentNode) {
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		return false;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("I");
		trie.insert("India");
		trie.insert("INDIA");
		trie.insert("Indore");
		trie.insert("apple");
		trie.insert("apple$");
		trie.insert("banana");
		trie.insert("bangalore");
		trie.insert("appeal");
		trie.insert("cool");
		System.out.println("Trie is created");
		System.out.println("Trie contains I: " + trie.search("I"));
		System.out.println("Trie contains India: " + trie.search("India"));
		System.out.println("Trie contains Indor: " + trie.search("Indor"));
		System.out.println("Trie contains INDIA: " + trie.search("INDIA"));
		System.out.println("Trie contains BOLD: " + trie.search("BOLD"));
		System.out.println("Trie contains appeal: " + trie.search("appeal"));
		System.out.println("Trie contains banana: " + trie.search("banana"));
		System.out.println("Trie contains cool: " + trie.search("cool"));
		System.out.println("Trie contains apple: " + trie.search("apple"));
		System.out.println("Trie contains apple$: " + trie.search("apple$"));
		trie.delete("apple$");
		System.out.println("Trie contains apple$: " + trie.search("apple$"));
	}
}
