package org.design.model.tries;

import java.util.ArrayList;
import java.util.List;

public class ContactTrie {
    private TrieNode root;
    private int indexOfSingleChild;

    public ContactTrie(){
        this.root = new TrieNode("");
    }

    public void insert(String key){
        TrieNode tempTrieNode = root;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            int asciiIndex = c;
            if(tempTrieNode.getChild(asciiIndex) == null){
                TrieNode trieNode = new TrieNode(String.valueOf(c));
                tempTrieNode.setChild(asciiIndex, trieNode);
                tempTrieNode = trieNode;
            }
            else{
                tempTrieNode = tempTrieNode.getChild(asciiIndex);
            }
        }
        tempTrieNode.setLeaf(true);
    }

    public boolean search(String key){
        TrieNode trieNode = root;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            int asciiIndex = c;
            if(trieNode.getChild(asciiIndex) == null)
                return false;
            else
                trieNode = trieNode.getChild(asciiIndex);
        }

        return trieNode.isLeaf();
    }

    public List<String> allWordsWithPrefix(String prefix){
        TrieNode trieNode = root;
        List<String> allWords = new ArrayList<>();
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            int asciiIndex = c;
            trieNode = trieNode.getChild(asciiIndex);
        }
        getSuffixes(trieNode, prefix, allWords);
        return allWords;
    }

    private void getSuffixes(TrieNode trieNode, String prefix, List<String> allWords){
        if(trieNode == null) return;

        if(trieNode.isLeaf())
            allWords.add(prefix);

        for(TrieNode childTrieNode : trieNode.getChildren()){
            if(childTrieNode == null) continue;
            String childCharacter = childTrieNode.getCharacter();
            getSuffixes(childTrieNode, prefix + childCharacter, allWords);
        }
    }

}
