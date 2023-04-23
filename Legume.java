public class Legume extends IngredientComptable{
    //Cette classe permet de définir les ingredients étant des légumes
    public Legume(String nom, int quantite) {
        super(nom, quantite);
    }


    public boolean vegetarien(){
        return true;
    }

}
