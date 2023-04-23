public class Fruit extends IngredientComptable{
    //Cette classe permet de pouvoir instancier les ingrédients étant des fruits
    public Fruit(String nom, int quantite){
        super(nom, quantite);
        }

    public boolean vegetarien(){
        return true;
    }

}
