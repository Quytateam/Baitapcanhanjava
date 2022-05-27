import java.util.List;
import java.util.Calendar;

public class PrimaryLecturer extends Lecturer {
    private double coefficientsSalary;
    private int workYear;

    public PrimaryLecturer() {
    }

    public PrimaryLecturer(String id, String fullName, int birthYear,
            String InstructorQualifications,
            int numberOfYearsOfService, List<Subject> subjectsList, double coefficientsSalary,
            int workYear) {
        super(id, fullName, birthYear, InstructorQualifications, numberOfYearsOfService, subjectsList);
        this.coefficientsSalary = coefficientsSalary;
        this.workYear = workYear;
    }

    public PrimaryLecturer(double coefficientsSalary, int workYear) {
        this.coefficientsSalary = coefficientsSalary;
        this.workYear = workYear;
    }

    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(int coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    public int getWorkYear() {
        return workYear;
    }

    public void setWorkYear(int workYear) {
        this.workYear = workYear;
    }

    // kiểm tra giảng viên là cơ hữu và trên 50 tuổi hay không (tính đến năm 2021)
    public boolean PL_50() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (currentYear - birthYear > 50)
            return true;
        return false;

    }

    public boolean isVisitingLecturer() {
        return false;
    }

    public void display() {
        System.out
                .println(id + fullName + " " + birthYear + " " + InstructorQualifications + " " + numberOfYearsOfService
                        + " " + coefficientsSalary + " " + workYear);

    }
}
