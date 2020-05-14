/* Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings. */
class Trie {
     
     class TrieNode 
    { 
        TrieNode[] childs = new TrieNode[26]; 
       
       
        boolean isWord; 
          
        TrieNode(){ 
            isWord = false; 
            for (int i = 0; i < 26; i++) 
                childs[i] = null; 
        } 
    }
    TrieNode root = new TrieNode(); 
          
   
     void insert(String word) {
        int level; 
        int length = word.length(); 
        int index; 
       
        TrieNode ptr = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = word.charAt(level) - 'a'; 
            if (ptr.childs[index] == null) 
                ptr.childs[index] = new TrieNode(); 
       
            ptr = ptr.childs[index]; 
        } 
       
       
        ptr.isWord = true; 
    }
    
   
    public boolean search(String word) {
          int level; 
        int length = word.length(); 
        int index; 
        TrieNode ptr = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = word.charAt(level) - 'a'; 
       
            if (ptr.childs[index] == null) 
                return false; 
       
            ptr = ptr.childs[index]; 
        } 
       
        return (ptr != null && ptr.isWord); 
    }
    
   
    public boolean startsWith(String word) {
        int level; 
        int length = word.length(); 
        int index; 
        TrieNode ptr = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = word.charAt(level) - 'a'; 
       
            if (ptr.childs[index] == null) 
                return false; 
       
            ptr = ptr.childs[index]; 
        } 
       
        return (ptr != null); 
        
    }
}
