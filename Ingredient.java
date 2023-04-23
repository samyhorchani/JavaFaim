public abstract class Ingredient implements RegimeAlimentaire{
    //cette classe permet de définir un ingrédient, pour créer notre placard.
    protected String nom;

    public Ingredient(String nom){
        this.nom=nom;
    }

    public String toString() {
        return nom;
    }

}
