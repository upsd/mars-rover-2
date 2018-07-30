package upsd.headings;

import upsd.domain.Point;

public interface Heading {

    Point move(Point originalPoint);
    Heading turnLeft();
    Heading turnRight();
    String abbreviation();
}
