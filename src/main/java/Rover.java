public class Rover {

    private Heading heading;

    public Rover(Point point, Heading heading) {

        this.heading = heading;
    }

    public Heading heading() {
        return this.heading;
    }
}
