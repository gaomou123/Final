package domain;

/**
 * Description:
 * 学生类
 *
 * @author: gyt
 * @date: 2021/6/19 15:38
 */
public class Person {
    private String college;
    private String name;
    private String sex;
    private int age;
    private int id;
    //在为宿舍添加一名学生后，记住这个学生是在多少个人之后成功入住的本宿舍
    private int memberId;
    //默认学生状态为空闲状态
    private Status status = Status.FREE;

    public Person() {
    }

    public Person(String college, String name, String sex, int age, int id, Status status) {
        this.college = college;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.id = id;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }


    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String string() {
        return memberId + "\t" + name + "\t" + age + "\t" + sex + "\t" + college + "\t";
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + age + "\t" + sex + "\t" + college + "\t" + status;
    }
}
