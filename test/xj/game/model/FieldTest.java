package xj.game.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getSize() {
    final Field field = new Field();
    assertEquals(3, field.getSize());

    }
    @Test
    void setFigure() {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.X;
        field.setFigure(inputPoint,inputFigure);
        final Figure actualFigure = field.getfigure(inputPoint);
        assertEquals(inputFigure,actualFigure);

    }

}