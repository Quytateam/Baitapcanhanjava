import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Subject> ac = new ArrayList<Subject>();
        Subject a = new Subject("Toan", 2);
        Subject b = new Subject("Ly", 2);
        Subject c = new Subject("Anh", 3);
        ac.add(a);
        ac.add(b);
        ac.add(c);

        ArrayList<Lecturer> lecturersList = new ArrayList<Lecturer>();
        ArrayList<Lecturer> lecturersList1 = new ArrayList<Lecturer>();

        Lecturer gv1 = new VisitingLecturer("001", "Mai Dang Dũng", 1990, "Tien si", 3, ac, "Phu Yen");
        Lecturer gv2 = new VisitingLecturer("002", "Nguyen Van Binh", 1995, "Tien si", 3, ac, "HCM");
        Lecturer gv3 = new VisitingLecturer("003", "Nguyen Van Tan", 1992, "Tien si", 3, ac, "Ha Noi");
        Lecturer gv4 = new PrimaryLecturer("004", "Nguyen Văn kí", 1992, "Tien si", 3, ac, 2.3, 2000);
        Lecturer gv5 = new PrimaryLecturer("005", "Nguyen Ngoc Anh", 1990, "Tien si", 3, ac, 2.3, 2007);
        Lecturer gv6 = new PrimaryLecturer("006", "Nguyen Thuy Van", 1990, "Tien si", 3, ac, 2.3, 2005);

        Lecturer gv7 = new VisitingLecturer("007", "Trương Ngọc Mai", 1995, "Tien si", 3, ac, "Phu Yen");
        Lecturer gv8 = new VisitingLecturer("008", "Nguyen Hai Binh", 1992, "Tien si", 3, ac, "Ninh Binh");
        Lecturer gv9 = new VisitingLecturer("009", "Nguyen Van Khoi", 1991, "Tien si", 3, ac, "Quang Nam");
        Lecturer gv10 = new PrimaryLecturer("0010", "Nguyen Thi Van", 1996, "Tien si", 3, ac, 2.3, 2000);
        Lecturer gv11 = new PrimaryLecturer("0011", "Nguyen Ngoc Le", 1999, "Tien si", 3, ac, 2.3, 2007);
        Lecturer gv12 = new PrimaryLecturer("0012", "Nguyen Thuy Anh", 1990, "Tien si", 3, ac, 2.3, 2005);

        lecturersList.add(gv1);
        lecturersList.add(gv2);
        lecturersList.add(gv3);
        lecturersList.add(gv4);
        lecturersList.add(gv5);
        lecturersList.add(gv6);

        lecturersList1.add(gv7);
        lecturersList1.add(gv8);
        lecturersList1.add(gv9);
        lecturersList1.add(gv10);
        lecturersList1.add(gv11);
        lecturersList1.add(gv12);

        SubjectDepartment a1 = new SubjectDepartment("CNTT", lecturersList);
        SubjectDepartment a2 = new SubjectDepartment("KTVT", lecturersList1);
        ArrayList<SubjectDepartment> subjectDepartmentsList = new ArrayList<SubjectDepartment>();
        subjectDepartmentsList.add(a1);
        subjectDepartmentsList.add(a2);

        SubjectDepartmentList t = new SubjectDepartmentList(subjectDepartmentsList, lecturersList, ac);
        t.createGUI();
    }
}