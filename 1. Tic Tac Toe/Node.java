public class Node {
    static boolean playsAsMin = true;
    // static boolean playsAsMin = true; // ai plays as second player

    int[][] field = new int[3][3];
    Node[][] children = new Node[3][3];

    int value;
    boolean isMin;

    public Node(int[][] field, boolean isMin) {
        this.isMin = isMin;
        this.field = field;
    }

    int[][] copyField() {
        int[][] copied = new int[3][3];
        for (int i = 0; i < copied.length; i++) {
            for (int j = 0; j < copied[i].length; j++) {
                copied[i][j] = field[i][j];
            }
        }
        return copied;
    }

    public int learn() {
        if (TicTacToe.hasWon(field)) {
            value = isMin ? 1 : -1;
            return value;
        } else if (TicTacToe.fieldFull(field)) {
            value = 0;
            return value;
        }

        value = isMin ? 1 : -1;

        for (int i = 0; i < children.length; i++) {
            for (int j = 0; j < children[i].length; j++) {

                if (field[i][j] == 0) {
                    int[][] childField = copyField();
                    childField[i][j] = isMin ? 1 : 2;
                    // int value=heuristic(childField);
                    // if(value!=-1) {
                    // return value;
                    // }
                    children[i][j] = new Node(childField, !isMin);

                    value = isMin ? Math.min(value, children[i][j].learn()) : Math.max(value, children[i][j].learn());

                }
            }
        }

        return value;
    }

    public Node getChildWithValue() {

        for (int i = 0; i < children.length; i++) {
            for (int j = 0; j < children[i].length; j++) {
                if (children[i][j] != null && children[i][j].value == value) {
                    return children[i][j];
                }
            }
        }
        return null;
    }

    /////////////

    // public int heuristic(int field[][]) {
    // int D=0;
    // for(int i=0;i<field.length;i++) {
    // for(int j=0;j<field[0].length;j++) {
    // if(field[i][j]==2 && secondPlayer.contains((i*3)+j)==false) {
    // secondPlayer.add(magic[i][j]);
    // }
    // }
    // }
    //
    // for(int i=0;i<secondPlayer.size();i++) {
    // for(int j=0;j<secondPlayer.size();j++) {
    // if(i!=j) {
    // D=15-secondPlayer.get(i)-secondPlayer.get(j);
    // if(D>=0 && D<=9) {
    // return D;
    // }
    // }
    // }
    //
    // }
    // return -1;
    // }
}