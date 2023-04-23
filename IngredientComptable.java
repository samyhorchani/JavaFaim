public abstract class IngredientComptable extends Ingredient{
    //Cette classe permet de differentier les ingredients "comptables" des ingrédients "pesables"
    protected int quantite; //ils possèdent alors un attribut quantité

    public IngredientComptable(String nom, int quantite){
        super(nom);
        this.quantite=quantite;
    }

    
}
