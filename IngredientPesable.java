public abstract class IngredientPesable extends Ingredient{
    
    protected int poids; //attribut "poids" en grammes

    public IngredientPesable(String nom, int poids){
        super(nom);
        this.poids = poids;
    }

    
}
