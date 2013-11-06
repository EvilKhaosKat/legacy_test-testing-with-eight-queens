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
public interface PositionChooser
{
    //TODO to solve the logical problem need to add list of already chosen variants for that particular figure, maybe save it in figure as it
    //as result we will have full combination of all used position in figure, if there is no any other variants -
    //try to set in another place previous queen
    public Cell getSuitablePosition(Field field);
}
