package modele;

public class Usager {
    private int id;
    private String nom;
    private int age;

    public Usager() {
    }

    public Usager(int age, String nom) {
        this.age = age;
        this.nom = nom;
    }

    public Usager(int age, int id, String nom) {
        this.age = age;
        this.id = id;
        this.nom = nom;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Usager{" +
                "age=" + age +
                ", id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
