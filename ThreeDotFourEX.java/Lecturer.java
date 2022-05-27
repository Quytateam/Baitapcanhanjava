import java.util.ArrayList;
import java.util.List;

public abstract class Lecturer {
    protected String id, fullName, InstructorQualifications;
    protected int birthYear;
    protected int numberOfYearsOfService;
    protected List<Subject> subjectsList;

    public Lecturer() {
        subjectsList = new ArrayList<Subject>();
    }

    public Lecturer(String id, String fullName, int birthYear, String InstructorQualifications,
            int numberOfYearsOfService, List<Subject> subjectsList) {
        this.id = id;
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.InstructorQualifications = InstructorQualifications;
        this.numberOfYearsOfService = numberOfYearsOfService;
        this.subjectsList = subjectsList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getInstructorQualifications() {
        return InstructorQualifications;
    }

    public void setInstructorQualifications(String InstructorQualifications) {
        this.InstructorQualifications = InstructorQualifications;
    }

    public int getnumberOfYearsOfService() {
        return numberOfYearsOfService;
    }

    public void setnumberOfYearsOfService(int numberOfYearsOfService) {
        this.numberOfYearsOfService = numberOfYearsOfService;
    }

    // Tra ve string ds mon hoc
    public String[] getSubjectsList() {
        String arr[] = new String[subjectsList.size()];
        subjectsList.toArray(arr);
        return arr;
    }

    // Hien thi thong tin
    public abstract void display();

    // Them mot Mon Hoc vao danh sach cac mon hoc
    public void addSubject(Subject a) {
        this.subjectsList.add(a);
    }

    // Them vao danh sach cac mon hoc
    public void addSubjectsList(List<Subject> subjectsList) {
        this.subjectsList.addAll(subjectsList);
    }

    // Kiem tra GVCH tren 50 tuoi
    public abstract boolean PL_50();

    // Kiem tra co la Giang Vien Thinh Giang hay khong
    public abstract boolean isVisitingLecturer();

    // Kiem tra hai giang vien cung loai va nam cong tac
    public boolean lecturersOfTheSameType(Lecturer a) {
        if (this.isVisitingLecturer() && a.isVisitingLecturer()
                || !this.isVisitingLecturer() && !a.isVisitingLecturer()) {
            if (this.numberOfYearsOfService == a.numberOfYearsOfService)
                return true;
            else
                return false;
        }
        return false;
    }
}
