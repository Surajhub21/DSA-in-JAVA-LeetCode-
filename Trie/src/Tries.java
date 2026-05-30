public class Tries {

    private static Node root;

    Tries() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                return false;
            }
            node = node.get(c);
        }
        if(node.isEnd()){
            return true;
        }
        return false;
    }

    boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(!node.containsKey(c)){
                return false;
            }
            node = node.get(c);
        }
        return true;
    }


    public static void main(String[] args) {
        Tries tries = new Tries();
        tries.insert("apple");
        tries.insert("app");

        System.out.println(tries.search("app"));
        System.out.println(tries.startsWith("appx"));
    }

}

class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    Node(){}

    boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    Node get(char ch){
        return links[ch - 'a'];
    }

    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    void setEnd(){
        flag = true;
    }

    boolean isEnd(){
        return flag;
    }
}
