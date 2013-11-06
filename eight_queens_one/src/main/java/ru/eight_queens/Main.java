package ru.eight_queens;

import ru.eight_queens.common.Consntants;
import ru.eight_queens.entities.Cell;
import ru.eight_queens.entities.Field;
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
        recursiveFinding(field, 6);
//        FigureSetter figureSetter = new FigureSetter();
//        figureSetter.setFigureOnField(field, Consntants.FigureTypes.QUEEN);
//        figureSetter.setFigureOnField(field, Consntants.FigureTypes.QUEEN);
//        figureSetter.setFigureOnField(field, Consntants.FigureTypes.QUEEN);
    }

    public static void recursiveFinding(Field field, int countOfQueens) throws Exception {

        if (countOfQueens<1)
        {
            System.out.println("-----FINAL FIELD----");
            System.out.println(field);
            System.out.println("Calculation ended");
            return;
        }

        System.out.println("-----FIELD----");
        System.out.println(field);

        Stack<Cell> queensCellsStack = new Stack<Cell>();

        FigureSetter figureSetter = new FigureSetter();
        Cell cell = figureSetter.setFigureOnField(field, Consntants.FigureTypes.QUEEN);
        if (cell != null)
        {
            queensCellsStack.push(cell);
        }
        else
        {
            if (!queensCellsStack.isEmpty())
            {
                Cell restrictedCell = queensCellsStack.pop();
                restrictedCell.setFigure(null);
                field.calculateAttackedCells();
                recursiveFinding(field, countOfQueens);
            }
        }

        countOfQueens--;
        recursiveFinding(field, countOfQueens);
    }
}
