package ru.eight_queens.entities;

import ru.eight_queens.common.Consntants;

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

    public Field(int rowsCount, int columnsCount)
    {
        this.rowsCount = columnsCount;
        this.columnsCount = rowsCount;

        field = new Cell[rowsCount][columnsCount];

        for (int i = 0; i < rowsCount; i++)
        {
            for (int j = 0; j < columnsCount; j++)
            {
                Cell cell = new Cell(rowsCount, columnsCount, this);
                field[i][j] = cell;
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

    public void calculateAttackedCells()
    {
        for (int row = 0; row < rowsCount; row++)
        {
            for (int column = 0; column < columnsCount; column++)
            {
                Cell cell = field[row][column];
                if (cell.getFigure() != null)
                {

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
                else if (cell.isAttacked())
                {
                    result.append("*");
                }
                else
                {
                    result.append(" ");
                }

            }
            result.append("|");
        }

        return result.toString();
    }
}
