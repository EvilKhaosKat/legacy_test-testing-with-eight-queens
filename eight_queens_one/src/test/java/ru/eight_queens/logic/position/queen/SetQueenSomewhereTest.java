package ru.eight_queens.logic.position.queen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.eight_queens.common.Consntants;
import ru.eight_queens.entities.Field;
import ru.eight_queens.logic.FigureSetter;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 16:18
 * To change this template use File | Settings | File Templates.
 */
public class SetQueenSomewhereTest extends Assert {
    Field field;

    @Before
    public void createField()
    {
        field = new Field();
    }

    @Test
    public void setQueen() throws Exception
    {
        FigureSetter figureSetter = new FigureSetter();
        figureSetter.setFigureOnField(field, Consntants.FigureTypes.QUEEN);
        System.out.println();
    }
}
