package algo;

public class DictionaryTree {
    public static void main(String[] args) {

    }
}


class DTNode {
    public boolean isWord;
    public DTNode[] child = new DTNode[255];

    public DTNode() {
        isWord = false;
        for (int i = 0; i < 255; i++) {
            child[i] = null;
        }
    }

    public static void buildDT(DTNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i);
            DTNode node = new DTNode();
            root.child[pos] = node;
            root = node;
        }
        root.isWord = true;
    }

    public static boolean checkWord(DTNode root, String word) {
        for (int i = 0; i < word.length(); i ++) {
            int pos = word.charAt(i);
            DTNode node = root.child[pos];
            if (node == null) return false;
            root = node;

        }
        return root.isWord;
    }
}