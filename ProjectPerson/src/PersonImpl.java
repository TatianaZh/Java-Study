public class PersonImpl implements Person {
    private final String name;
    private final int age;
    private final String pol;
    private Person spouse;

    PersonImpl(String name, int age, String pol) {
        this.name = name;
        this.age = age;
        this.pol = pol;
    }

    public String getPol() {
        return pol;
    }
    public int getAge() {
        return age;
    }


    @Override
    public boolean marry(Person person) {
        if (person != this && !person.getPol().equals(this.pol) && person.getAge() >= 18 && this.age >= 18 && spouse == null && person.getSpouse() == null) {

            spouse = person;
            person.setSpouse(this);

            System.out.println(this.name + " marry " + person.getName());
            return true;
        } else {
            System.out.println(this.name + " can't marry " + person.getName() + " !!!");
            return false;
        }
    }

    @Override
    public void divorce() {
        if (spouse != null) {
            System.out.println(this.name + " divorces with " + spouse.getName());
            spouse.setSpouseNull();
            spouse = null;
        } else {
            System.out.println(this.name + " doesn't married !!! ");
        }

    }

    @Override
    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public void setSpouseNull() {
        this.spouse = null;
    }

    @Override
    public String getName() {
        return name;
    }
}
