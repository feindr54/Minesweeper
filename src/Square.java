public class Square {
    private boolean isClicked;
    private boolean isFlagged;
    private boolean isMine;
    private int numMinesAround, row, column;

    public Square(int row, int column, boolean isMine) {
        this.isClicked = false;
        this.isFlagged = false;
        this.row = row;
        this.column = column;
        this.isMine = isMine;
        numMinesAround = 0;
    }

    public void setNumMinesAround(int numMinesAround) {
        this.numMinesAround = numMinesAround;
    }

    public void flag() {
        this.isFlagged = !isFlagged;
    }

    public void unflag() {
        this.isFlagged = false;
    }

    public void click() {
        if (this.isFlagged) {
            System.out.println("You can't selected a flagged tile.");
            return;
        } else {
            isClicked = true;
        }
    }

    public boolean getClicked() {
        return isClicked;
    }

    public boolean getFlagged() {
        return isFlagged;
    }

    public boolean getMine() {
        return isMine;
    }

    public int getNumMinesAround() {
        return numMinesAround;
    }
}
