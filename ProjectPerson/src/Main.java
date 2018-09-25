public class Main {
    public static void main(String[] args) {
        Person dima = new PersonImpl("Dima", 27, "man");
        Person sveta = new PersonImpl("Sveta", 29, "woman");

        dima.marry(sveta);
        if (dima.getSpouse() != null) {
            System.out.println("dima's spouse is " + dima.getSpouse().getName());
        } else {
            System.out.println("dima doesn't marry ");
        }

        if (sveta.getSpouse() != null) {
            System.out.println("sveta's spouse is " + sveta.getSpouse().getName());
        } else {
            System.out.println("sveta doesn't marry ");
        }

        System.out.println();

////////////////
        dima.divorce();

        if (dima.getSpouse() != null) {
            System.out.println("dima's spouse is " + dima.getSpouse().getName());
        } else {
            System.out.println("dima doesn't marry ");
        }

        if (sveta.getSpouse() != null) {
            System.out.println("sveta's spouse is " + sveta.getSpouse().getName());
        } else {
            System.out.println("sveta doesn't marry ");
        }
        System.out.println();

        sveta.divorce();
        System.out.println();

        ///////
        Person albert = new PersonImpl("Albert", 29, "man");
        Person masha = new PersonImpl("Masha", 9, "woman");

        albert.marry(dima);
        masha.marry(dima);
        System.out.println();
        sveta.marry(albert);
        sveta.marry(dima);



    }
}