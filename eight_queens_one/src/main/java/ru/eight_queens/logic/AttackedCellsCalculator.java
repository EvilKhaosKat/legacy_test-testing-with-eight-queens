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
        setAttackedDiagonals(field, cell);

        return attackedCells;
    }

    //TODO rewrite realization of method, this variant is not optimal
    private static void setAttackedDiagonals(Field field, Cell cell) {
        int queenRow = cell.getRow();
        int queenColumn = cell.getColumn();

        setUpperLeftDiagonal(field, queenRow, queenColumn);
        setUpperRightDiagonal(field, queenRow, queenColumn);
        setDownLeftDiagonal(field, queenRow, queenColumn);
        setDownRightDiagonal(field, queenRow, queenColumn);
    }

    private static void setDownRightDiagonal(Field field, int queenRow, int queenColumn)
    {
        int column = queenColumn;
        for (int row = queenRow; row < field.getRowsCount(); row++)
        {
            field.getCell(row, column).setAttacked(true);
            column++;
            if (column >= field.getColumnsCount()) return;
        }
    }

    private static void setDownLeftDiagonal(Field field, int queenRow, int queenColumn)
    {
        int column = queenColumn;
        for (int row = queenRow; row < field.getRowsCount(); row++)
        {
            field.getCell(row, column).setAttacked(true);
            column--;
            if (column < 0) return;
        }
    }

    private static void setUpperRightDiagonal(Field field, int queenRow, int queenColumn) {
        int column = queenColumn;
        for (int row = queenRow; row > 0; row--)
        {
            field.getCell(row, column).setAttacked(true);
            column++;
            if (column >= field.getColumnsCount()) return;
        }
    }

    private static void setUpperLeftDiagonal(Field field, int queenRow, int queenColumn) {
        int column = queenColumn;
        for (int row = queenRow; row > 0; row--)
        {
            field.getCell(row, column).setAttacked(true);
            column--;
            if (column < 0) return;
        }
    }

    private static void setAttackedRow(Field field, int row) {
        for (int column = 0; column < field.getColumnsCount(); column++)
        {
            field.getCell(row, column).setAttacked(true);
        }
    }

    private static void setAttackedColumn(Field field, int column) {
        for (int row = 0; row < field.getRowsCount(); row++)
        {
            field.getCell(row, column).setAttacked(true);
        }
    }
}
