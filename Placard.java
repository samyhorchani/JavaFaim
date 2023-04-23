public class Placard{
    //Cette classe permet de stocker la liste des ingrédients que l'utilisateur est suceptible de posseder dans son placard
    //Elle utilise le pattern Singleton car la création de plusieurs placard n'est pas necessaire
    public static final Ingredient[] placard = { //voici la liste des ingrédients contenu un tableau d'Ingredient
        new AutreIngredient("Oeuf", 4),
        new AutreIngredient("Farine", 1),
        new AutreIngredient("Lait", 1),
        new AutreIngredient("Riz", 1),
        new AutreIngredient("Beurre", 1),
        new Legume("Courgette", 1),
        new Legume("Aubergine", 1),
        new Legume("Carotte", 1),
        new AutreIngredient("Pâte", 1),
        new Fruit("Pomme",1),
        new Viande("Poulet",1),
        new Viande("Saumon",100),
        new AutreIngredient("Fromage",1),
        new AutreIngredient("Pâtes",1),
        new Legume("Haricots verts",2),
        new Legume("Champignons",1),
        new AutreIngredient("Levure",1),
        new AutreIngredient("Chocolat",1),
        new Viande("Porc",1),
        new Fruit("Tomate",1),
        new Viande("Boeuf",100),
        new AutreIngredient("Sucre",1),
        new Legume("Ail",1),
        new Legume("Oignon",1),
        new Legume("Poivron",2),
        new Legume("Pomme de terre",2)
        };
        private static Placard instance = new Placard(); // l'instance est alors la même pour toute la classe

    private Placard(){} //constructeur private empechant l'instanciation hors de la classe

    public String toString(){ // La méthode toString() permet ici d'afficher la liste des ingrédients contenus dans notre placard
        String res = "Voici la liste des ingrédients que vous êtes susceptible de posseder dans vos placards :\n";
        int i;
        for (i = 0; i<placard.length; i++){
            res += (i+1)+". "+placard[i].toString()+"\n";
        }
        return res;
    }

    public static int getNbIngredientPlacard(){ //La méthode getNbIngredientPlacard() permet de retourner la longueur du 
        return placard.length;
    }


    public static Placard getPlacard(){
        return instance;
    }

}
