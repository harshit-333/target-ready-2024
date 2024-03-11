public class CircleCylinder {

    public static class Circle {
        public static final double pi = 3.14;
        private double radius;
        private String color;

        public Circle() {
            radius = 1.0;
            color = "red";
        }

        public Circle (double radius) {
            this.radius = radius;
            color = "red";
        }

        public Circle (double radius, String color) {
            this.radius = radius;
            this.color = color;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius (double radius) {
            this.radius = radius;
        }

        public String getColor() {
            return color;
        }

        public void setColor (String color) {
            this.color = color;
        }

        public double getArea() {
            double r = getRadius();
            return pi*r*r;
        }

        @Override
        public String toString() {
            return "Circle[radius="+getRadius()+", color="+getColor()+"]";
        }
    }

    public static class Cylinder extends Circle {
        private double height;

        public Cylinder() {
            height = 1.0;
        }

        public Cylinder (double radius) {
            setRadius(radius);
            setHeight(1.0);
        }

        public Cylinder (double radius, double height) {
            setRadius(radius);
            setHeight(height);
        }

        public Cylinder (double radius, double height, String color) {
            setRadius(radius);
            setColor(color);
            setHeight(height);
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getVolume() {
            return getArea()*getHeight();
        }
    }

    public static void main(String[] args) {
        Circle[] circles = {
                new Cylinder(12.34),
                new Cylinder(12.34, 10.0),
                new Cylinder(12.34, 10.0, "blue")
        };

        for(int i=0; i<3; i++){
            Cylinder c = (Cylinder) circles[i];
            System.out.println(c);
            System.out.printf("The area of the circular region is %f",c.getArea());
            System.out.println();
            System.out.printf("The volume of cylinder is %f",c.getVolume());
            System.out.println();
            System.out.println();
        }
    }
}