package ru.eight_queens.entities;

import ru.eight_queens.entities.figures.Figure;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 13:04
 */
public class Cell {
    int row;
    int column;
    Field field;
    Figure figure = null;
    boolean attacked = false;
    boolean restrictedForUsing = false;

    public Cell(int row, int column, Field field)
    {
        this.row = row;
        this.column = column;
        this.field = field;
    }

    public boolean isAttacked() {
        return attacked;
    }

    public void setAttacked(boolean attacked) {
        this.attacked = attacked;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isRestrictedForUsing() {
        return restrictedForUsing;
    }

    public void setRestrictedForUsing(boolean restrictedForUsing) {
        this.restrictedForUsing = restrictedForUsing;
    }

    public boolean canBeUsed()
    {
        return (!attacked && !restrictedForUsing && (figure == null));
    }

    public Field getField() {
        return field;
    }
}
