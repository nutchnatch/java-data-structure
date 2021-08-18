package hashtable;

import java.util.ArrayList;

public class DoubleHashing {

    public static void main(String[] args) {
        DoubleHashing DoubleHashing = new DoubleHashing(13);
        DoubleHashing.insert("The");
        DoubleHashing.insert("quick");
        DoubleHashing.insert("brown");
        DoubleHashing.insert("fox");
        DoubleHashing.insert("over");
        DoubleHashing.displayHashTable();
    }

    String[] hashTable;
    int usedCellNumber;

    public DoubleHashing(int size) {
        hashTable = new String[size];
        usedCellNumber = 0;
    }

    public int simpleAASCIIHashFUnction(String word, int M) {
        char ch[];
        ch = word.toCharArray();
        int i, sum;

        for(sum = 0, i = 0; i < word.length(); i ++) {
            sum = sum + ch[i];
        }
        return sum % M;
    }

    private int addAllDigitTogether(int sum) {
        int value = 0;
        while(sum > 0) {
            value = sum % 10;
            sum = sum / 10;
        }
        return value;
    }

    public int secondHashFunction(String x, int M) {
        char[] ch = x.toCharArray();
        int i, sum;
        for(sum = 0, i = 0; i < x.length(); i ++) {
            sum += ch[i];
        }
        while(sum > hashTable.length) {
            sum = addAllDigitTogether(sum);
        }
        return sum % M;
    }

    private double getLoadFactor() {
        return usedCellNumber * 1.0/hashTable.length;
    }

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
        double loadFactor = getLoadFactor();
        if(loadFactor >= 0.75) {
            reHashing(word);
        } else {
            int x = simpleAASCIIHashFUnction(word, hashTable.length);
            int y = secondHashFunction(word, hashTable.length);
            for(int i = 0; i < hashTable.length; i ++) {
                int newIndex = x + (i * y) % hashTable.length;
                if(hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    System.out.println("Word " + word + " successfully inserted at location:" + newIndex);
                    break;
                } else {
                    System.out.println("Index already occupied, trying next empty cell");
                }
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
