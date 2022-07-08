package mfcodbc.cls;

/**
 * Demo Teacher class
 *
 * @author Accer
 * @date 2022/07/05
 */

public class Teacher {
    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", title='" + title + '\'' +
                '}';
    }

    private String id;
    private String name;
    private String sex;
    private int age;
    private String title;

    public Teacher(String id, String name, String sex, int age, String title)
    {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.title = title;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}