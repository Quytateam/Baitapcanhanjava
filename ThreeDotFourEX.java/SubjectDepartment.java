import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SubjectDepartment {
    private String name;
    private List<Lecturer> lecturersList;

    public SubjectDepartment() {
        lecturersList = new ArrayList<Lecturer>();
    }

    public SubjectDepartment(String name, List<Lecturer> lecturersList) {
        this.name = name;
        this.lecturersList = lecturersList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Them danh sach cac giang vien
    public void addLecturer(List<Lecturer> lecturersList) {
        this.lecturersList.addAll(lecturersList);
    }

    // Them vao mot giang vien
    public void addLecturer(Lecturer a) {
        this.lecturersList.add(a);
    }

    // Get ds giang vien
    public List<Lecturer> getLecturerList() {
        return lecturersList;
    }

    // Tong so giang vien co huu cua bo mon co nam sinh truoc 1990
    public int PrimaryLecturer_1990() {
        int count = 0;
        for (int i = 0; i < lecturersList.size(); i++) {
            if (lecturersList.get(i).birthYear < 1990)
                count++;
        }
        return count;
    }

    // Giang vien co huu lon tuoi nhat
    public Lecturer maxYearOfPrimaryLecturer() {
        int minYear = lecturersList.get(0).birthYear;
        int index = 0;
        for (int i = 1; i < lecturersList.size(); i++) {
            if (lecturersList.get(i).birthYear < minYear) {
                minYear = lecturersList.get(i).birthYear;
                index = i;
            }
        }
        return lecturersList.get(index);
    }

    // Tim giang vien
    public boolean searchByName(String ten) {
        for (Lecturer t : lecturersList) {
            if (t.getFullName() == ten) {
                return true;
            }
        }
        return false;
    }

    // Lay ra danh sach giang vien thinh giang tu nam sinh
    public List<Lecturer> searchByBirthYear() {
        int namSinh;
        List<Lecturer> t = new ArrayList<Lecturer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap nam can tim: ");
        namSinh = sc.nextInt();
        for (int i = 0; i < lecturersList.size(); i++) {
            if (lecturersList.get(i).isVisitingLecturer()) {
                if (lecturersList.get(i).birthYear == namSinh) {
                    t.add(lecturersList.get(i));
                }
            }
        }
        return t;
    }

    // sap xep cac giang vien tang dan theo ho ten
    public void sortByYear() {
        Collections.sort(lecturersList, new Comparator<Lecturer>() {
            public int compare(Lecturer a, Lecturer b) {
                return b.getBirthYear() - a.getBirthYear();
            }
        });
    }

    // sap xep cac giang vien giam dan theo nam sinh
    public void sortByName() {
        Collections.sort(lecturersList, new Comparator<Lecturer>() {
            public int compare(Lecturer a, Lecturer b) {
                return a.getFullName().compareTo(b.getFullName());
            }
        });
    }

    // thong ke so luong giang vien cua bo mon theo nam sinh
    public Map<Integer, Integer> thongKeNamSinh() {
        Map<Integer, Integer> list = new HashMap<>();
        for (Lecturer i : lecturersList) {
            if (!list.containsKey(i.getBirthYear())) {
                list.put(i.getBirthYear(), 1);
            } else
                list.put(i.getBirthYear(), list.get(i.getBirthYear()) + 1);
        }
        return list;
    }
}
