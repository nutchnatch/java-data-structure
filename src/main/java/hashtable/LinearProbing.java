package hashtable;

import java.util.ArrayList;

public class LinearProbing {

    public static void main(String[] args) {
        LinearProbing linearProbing = new LinearProbing(13);
        linearProbing.insert("The");
        linearProbing.insert("quick");
        linearProbing.insert("brown");
        linearProbing.insert("fox");
        linearProbing.insert("over");
        linearProbing.displayHashTable();
        linearProbing.search("fox");
        linearProbing.search("ox");
        linearProbing.delete("fox");
        linearProbing.search("fox");
    }

    String[] hashTable;
    int usedCellNumber;

    public LinearProbing(int size) {
        hashTable = new String[size];
        usedCellNumber = 0;
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

    private double getLoadFactor() {
        return usedCellNumber * 1.0/hashTable.length;
    }

    // rehash
    private void reHashing(String word) {
        usedCellNumber = 0;
        ArrayList<String> data = new ArrayList<>();
        for(String s: hashTable) {
            if(s != null) {
                data.add(s);
            }
            data.add(word);
            hashTable = new String[hashTable.length * 2];
            for(String d: data) {
                insert(d);
                usedCellNumber ++;
            }
        }
    }

    public void insert(String word) {
        final double loadFactor = getLoadFactor();
        if(loadFactor >= 0.75) {
            reHashing(word);
        } else {
            int index = modAASCIIHashFUnction(word, hashTable.length);
            for(int i = index; i < index + hashTable.length; i ++) {
                int newIndex = i % hashTable.length;
                if(hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    System.out.println("Word " + word + " successfully inserted at location:" + newIndex);
                    break;
                } else {
                    System.out.println("Index already occupied, trying next empty cell");
                }
            }
        }
        usedCellNumber++;
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
        int index = modAASCIIHashFUnction(word, hashTable.length);
        for(int i = index; i < index + hashTable.length; i ++) {
            int newIndex = i % hashTable.length;
            if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                System.out.println("Word " + word + " found at location " + newIndex);
                return true;
            }
        }
        System.out.println("Word " + word + " not found in hashtable");
        return false;
    }

    public void delete(String word) {
        int index = modAASCIIHashFUnction(word, hashTable.length);
        for(int i = index; i < index + hashTable.length; i ++) {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                hashTable[newIndex] = null;
                System.out.println("Word " + word + " has been deleted");
                return;
            }
        }
        System.out.println("Word " + word + " not found in hashtable");
    }
}
