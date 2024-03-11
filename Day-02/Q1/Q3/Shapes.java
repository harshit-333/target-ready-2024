public class Shapes {

    public static class Shape {
        private String color;
        private boolean filled;

        public Shape() {
            this.color = "red";
            this.filled = true;
        }

        public Shape(String color, boolean filled) {
            this.color = color;
            this.filled = filled;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isFilled() {
            return filled;
        }

        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        @Override
        public String toString() {
            String str = "A Shape with color of "+this.getColor()+" and ";

            if(this.isFilled()){
                str += "filled";
            } else{
                str+="Not filled";
            }
            return str;
        }
    }

    public static class Circle extends Shape {
        static final double pi = 3.14;
        double radius;

        public Circle() {
            this.radius = 1.0;
        }

        public Circle(double radius) {
            this.radius = radius;
        }

        public Circle(double radius, String color, boolean filled) {
            this.setRadius(radius);
            this.setColor(color);
            this.setFilled(filled);
        }

        public double getRadius() {
            return this.radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public double getArea() {
            double radius = this.getRadius();
            return pi*radius*radius;
        }

        public double getPerimeter() {
            double radius = this.getRadius();
            return 2*pi*radius;
        }

        @Override
        public String toString() {
            return "A Circle of radius="+this.getRadius()+", which is a subclass of "+super.toString();
        }
    }

    public static class Rectangle extends Shape {
        private double length;
        private double width;

        public Rectangle() {
            this.length = 1.0;
            this.width = 1.0;
        }

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public Rectangle(double length, double width, String color, boolean filled) {
            this.length = length;
            this.width = width;
            this.setColor(color);
            this.setFilled(filled);
        }

        public double getWidth() {
            return this.width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getLength() {
            return this.length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public double getArea() {
            double length = this.getLength();
            double width = this.getWidth();
            return length*width;
        }

        public double getPerimeter() {
            double length = getLength();
            double width = getWidth();
            return 2*(length+width);
        }

        @Override
        public String toString() {
            return "A Rectangle with width="+this.width+" and length="+this.length+", which is a subclass of "+super.toString();
        }
    }

    public static class Square extends Rectangle {

        public Square() {
            this.setWidth(1.0);
            this.setLength(1.0);
        }

        public Square(double side) {
            this.setWidth(side);
            this.setLength(side);
        }

        public Square(double side, String color, boolean filled) {
            this.setSide(side);
            this.setColor(color);
            this.setFilled(filled);
        }

        public double getSide() {
            return getLength();
        }

        public void setSide(double side) {
            setLength(side);
            setWidth(side);
        }

        @Override
        public void setWidth(double side) {
            super.setWidth(side);
            super.setLength(side);
        }

        @Override
        public void setLength(double side) {
            super.setLength(side);
            super.setWidth(side);
        }

        @Override
        public String toString() {
            return "A Square with side="+this.getSide()+", which is a subclass of "+super.toString();
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Shape("Orange",true),
                new Rectangle(2.0,3.0),
                new Circle(7.0,"Blue",true),
                new Square(5.4),
                new Rectangle(),
                new Circle(3.14),
                new Rectangle(2.5,3.5,"Green",false),
                new Square(),
                new Circle(),
                new Rectangle(5,7),
                new Square(10,"Pink",true)
        };

        for (Shape shape : shapes) {
            switch (shape) {
                case Square s -> {
                    System.out.printf("Perimeter of the Square is = %f", s.getPerimeter());
                    System.out.println();
                    System.out.printf("Area of the Square is = %f", s.getArea());
                    System.out.println();
                    System.out.println(s);
                }
                case Rectangle r -> {
                    System.out.printf("Perimeter of the Rectangle is = %f", r.getPerimeter());
                    System.out.println();
                    System.out.printf("Area of the Rectangle is = %f", r.getArea());
                    System.out.println();
                    System.out.println(r);
                }
                case Circle c -> {
                    System.out.printf("Perimeter of the Circle is = %f", c.getPerimeter());
                    System.out.println();
                    System.out.printf("Area of the Circle is = %f", c.getArea());
                    System.out.println();
                    System.out.println(c);
                }
                case Shape sh ->
                    System.out.println(sh);
            }
            System.out.println();
        }
    }
}