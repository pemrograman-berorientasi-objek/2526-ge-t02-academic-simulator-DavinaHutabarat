package academic.model; // Mendefinisikan paket untuk kelas Course

/**
 * @DavinaOlivia 12S24047 Davina Olivia
 * @DavinaOlivia 12S24047 Davina Olivia
 */



public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade; // Nilai huruf

    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Getter methods
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    // Overriding toString method untuk format output
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}
//davina