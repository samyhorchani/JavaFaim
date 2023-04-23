public class AutreIngredient extends IngredientPesable{
    //classe permettatn d'instancier les aliments n'étant ni des fruits, légumes ou viandes (farine, oeuf,...)
    public AutreIngredient(String nom,int poids){
        super(nom, poids);
    }

    public String getNom(){
        return nom;
    }


    public boolean vegetarien(){ //Ces aliments conviennent à un régime alimentaire végétarien
        return true;
    }
}
