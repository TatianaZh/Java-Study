public interface Person {
    boolean marry(Person person);
    void divorce();
    Person getSpouse();
    void setSpouse(Person spouse);
    void setSpouseNull();
    String getPol();
    int getAge();
    String getName();

}