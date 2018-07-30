package upsd.domain;

public class Grid {

    private final int MAX_Y;
    private final int MAX_X;
    private static final int MIN_Y = 1;
    private static final int MIN_X = 1;

    public Grid(Point point) {
        this.MAX_Y = point.y();
        this.MAX_X = point.x();
    }

    public Point sanitisePoint(Point pointToValidate) {
        int x = validateXCoordinate(pointToValidate.x());
        int y = validateYCoordinate(pointToValidate.y());

        return new Point(x, y);
    }

    private int validateXCoordinate(int coordinate) {
        if (coordinate < MIN_X) {
            return MAX_X;
        }

        if (coordinate > MAX_X) {
            return MIN_X;
        }

        return coordinate;
    }

    private int validateYCoordinate(int coordinate) {
        if (coordinate < MIN_Y) {
            return MAX_Y;
        }

        if (coordinate > MAX_Y) {
            return MIN_Y;
        }

        return coordinate;
    }
}
