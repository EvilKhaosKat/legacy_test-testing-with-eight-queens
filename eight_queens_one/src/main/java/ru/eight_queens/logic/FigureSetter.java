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

    public boolean setFigureOnField(Field field, Consntants.FigureTypes figureType) throws Exception {
        PositionChooserFactory positionChooserFactory = new PositionChooserFactory();
        PositionChooser positionChooser = positionChooserFactory.createPositionChooser(figureType);
        Cell cell = positionChooser.getSuitablePosition(field);
        if (cell != null)
        {
            setFigureOnChosenCell(field, cell, figureType);
            return true;
        }
        else
        {
            return false;
        }
    }

    private void setFigureOnChosenCell(Field field, Cell cell, Consntants.FigureTypes figureType) throws Exception {
        if (figureType == Consntants.FigureTypes.QUEEN)
        {
            setQueenOnChosenCell(field, cell);
            return;
        }

        throw new WrongFigureTypeException("Figure type "+ figureType + " is not supproted.");
    }

    private void setQueenOnChosenCell(Field field, Cell cell) throws Exception {
        if (cell.getField() != field)
        {
            throw new Exception("Cell not from specified field");
        }

        Figure queen = new Queen(field, cell, Consntants.FigureTypes.QUEEN);
        cell.setFigure(queen);
        field.calculateAttackedCells();
    }
}
