public interface Heading {

    Point move(Point originalPoint);
    Heading turnLeft();
    Heading turnRight();
    String abbreviation();
}
