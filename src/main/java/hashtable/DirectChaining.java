package hashtable;

import java.util.ArrayList;
import java.util.LinkedList;

public class DirectChaining {
    public static void main(String[] args) {
        DirectChaining directChaining = new DirectChaining(13);
        directChaining.insertHashTable("The");
        directChaining.insertHashTable("quick");
        directChaining.insertHashTable("brown");
        directChaining.insertHashTable("fox");
        directChaining.insertHashTable("over");
        directChaining.displayHashTable();
        directChaining.search("over");
        directChaining.search("fox");
        directChaining.search("fo");
        directChaining.delete("fox");
        directChaining.displayHashTable();
        directChaining.delete("fo");
    }

    LinkedList<String>[] hashTable;
    int maxChainSize = 5;

    public DirectChaining(int size) {
        hashTable = new LinkedList[size];
    }

    public int modAASCIIHashFUnction(String word, int M) {
        char ch[];
        ch = word.toCharArray();
        int i, sum;

        for(sum = 0, i = 0; i < word.length(); i ++) {
            sum = sum + ch[i];
        }
        return sum % M;
    }

    public void insertHashTable(String word) {
        int newIndex = modAASCIIHashFUnction(word, hashTable.length);
        if(hashTable[newIndex] == null) {
            hashTable[newIndex] = new LinkedList<String>();
            hashTable[newIndex].add(word);
        } else {
            hashTable[newIndex].add(word);
        }
    }

    public void displayHashTable() {
        if(hashTable == null) {
            System.out.println("HashTable does not exist");
            return;
        } else {
            System.out.println("--------HashTable-------");
            for(int i = 0; i < hashTable.length; i ++) {
                System.out.println("Index: " + i + ", key: " + hashTable[i]);
            }
        }
    }

    public boolean search(String word) {
        int newIndex = modAASCIIHashFUnction(word, hashTable.length);
        if(hashTable[newIndex] != null && hashTable[newIndex].contains(word)) {
            System.out.println("Word: " + word + " found at location: " + newIndex);
            return true;
        } else {
            System.out.println("Word: " + word + " not found at location: " + newIndex);
            return false;
        }
    }

    public void delete(String word) {
        int newIndex = modAASCIIHashFUnction(word, hashTable.length);
        boolean result = search(word);
        if(result) {
            hashTable[newIndex].remove(word);
            System.out.println("Word: " + word + " deleted from at hashtable: ");
        }
    }
}
