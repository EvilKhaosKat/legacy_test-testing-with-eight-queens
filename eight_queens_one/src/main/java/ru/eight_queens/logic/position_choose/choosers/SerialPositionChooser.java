package ru.eight_queens.logic.position_choose.choosers;

import ru.eight_queens.entities.Cell;
import ru.eight_queens.entities.Field;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 14:07
 */
public class SerialPositionChooser implements PositionChooser {
    /**
     * That method returns first suitable, free, non under attack cell on the field.
     * @param field where we try to find position for queen placing
     * @return cell of field that is suitable for using
     */
    @Override
    public Cell getSuitablePosition(Field field) {
        if (field != null)
        {
            int rowsCount = field.getRowsCount();
            int columnsCount = field.getColumnsCount();

            for (int row = 0; row < rowsCount; row++)
            {
                for (int column = 0; column < columnsCount; column++)
                {
                    Cell cell = field.getCell(row, column);
                    if (cell.canBeUsed())
                    {
                        return cell;
                    }
                }
            }

        }

        return null;
    }

}
