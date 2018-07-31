package upsd.domain;

import upsd.headings.Heading;

public class Rover {

    private Point point;
    private Heading heading;
    private Grid grid;

    public Rover(Point point, Heading heading, Grid grid) {
        this.point = point;
        this.heading = heading;
        this.grid = grid;
    }

    public int x() {
        return this.point.x();
    }

    public int y() {
        return this.point.y();
    }

    public void turnLeft() {
        this.heading = this.heading.turnLeft();
    }

    public void turnRight() {
        this.heading = this.heading.turnRight();
    }

    public void move() {
        this.point = this.grid.sanitisePoint(this.heading.move(this.point));
    }

    public String headingAbbreviation() {
        return this.heading.abbreviation();
    }
}
