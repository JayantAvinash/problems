package com.problems.ds;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	TrieNode root;
	
	Trie() {
		root = new TrieNode();
	}
	
	static class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isLeaf;
		char c;
		TrieNode() {
			
		}
		TrieNode(char c) {
			this.c = c;
		}
	}
	
	public void insert(String word) {
		HashMap<Character, TrieNode> children = root.children;
		int length = word.length();
		int count = 0;
		for(char c : word.toCharArray()) {
			TrieNode t;
			if(!children.containsKey(c)) {
				t = new TrieNode(c);
				children.put(c, t);
			} else {
				t = children.get(c);
			}
			children = t.children;
			if(++count == length) {
				t.isLeaf = true;
			}
		}
	}
	
	public boolean search(String word) {
		TrieNode t = searchNode(word);
		if(t == null) {
			return false;
		} else {
			if(t.isLeaf) {
				return true;
			}
		}
		return false;
	}
	
	public boolean searchPrefix(String prefix) {
		TrieNode t = searchNode(prefix);
		if(t == null) {
			return false;
		} else {
			return true;
		}
	}

	private TrieNode searchNode(String word) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for(char c : word.toCharArray()) {
			if (children != null) {
				if (children.containsKey(c)) {
					t = children.get(c);
					children = t.children;
				} else {
					return null;
				} 
			} else {
				return null;
			}
		}
		return t;
	}

	public static void main(String[] args) {
		String[] words = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};
		Trie t = new Trie();
		for(int i = 0; i < words.length; i++) {
			t.insert(words[i]);
		}
		System.out.println(t.search("answers"));
		System.out.println(t.search("a"));
		System.out.println(t.search("an"));
		System.out.println(t.searchPrefix("an"));
	}

}
