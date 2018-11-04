public class PersonFrom {

    private String name;
    private int age;
    private boolean sex;
    private String someinformation;
    //private String home;

    public PersonFrom(String name, int age, boolean sex,String someinformation) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.someinformation = someinformation;
       // this.home = home;
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

    public String getSomeinformation() {
        return someinformation;
    }

    public void setSomeinformation(String someinformation) {
        this.someinformation = someinformation;
    }


    // public String getHome() {
     //   return home;
   // }

   // public void setHome(String home) {
   //     this.home = home;
    //}
}
