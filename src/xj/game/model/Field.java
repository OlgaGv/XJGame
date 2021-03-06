package xj.game.model;


import xj.game.model.exceptions.AlreadyOccupiedException;
import xj.game.model.exceptions.InvalidPointException;
import xj.game.model.exceptions.XJException;

public class Field {

    private static final int FIELD_SIZE=3;
    private static final int MIN_COORDINATE=0;
    private static final int MAXN_COORDINATE=FIELD_SIZE;

    private final Figure[][] field = new Figure [FIELD_SIZE][FIELD_SIZE];

    public int getSize () {
        return FIELD_SIZE;
    }

    public Figure getfigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.getX()][point.getY()];

    }

    public void setFigure(final Point point, final Figure figure) throws AlreadyOccupiedException, InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        if (field[point.getX()][point.getY()] != null) {
            throw new AlreadyOccupiedException();
        }
        field[point.getX()][point.getY()] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.getX()) && checkCoordinate(point.getY());
    }

    private boolean checkCoordinate (final int coordinate) {
        return coordinate >=MIN_COORDINATE && coordinate < MAXN_COORDINATE;

    }

}
