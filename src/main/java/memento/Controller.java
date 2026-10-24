package memento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> undoHistory; // Store the last state before undo for redo functionality
    private boolean lastActionWasUndo = false; // Flag to track if the last action was an undo

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.undoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
        lastActionWasUndo = false;
        gui.refreshHistory();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
        lastActionWasUndo = false;
        gui.refreshHistory();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            saveToUndoHistory(); // Save the current state before undo
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
            gui.refreshHistory();
            lastActionWasUndo = true;
        }
    }

    public void undoUndo() {
        if (!undoHistory.isEmpty()) {
            if (lastActionWasUndo) {
                // If the last action was an undo, redo the last action before the undo
                saveToHistory();
                System.out.println("Redoing last action");
                IMemento preUndoState = undoHistory.remove(undoHistory.size() - 1); // Get the state before the last undo
                model.restoreState(preUndoState);
                gui.updateGui();
                gui.refreshHistory();
                lastActionWasUndo = false;
            }
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    private void saveToUndoHistory() {
        IMemento currentState = model.createMemento();
        undoHistory.add(currentState);
    }

    public List<IMemento> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
