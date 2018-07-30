package upsd.domain;

import upsd.headings.Heading;

public class Rover {

    private Point point;
    private Heading heading;

    public Rover(Point point, Heading heading) {
        this.point = point;
        this.heading = heading;
    }

    public Heading heading() {
        return this.heading;
    }

    public int x() {
        return this.point.x();
    }

    public int y() {
        return this.point.y();
    }
}
