public class Data {
    private int semester, credits, ECTS, GTU, sum;
    private String code, name;
    private boolean disabled;

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Data(int semester, int credits, int ECTS, int GTU, int sum, String code, String name) {
        this.semester = semester;
        this.credits = credits;
        this.ECTS = ECTS;
        this.GTU = GTU;
        this.sum = sum;
        this.code = code;
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public int getGTU() {
        return GTU;
    }

    public void setGTU(int GTU) {
        this.GTU = GTU;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Data() {
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCredits() {
        return credits;
    }

    public Data(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", getName());
    }
}
