package ru.eight_queens.logic;

import ru.eight_queens.common.Consntants;
import ru.eight_queens.common.exceptions.WrongFigureTypeException;
import ru.eight_queens.entities.Cell;
import ru.eight_queens.entities.Field;
import ru.eight_queens.entities.figures.Figure;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 16:02
 */
public class AttackedCellsCalculator {
    public static Field calculateAttackedCells(Field field, Cell cell) throws WrongFigureTypeException {
        Figure figure = cell.getFigure();
        Consntants.FigureTypes figureType = figure.getFigureType();

        if (figureType == Consntants.FigureTypes.QUEEN)
        {
            setAttackedByQueenCells(field, cell);
        }
        else
        {
            throw new WrongFigureTypeException("AttackedCellsCalculator. Figure type "+figureType+" is not supported.");
        }

        return field;
    }

    private static Collection<Cell> setAttackedByQueenCells(Field field, Cell cell) {
        Collection<Cell> attackedCells = new ArrayList<Cell>();

        int row = cell.getRow();
        int column = cell.getColumn();

        setAttackedRow(field, row);
        setAttackedColumn(field, column);

        return attackedCells;
    }

    private static void setAttackedColumn(Field field, int column) {
        for (int row = 0; row < field.getColumnsCount(); row++)
        {
            field.getCell(row, column).setAttacked(true);
        }
    }

    private static void setAttackedRow(Field field, int row) {
        for (int column = 0; column < field.getColumnsCount(); column++)
        {
            field.getCell(row, column).setAttacked(true);
        }
    }
}
