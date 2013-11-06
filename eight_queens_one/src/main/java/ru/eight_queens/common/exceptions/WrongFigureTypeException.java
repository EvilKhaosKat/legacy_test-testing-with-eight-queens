package ru.eight_queens.common.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Fantom
 * Date: 06.11.13
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
public class WrongFigureTypeException extends Exception {
    public WrongFigureTypeException(String msg)
    {
        super(msg);
    }
}
