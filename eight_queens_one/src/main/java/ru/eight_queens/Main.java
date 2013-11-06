package ru.eight_queens;

import ru.eight_queens.common.Consntants;
import ru.eight_queens.entities.Field;
import ru.eight_queens.logic.FigureSetter;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 16:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Field field = new Field();

        FigureSetter figureSetter = new FigureSetter();
        figureSetter.setFigureOnField(field, Consntants.FigureTypes.QUEEN);
        System.out.println(field.toString());
    }
}
