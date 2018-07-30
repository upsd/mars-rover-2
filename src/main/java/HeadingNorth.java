public class HeadingNorth implements Heading {

    @Override
    public Point move(Point point) {
        return new Point(point.x(), point.y() + 1);
    }

    @Override
    public Heading turnLeft() {
        return new HeadingWest();
    }

    @Override
    public Heading turnRight() {
        return new HeadingEast();
    }

    @Override
    public String abbreviation() {
        return "N";
    }
}
