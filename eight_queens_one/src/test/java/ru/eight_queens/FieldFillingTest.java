package ru.eight_queens;

import junit.framework.Assert;
import org.junit.Before;
import ru.eight_queens.entities.Field;


/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 12:59
 *
 * That test is so useless.
 */
public class FieldFillingTest extends Assert {
    private Field defaultField;
//    private static Field customField;

    @Before
    public void createField()
    {
        defaultField = new Field();
//        customField = new Field();
    }

    @org.junit.Test
    public void checkFieldSize()
    {
        int length = defaultField.getField().length;
        assertEquals(8, length);
    }
}
