import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectDepartmentList {
    private ArrayList<SubjectDepartment> subjectDepartmentsList;
    ArrayList<Lecturer> lecturersList;
    ArrayList<Subject> subjectsList;

    public SubjectDepartmentList() {
        subjectDepartmentsList = new ArrayList<>();
        lecturersList = new ArrayList<>();
        subjectsList = new ArrayList<>();
    }

    public SubjectDepartmentList(ArrayList<SubjectDepartment> subjectDepartmentsList,
            ArrayList<Lecturer> lecturersList, ArrayList<Subject> subjectsList) {
        this.subjectDepartmentsList = subjectDepartmentsList;
        this.lecturersList = lecturersList;
        this.subjectsList = subjectsList;
    }

    // Get ds bo mon
    public ArrayList<SubjectDepartment> getSubjectDepartment() {
        return subjectDepartmentsList;
    }

    // Tìm xem giảng viên có tên cho trước có công tác ở bộ môn hay không?
    public void searchNameBySD(String tenBM, String ten) {
        for (SubjectDepartment t : subjectDepartmentsList) {
            if (t.getName() == tenBM && t.searchByName(ten) == true) {
                System.out.println("Có giảng viên công tác ở đây");
                break;
            } else {
                System.out.println("Không có gaingr viên công tác ở đây");
                break;
            }
        }
    }

    public void createGUI() {
        JFrame f;
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("DANH SÁCH GIẢNG VIÊN");

        // title table
        JLabel jLabel1 = new JLabel("GIẢNG VIÊN CỐ HỮU");
        JLabel jLabel2 = new JLabel("GIẢNG VIÊN THỈNH GIẢNG");

        // Table1
        JScrollPane jScrollPane1 = new JScrollPane();
        String col1[] = { "MÃ GV", "HỌ TÊN", "NĂM SINH", "TRÌNH ĐỘ", "SỐ NĂM CT", "HS LƯƠNG", "NĂM CT",
                "DS MÔN HỌC" };
        DefaultTableModel tableMode1 = new DefaultTableModel(col1, 0);
        JTable jTable1 = new JTable(tableMode1);
        jScrollPane1.setViewportView(jTable1);

        // Table2
        JScrollPane jScrollPane2 = new JScrollPane();
        String col2[] = { "MÃ GV", "HỌ TÊN", "NĂM SINH", "TRÌNH ĐỘ", "SỐ NĂM CT", "NƠI CT",
                "DS MÔN HỌC" };
        DefaultTableModel tableMode2 = new DefaultTableModel(col2, 0);
        JTable jTable2 = new JTable(tableMode2);
        jScrollPane2.setViewportView(jTable2);

        // combobox
        String bs[] = new String[subjectDepartmentsList.size()];
        for (int i = 0; i < subjectDepartmentsList.size(); i++) {
            bs[i] = subjectDepartmentsList.get(i).getName();
        }
        ;
        JComboBox jComboBox1 = new JComboBox(bs);

        // Button
        Button button1 = new Button();
        button1.setLabel("Show");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // clear data
                tableMode1.getDataVector().removeAllElements();
                tableMode1.fireTableDataChanged();
                tableMode2.getDataVector().removeAllElements();
                tableMode2.fireTableDataChanged();
                for (SubjectDepartment t : subjectDepartmentsList) {
                    if (jComboBox1.getSelectedItem() == t.getName()) {
                        for (Lecturer a : t.getLecturerList()) {
                            String magv = a.getId();
                            String hoten = a.getFullName();
                            String namsinh = String.valueOf(a.getBirthYear());
                            String trinhdo = a.getInstructorQualifications();
                            String sonamct = String.valueOf(a.getnumberOfYearsOfService());
                            String dsmonhoc = "";
                            String noict = "";
                            String hesoluong = "";
                            String namCT = "";

                            // Lay ra ten mon hoc
                            for (int i = 0; i < subjectsList.size(); i++) {
                                dsmonhoc += subjectsList.get(i).getTitle();
                                if (i == subjectsList.size() - 1) {
                                    break;
                                }
                                dsmonhoc += ",";
                            }
                            // Neu la GVTG
                            if (a.isVisitingLecturer() == true) {
                                noict = ((VisitingLecturer) a).getWorkPlace();
                                String[] data = { magv, hoten, namsinh, trinhdo, sonamct, noict, dsmonhoc };
                                tableMode2.addRow(data);
                            }
                            // Neu la GVCH
                            else {
                                hesoluong = String.valueOf(((PrimaryLecturer) a).getCoefficientsSalary());
                                namCT = String.valueOf(((PrimaryLecturer) a).getWorkYear());
                                String[] data = { magv, hoten, namsinh, trinhdo, sonamct, hesoluong, namCT, dsmonhoc };
                                tableMode1.addRow(data);
                            }
                        }
                    }
                }
            }
        });

        // Can chinh layout
        GroupLayout layout = new GroupLayout(f.getContentPane());
        f.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(266, 266, 266)
                                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 65,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 150,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 150,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(204, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBox1)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        f.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
