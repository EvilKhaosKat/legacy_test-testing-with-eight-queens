package ru.eight_queens.logic.position_choose.factories;

import ru.eight_queens.common.Constants;
import ru.eight_queens.logic.position_choose.choosers.PositionChooser;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 14:01
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractPositionChooserFactory {
    public abstract PositionChooser createPositionChooser(Constants.FigureTypes figureType);
    public abstract PositionChooser createPositionChooser(Constants.FigureTypes figureType,
                                                          Constants.PositionChooserType positionChooserType);
}
