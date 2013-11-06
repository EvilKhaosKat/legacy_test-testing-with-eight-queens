package ru.eight_queens.entities.figures;

import ru.eight_queens.common.Consntants;
import ru.eight_queens.entities.Cell;
import ru.eight_queens.entities.Field;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 13:14
 * To change this template use File | Settings | File Templates.
 */
public abstract class Figure {
    Field field;
    Cell cell;
    Consntants.FigureTypes figureType;
    Collection<Cell> usedCells;

    private Figure() {};

    public Figure(Field field, Cell cell, Consntants.FigureTypes figureType)
    {
        this.field = field;
        this.cell = cell;
        this.figureType = figureType;
        usedCells = new ArrayList<Cell>();
    }

    public String toString()
    {
        return figureType + usedCells.toString();
    }

    public void addInUsedCells(Cell cell)
    {
        usedCells.add(cell);
    }

    public Field getField() {
        return field;
    }

    public Cell getCell() {
        return cell;
    }

    public Consntants.FigureTypes getFigureType() {
        return figureType;
    }

    public Collection<Cell> getUsedCells() {
        return usedCells;
    }

    public void setUsedCells(Collection<Cell> usedCells) {
        this.usedCells = usedCells;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
