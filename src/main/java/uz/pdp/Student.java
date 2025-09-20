package uz.pdp;

public class Student {
    private String fullName;
    private int age;
    private String groupName;

    public Student() {
    }

    public Student(String fullName, int age, String groupName) {
        this.fullName = fullName;
        this.age = age;
        this.groupName = groupName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
