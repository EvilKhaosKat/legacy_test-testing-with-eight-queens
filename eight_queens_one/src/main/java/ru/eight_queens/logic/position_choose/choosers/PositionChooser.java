package ru.eight_queens.logic.position_choose.choosers;

import ru.eight_queens.entities.Cell;
import ru.eight_queens.entities.Field;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 14:01
 * To change this template use File | Settings | File Templates.
 */
public interface PositionChooser {
    public Cell getSuitablePosition(Field field);
}
