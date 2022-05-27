import java.util.List;

public class VisitingLecturer extends Lecturer {
    private String workPlace;

    public VisitingLecturer() {
    }

    public VisitingLecturer(String id, String fullName, int birthYear,
            String InstructorQualifications,
            int numberOfYearsOfService, List<Subject> subjectsList, String workPlace) {
        super(id, fullName, birthYear, InstructorQualifications, numberOfYearsOfService, subjectsList);
        this.workPlace = workPlace;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void serWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public boolean PL_50() {
        return false;
    }

    public boolean isVisitingLecturer() {
        return true;
    }

    public void display() {
        System.out
                .println(id + fullName + " " + birthYear + " " + InstructorQualifications + " " + numberOfYearsOfService
                        + " " + workPlace);
    }
}
