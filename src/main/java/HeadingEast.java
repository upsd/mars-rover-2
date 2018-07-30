public class HeadingEast implements Heading {

    @Override
    public Point move(Point originalPoint) {
        return new Point(originalPoint.x() + 1, originalPoint.y());
    }

    @Override
    public Heading turnLeft() {
        return new HeadingNorth();
    }

    @Override
    public Heading turnRight() {
        return new HeadingSouth();
    }

    @Override
    public String abbreviation() {
        return "E";
    }
}
