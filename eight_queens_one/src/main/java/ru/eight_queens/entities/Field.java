package ru.eight_queens.entities;

import ru.eight_queens.common.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 13:02
 * To change this template use File | Settings | File Templates.
 */
public class Field {
    private Cell[][] field;

    public Field()
    {
        this(Constants.DEFAULT_ROWS_COUNT, Constants.DEFAULT_COLUMNS_COUNT);
    }

    public Field(int x, int y)
    {
        field = new Cell[x][y];

        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                Cell cell = new Cell(x, y, this);
                field[i][j] = cell;
            }
        }
    }

    public Cell[][] getField() {
        return field;
    }
}
