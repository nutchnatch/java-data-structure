package hashtable;

import java.util.ArrayList;

public class QuadraticProbing {

    public static void main(String[] args) {
        QuadraticProbing quadraticProbing = new QuadraticProbing(13);
        quadraticProbing.insert("The");
        quadraticProbing.insert("quick");
        quadraticProbing.insert("brown");
        quadraticProbing.insert("fox");
        quadraticProbing.insert("over");
        quadraticProbing.displayHashTable();
    }

    String[] hashTable;
    int usedCellNumber;

    public QuadraticProbing(int size) {
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

    private void insert(String word) {
        double loadFactor = getLoadFactor();
        if(loadFactor >= 0.75) {
            reHashing(word);
        } else {
            int index = modAASCIIHashFUnction(word, hashTable.length);
            int counter = 0;
            for(int i = index; i < index + hashTable.length; i ++) {
                int newIndex = (index + (counter * counter)) % hashTable.length;
                if(hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    System.out.println("Word: " + word + " has been inserted successfully.");
                    break;
                } else {
                    System.out.println("Index " + newIndex + "  already occupied, trying next empty cell");
                }
                counter ++;
            }
        }
        usedCellNumber ++;
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
}
