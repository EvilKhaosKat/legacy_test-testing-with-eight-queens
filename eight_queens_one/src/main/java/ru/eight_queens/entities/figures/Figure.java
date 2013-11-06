package ru.eight_queens.entities.figures;

import ru.eight_queens.common.Consntants;
import ru.eight_queens.entities.Cell;
import ru.eight_queens.entities.Field;

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

    private Figure() {};

    public Figure(Field field, Cell cell, Consntants.FigureTypes figureType)
    {
        this.field = field;
        this.cell = cell;
        this.figureType = figureType;
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
}
