package ru.eight_queens.logic;

import ru.eight_queens.common.Consntants;
import ru.eight_queens.common.exceptions.WrongFigureTypeException;
import ru.eight_queens.entities.Cell;
import ru.eight_queens.entities.Field;
import ru.eight_queens.entities.figures.Figure;
import ru.eight_queens.entities.figures.Queen;
import ru.eight_queens.logic.position_choose.choosers.PositionChooser;
import ru.eight_queens.logic.position_choose.factories.PositionChooserFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
public class FigureSetter {

    public Figure setFigureOnField(Field field, Consntants.FigureTypes figureType, Figure figure) throws Exception {
        if (figureType == Consntants.FigureTypes.QUEEN)
        {
            Figure queen = figure == null ? new Queen(field, null, Consntants.FigureTypes.QUEEN) : figure;
            PositionChooserFactory positionChooserFactory = new PositionChooserFactory();
            PositionChooser positionChooser = positionChooserFactory.createPositionChooser(figureType);
            Cell cell = positionChooser.getSuitablePosition(field, queen);
            if (cell != null)
            {
                setQueenOnChosenCell(field, cell, queen);
                return queen;
            }
            else
            {
                return null;
            }
        }

        throw new WrongFigureTypeException("Figure type "+ figureType + " is not supproted.");
    }

    private void setQueenOnChosenCell(Field field, Cell cell, Figure queen) throws Exception {
        if (cell.getField() != field)
        {
            throw new Exception("Cell not from specified field");
        }

        cell.setFigure(queen);
        queen.setCell(cell);
//        cell.setRestrictedForUsing(true);
        cell.setAttacked(true);
        queen.addInUsedCells(cell);
        field.calculateAttackedCells();
    }
}
