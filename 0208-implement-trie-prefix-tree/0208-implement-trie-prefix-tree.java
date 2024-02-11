class Node {
    char data;
    boolean isWord;
    HashMap<Character, Node> children;
    
    public Node(char data, boolean isWord, HashMap<Character, Node> children) {
        this.data = data;
        this.isWord = isWord;
        this.children = children;
    }
    
    public HashMap<Character, Node> getChildren() {
        return this.children;
    }
    
    public boolean isEndOfWord() {
        return this.isWord;
    }
    
    public void setEndOfWord(boolean isWord) {
        this.isWord = isWord;
    }
}

class Trie {
    
    private Node root;

    public Trie() {
        root = new Node('.', false, new HashMap<>());
    }
    
    public void insert(String word) {
        Node current = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            HashMap<Character, Node> cn = current.getChildren();
            
            if (cn.containsKey(ch)) {
                current = cn.get(ch);
            } else {
                Node x = new Node(ch, (i==word.length()-1) ? true : false, new HashMap<>());
                cn.put(ch, x);
                current = x;
            }
        }
        current.setEndOfWord(true);
    }
    
    public boolean search(String word) {
        Node current = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = current.getChildren().get(ch);
            if (node == null)
                return false;
            
            current = node;
        }
        return current.isEndOfWord();
    }
    
    public boolean startsWith(String prefix) {
        Node current = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            Node node = current.getChildren().get(ch);
            if (node == null)
                return false;
            
            current = node;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */