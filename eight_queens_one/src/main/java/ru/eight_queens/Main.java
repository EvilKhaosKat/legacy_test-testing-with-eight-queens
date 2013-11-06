package ru.eight_queens;

import ru.eight_queens.common.Consntants;
import ru.eight_queens.entities.Cell;
import ru.eight_queens.entities.Field;
import ru.eight_queens.entities.figures.Figure;
import ru.eight_queens.logic.FigureSetter;

import java.util.Stack;

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
//        field.getCell(0,0).setRestrictedForUsing(true);
        recursiveFinding(field, 8, null, null);
//        FigureSetter figureSetter = new FigureSetter();
//        figureSetter.setFigureOnField(field, Consntants.FigureTypes.QUEEN);
//        figureSetter.setFigureOnField(field, Consntants.FigureTypes.QUEEN);
//        figureSetter.setFigureOnField(field, Consntants.FigureTypes.QUEEN);
    }

    public static boolean recursiveFinding(Field field, int countOfQueens, Figure currentFigure, Figure previousLevelFigure) throws Exception {
        if (countOfQueens<1)
        {
            System.out.println("-----FINAL FIELD----");
            System.out.println(field);
            System.out.println("Calculation ended");
            return true;
        }

        FigureSetter figureSetter = new FigureSetter();
        Cell oldCell = null;
        if (previousLevelFigure != null)
        {
            oldCell = previousLevelFigure.getCell();
            System.out.println("old cell ="+oldCell);
        }

        System.out.println("currentFigure = "+currentFigure);

        Figure figureAfterSetting = figureSetter.setFigureOnField(field, Consntants.FigureTypes.QUEEN, currentFigure);
        if (figureAfterSetting == null)
        {
            System.out.println("figureAfterSetting is null");
//                restrictedCell.setRestrictedForUsing(true);
            if (oldCell != null )
            {
                oldCell.setFigure(null);
                previousLevelFigure.setCell(null);
            }
            field.calculateAttackedCells();
            System.out.println("field after deleting from current cell");
            System.out.println(field);
                //recursiveFinding(field, countOfQueens, currentFigure, null);
            System.out.println("figure not found on that level, returning false");
            return false;
        }
        System.out.println("used cells for figure "+figureAfterSetting);


        System.out.println("-----FIELD----");
        System.out.println(field);

        System.out.println("countOfQueens = "+countOfQueens);

        countOfQueens--;
        boolean lowLevelSuccessful = recursiveFinding(field, countOfQueens, null, figureAfterSetting);
        if (lowLevelSuccessful)
        {
            System.out.println("low level successfull");
            return true;
        }
        else
        {
            countOfQueens++;
            System.out.println("low level not successfull");
            boolean  currentLevelSuccessfull = recursiveFinding(field, countOfQueens, figureAfterSetting, previousLevelFigure);
            System.out.println("try to get another place for figure."+figureAfterSetting);
            if (currentLevelSuccessfull)
            {
                return true;

            }
            else
            {
                return false;
            }
        }

    }
}
