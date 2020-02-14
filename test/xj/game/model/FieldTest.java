package xj.game.model;

import org.junit.jupiter.api.Test;
import xj.game.model.exceptions.AlreadyOccupiedException;
import xj.game.model.exceptions.InvalidPointException;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void testgetSize() {
    final Field field = new Field();
    assertEquals(3, field.getSize());

    }
    @Test
    void testsetFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.X;
        field.setFigure(inputPoint,inputFigure);
        final Figure actualFigure = field.getfigure(inputPoint);
        assertEquals(inputFigure,actualFigure);

    }

    void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure actualFigure = field.getfigure(inputPoint);
        assertNull(actualFigure);

    }

    void testGetFigureWhenXIsLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);
        try {
            field.getfigure(inputPoint);
            fail();
        } catch (final InvalidPointException a) {}

    }
    void testGetFigureWhenYIsLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,-1);
        try {
            field.getfigure(inputPoint);
            fail();
        } catch (final InvalidPointException a) {}

    }
    void testGetFigureWhenXYIsLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,-1);
        try {
            field.getfigure(inputPoint);
            fail();
        } catch (final InvalidPointException a) {}

    }
    void testGetFigureWhenXIsMoreThanFieldSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(5,0);
        try {
            field.getfigure(inputPoint);
            fail();
        } catch (final InvalidPointException a) {}

    }

    void testGetFigureWhenYIsMoreThanFieldSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,5);
        try {
            field.getfigure(inputPoint);
            fail();
        } catch (final InvalidPointException a) {}

    }

    void testGetFigureWhenXYIsMoreThanFieldSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(5,5);
        try {
            field.getfigure(inputPoint);
            fail();
        } catch (final InvalidPointException a) {}

    }

    void testSetFigureWhenAlreadyOccupied() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.X;
        field.setFigure(inputPoint,inputFigure);
        try {
            field.setFigure(inputPoint,inputFigure);
            fail();
        } catch (final AlreadyOccupiedException a) {}

    }
}