public class Grid {

    private Point point;

    public Grid(Point point) {
        this.point = point;
    }

    public int upperRightX() {
        return this.point.x();
    }

    public int upperRightY() {
        return this.point.y();
    }
}
