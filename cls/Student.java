package mfcodbc.cls;

/**
 * Demo Student class
 *
 * @author Accer
 * @date 2022/07/05
 */

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", cls=" + cls +
                '}';
    }

    private String id;
    private String name;
    private String sex;
    private int age;
    private String major;
    private int cls;

    public Student(String id, String name, String sex, int age, String major, int cls)
    {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.major = major;
        this.cls = cls;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setCls(int cls) {
        this.cls = cls;
    }

    public int getCls() {
        return cls;
    }
}