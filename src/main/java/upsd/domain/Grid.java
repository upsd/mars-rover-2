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
        int x = validateCoordinate(MIN_X, MAX_X, pointToValidate.x());
        int y = validateCoordinate(MIN_Y, MAX_Y, pointToValidate.y());

        return new Point(x, y);
    }

    private int validateCoordinate(int minCoordinate, int maxCoordinate, int coordinateToValidate) {
        if (coordinateToValidate < minCoordinate) {
            return maxCoordinate;
        }

        if (coordinateToValidate > maxCoordinate) {
            return minCoordinate;
        }

        return coordinateToValidate;
    }
}
