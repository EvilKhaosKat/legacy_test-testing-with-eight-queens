package ru.eight_queens.entities;

import ru.eight_queens.common.Consntants;
import ru.eight_queens.common.exceptions.WrongFigureTypeException;
import ru.eight_queens.logic.AttackedCellsCalculator;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 13:02
 * To change this template use File | Settings | File Templates.
 */
public class Field {
    private Cell[][] field;
    private int rowsCount;
    private int columnsCount;

    public Field()
    {
        this(Consntants.DEFAULT_ROWS_COUNT, Consntants.DEFAULT_COLUMNS_COUNT);
    }

    //TODO that walking through all cells of field to be generalized, because of it's same part of code in few methods
    public Field(int rowsCount, int columnsCount)
    {
        this.rowsCount = columnsCount;
        this.columnsCount = rowsCount;

        field = new Cell[rowsCount][columnsCount];

        for (int row = 0; row < rowsCount; row++)
        {
            for (int column = 0; column < columnsCount; column++)
            {
                Cell cell = new Cell(row, column, this);
                field[row][column] = cell;
            }
        }
    }

    @Deprecated
    public Cell[][] getField() {
        return field;
    }

    public Cell getCell(int row, int column)
    {
        return field[row][column];
    }

    public int getRowsCount() {
        return rowsCount;
    }

    public int getColumnsCount() {
        return columnsCount;
    }

    public void calculateAttackedCells() throws WrongFigureTypeException {
        resetAttackedStatus();
        for (int row = 0; row < rowsCount; row++)
        {
            for (int column = 0; column < columnsCount; column++)
            {
                Cell cell = field[row][column];
                if (cell.getFigure() != null)
                {
                    AttackedCellsCalculator.calculateAttackedCells(this, cell);
                }
            }
        }

    }

    private void resetAttackedStatus()
    {
        for (int row = 0; row < rowsCount; row++)
        {
            for (int column = 0; column < columnsCount; column++)
            {
                Cell cell = field[row][column];
                cell.setAttacked(false);
            }
        }
    }

    public void clean(boolean restrictionReset)
    {
        for (int row = 0; row < rowsCount; row++)
        {
            for (int column = 0; column < columnsCount; column++)
            {
                Cell cell = field[row][column];
                cell.setAttacked(false);
                cell.setFigure(null);
                if (restrictionReset)
                {
                    cell.setRestrictedForUsing(false);
                }
            }
        }
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();

        for (int row = 0; row < rowsCount; row++)
        {
            for (int column = 0; column < columnsCount; column++)
            {
                Cell cell = field[row][column];
                if (cell.getFigure() != null)
                {
                    result.append("Q");
                }
                else if (cell.isRestrictedForUsing())
                {
                    result.append("r");
                }
                else if (cell.isAttacked())
                {
                    result.append("*");
                }
                else
                {
                    result.append(" ");
                }

            }
            result.append("|\n");
        }

        return result.toString();
    }
}
