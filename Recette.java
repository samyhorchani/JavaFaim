public class Recette{
    private String nomplat;
    private Ingredient[] ingredientsRecette;
    private String instructions;

    public Recette (String nomplat, Ingredient[] ingredientsRecette,String instructions){
        this.nomplat = nomplat;
        this.instructions=instructions;
        this.ingredientsRecette = ingredientsRecette;
    }

    public Recette (Recette recette){
        this.nomplat = recette.nomplat;
        this.instructions = recette.instructions;
        this.ingredientsRecette = recette.ingredientsRecette;
    }

    public String toString(){
        String res = "Recette : "+nomplat+"\n Il vous faudra : ";
        for(int i=0;i<ingredientsRecette.length;i++){
            res+=ingredientsRecette[i]+", ";
        }
        return res+"\n"+"Les étapes sont: \n"+instructions;
    }

    public String afficherRecette(){ //permet d'afficher le nom d'une recette suivi de la liste de ces ingredients
        String res = "Recette : "+nomplat+"\nIl vous faudra : \n";
        for(int i=0;i<ingredientsRecette.length;i++){
            res+=" - "+ingredientsRecette[i]+"\n";
        }
        return res;
    }

    public String getnomplat(){
        return nomplat;
    }

    public String getInstructions(){
        return instructions;
    }

    public Ingredient[] getIngredientsRecette(){
        return ingredientsRecette;
    }
}

