public class Subject {
    private String title;
    private int numberOfCredits;

    public Subject() {
    }

    public Subject(String title, int numberOfCredits) {
        this.title = title;
        this.numberOfCredits = numberOfCredits;
    }

    public void setSubject(String title, int numberOfCredits) {
        this.title = title;
        this.numberOfCredits = numberOfCredits;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String subjectTitle) {
        this.title = subjectTitle;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public void display() {
        System.out.println("Ten MH: " + title);
        System.out.println("So Tin Chi: " + numberOfCredits);
    }
}