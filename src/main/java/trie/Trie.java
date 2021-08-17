package trie;

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("API");
        trie.insert("APIS");
        trie.search("API");
        trie.delete("APIS");
        trie.search("APIS");
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        System.out.println("Trie was successfully created.");
    }

    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i ++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println("Successfully inserted " + word + " in tried");
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i ++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                System.out.println("Word " + word + " does not exist in trie");
                return false;
            }
            current = node;
        }
        if(current.endOfString) {
            System.out.println("Word " + word + " found in the trie");
            return true;
        } else {
            System.out.println("Word " + word + " not found in the trie. But it is a prefix of another string");
        }
        return current.endOfString;
    }

    private boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canDeleteNode;
        if(currentNode.children.size() > 1) {
            delete(currentNode, word, index + 1);
            return false;
        }
        if(index == word.length() - 1) {
            if(currentNode.children.size() >= 1) {
                currentNode.endOfString = false;
                return false;
            } else {
                parentNode.children.remove(ch);
                return true;
            }
        }
        if(currentNode.endOfString) {
            delete(currentNode, word, index + 1);
            return false;
        }
        canDeleteNode = delete(currentNode, word, index + 1);
        if(canDeleteNode) {
            parentNode.children.remove(ch);
            return true;
        } else {
            return false;
        }
    }

    public void delete(String word) {
        if(search(word)) {
            delete(root, word, 0);
        } else {
            System.out.println("Word " + word + " does not exist in trie");
        }
    }
}
