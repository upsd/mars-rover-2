public class HeadingSouth implements Heading {

    @Override
    public Point move(Point originalPoint) {
        return new Point(originalPoint.x(), originalPoint.y() - 1);
    }

    @Override
    public Heading turnLeft() {
        return new HeadingEast();
    }

    @Override
    public Heading turnRight() {
        return new HeadingWest();
    }

    @Override
    public String abbreviation() {
        return "S";
    }
}
