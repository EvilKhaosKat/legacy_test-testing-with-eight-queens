package ru.eight_queens.entities.figures;

import ru.eight_queens.common.Consntants;
import ru.eight_queens.entities.Cell;
import ru.eight_queens.entities.Field;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 13:17
 * To change this template use File | Settings | File Templates.
 */
public class Queen extends Figure {
    public Queen(Field field, Cell cell, Consntants.FigureTypes figureType)
    {
        super(field, cell, figureType);
    }
}
