public class PersonTo {

    private String name;
    private int age;
    private boolean sex;
    private String home;

    public PersonTo(String name, int age, boolean sex, String home) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

}
