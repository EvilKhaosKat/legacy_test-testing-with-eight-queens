package ru.eight_queens.logic.position.queen;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.eight_queens.common.Constants;
import ru.eight_queens.entities.Cell;
import ru.eight_queens.entities.Field;
import ru.eight_queens.logic.position_choose.choosers.PositionChooser;
import ru.eight_queens.logic.position_choose.factories.AbstractPositionChooserFactory;
import ru.eight_queens.logic.position_choose.factories.PositionChooserFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 13:56
 * To change this template use File | Settings | File Templates.
 */
public class PositionEmptyField extends Assert {
    Field field;

    @Before
    public void createField()
    {
        field = new Field();
    }

    @Test
    public void chooseFirstSuitablePosition()
    {
        PositionChooserFactory positionChooserFactory = new PositionChooserFactory();
        PositionChooser positionChooser = positionChooserFactory.createPositionChooser(Constants.FigureTypes.QUEEN);
        Cell choosenCell = positionChooser.getSuitablePosition(field);
        assertEquals(0, choosenCell.getColumn());
        assertEquals(0, choosenCell.getRow());
    }

}
