public class Department {
    public static class Person {
        private String name;
        private String address;

        public Person(String name, String address) {
            setName(name);
            setAddress(address);
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Person[name="+getName()+", address="+getAddress()+"]";
        }
    }

    public static class Student extends Person {
        private String program;
        private int year;
        private double fee;

        public Student (String name, String address, String program, int year, double fee) {
            super(name,address);
            setProgram(program);
            setYear(year);
            setFee(fee);
        }

        public String getProgram() {
            return program;
        }

        public void setProgram(String program) {
            this.program = program;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public double getFee() {
            return fee;
        }

        public void setFee(double fee) {
            this.fee = fee;
        }

        @Override
        public String toString() {
            return "Person[name="+getName()+", address="+getAddress()+", program="+getProgram()+", year="+getYear()+", fee="+getFee()+"]";
        }
    }

    public static class Staff extends Person{
        private String school;
        private double pay;

        public Staff (String name, String address, String school, double pay) {
            super(name,address);
            setSchool(school);
            setPay(pay);
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getSchool() {
            return school;
        }

        public void setPay(double pay) {
            this.pay = pay;
        }

        public double getPay() {
            return pay;
        }

        @Override
        public String toString() {
            return "Person[name="+getName()+", address="+getAddress()+", school="+getSchool()+", pay="+getPay()+"]";
        }
    }

    public static void main(String[] args) {
        Person[] people = {
                new Student("Shyam", "Bangalore, Karnataka", "Java fundamentals", 2010, 4500.0),
                new Staff("Anand", "Bangalore, Karnataka", "Delhi Public school", 35000.0),
                new Staff("Umesh", "Bangalore, Karnataka", "National Public school", 42000.0),
                new Student("Suresh", "Hassan, Karnataka", "Java fundamentals", 2012, 4750.0),
                new Student("Kiran", "Vasco, Goa", "ReactJS", 2017, 12500.0)
        };

        for(int i=0; i<5; i++){
            System.out.println(people[i]);
            System.out.println();
        }
    }
}