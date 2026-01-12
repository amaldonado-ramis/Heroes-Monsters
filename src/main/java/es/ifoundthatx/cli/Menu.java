package es.ifoundthatx.cli;

public abstract class Menu {
    public void show() {
        showOptions();
        userChoice();
    }

    protected abstract void showOptions();
    protected abstract void userChoice();
}
