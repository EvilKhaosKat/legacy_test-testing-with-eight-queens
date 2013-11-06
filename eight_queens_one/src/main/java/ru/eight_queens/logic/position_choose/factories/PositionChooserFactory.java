package ru.eight_queens.logic.position_choose.factories;

import static ru.eight_queens.common.Constants.*;
import ru.eight_queens.logic.position_choose.choosers.PositionChooser;
import ru.eight_queens.logic.position_choose.choosers.SerialPositionChooser;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public class PositionChooserFactory extends AbstractPositionChooserFactory {
    @Override
    public PositionChooser createPositionChooser(FigureTypes figureType) {
        return createPositionChooser(figureType, PositionChooserType.SERIAL);
    }

    @Override
    public PositionChooser createPositionChooser(FigureTypes figureType,
                                                 PositionChooserType positionChooserType) {
        if (figureType == FigureTypes.QUEEN)
        {
            if (positionChooserType == PositionChooserType.SERIAL)
            {
                return new SerialPositionChooser();
            }
            else
            {
                throw new UnsupportedOperationException("Only serial chooser for queen figure supported.");
            }
        }
        else
        {
            throw new UnsupportedOperationException("Chooser only for queen figure supported.");
        }
    }
}
