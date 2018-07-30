package upsd.headings;

import upsd.domain.Point;

public class HeadingWest implements Heading {

    @Override
    public Point move(Point originalPoint) {
        return new Point(originalPoint.x() - 1, originalPoint.y());
    }

    @Override
    public Heading turnLeft() {
        return new HeadingSouth();
    }

    @Override
    public Heading turnRight() {
        return new HeadingNorth();
    }

    @Override
    public String abbreviation() {
        return "W";
    }
}
