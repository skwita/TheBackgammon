package game.model;

enum Color {EMPTY, WHITE, BLACK}

public class Triangle {
    private int amount;
    private Color color = Color.EMPTY;

    public Triangle(int number) {
        switch (number) {
            case 0:
                this.amount = 15;
                this.color = Color.WHITE;
                break;
            case 12:
                this.amount = 15;
                this.color = Color.BLACK;
                break;
            default:
                this.amount = 0;
                break;
        }
    }

    public int getAmount() {
        return amount;
    }

    public Color getColor() {
        return color;
    }

    public boolean isBlack(){
        return this.color == Color.BLACK;
    }

    public boolean addChecker(Color color) {
        if (!color.equals(this.color) && !this.color.equals(Color.EMPTY)) {
            return false;
        }
        if (this.color.equals(Color.EMPTY)) {
            this.color = color;
        }
        amount++;
        return true;
    }

    public void removeChecker() {
        if (amount == 1) {
            color = Color.EMPTY;
        }
        amount--;
    }
}
