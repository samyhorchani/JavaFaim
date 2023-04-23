import java.util.Scanner;
import java.util.ArrayList;

public class Tools {
    //La classe Tools contient principalement les fonctions de scan (et permet de lever les exception de mauvaise saisie)
    //Des methodes de mises en forme sont aussi contenues dans cette classe
    private static Tools instance = new Tools();
    private Tools(){}

    public static int saisieOptions(Scanner scan) throws MauvaiseSaisie{ //permet de demander la saisie de l'option 1 ou 2 à l'utilisateur
        System.out.println("Choisi une des 2 options en saisissant 1 ou 2 dans la console");
            int entierSaisie = scan.nextInt();
            
            if(entierSaisie!=1 && entierSaisie!=2){
                throw new MauvaiseSaisie("Veuillez saisir dans la console l'entier 1 ou 2");
            }
            return entierSaisie;
    }

    
    public static void faireUnePause(int millis){ // fonction permettant de mettre en pause le programme d'un temps millis en milliseconde
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }


    public static int saisieIngredient(Scanner scan) throws MauvaiseSaisie{ //Cette methode permet de demander à l'utilisateur la saisie de l'indice correspondant à l'ingrédient choisi
        (Placard.getPlacard()).toString(); //on affiche d'abord la liste des ingrédients contenue dans le placard
        int ingredientSaisie = scan.nextInt();// on demande alors à l'utilisateur de saisir dans le terminal un entier
        if(ingredientSaisie <= 0){ //si l'entier saisie est inférieur à 0 alors on lève l'exception MauvaiseSaisie (IndexOutOfBoundsException)
            throw new MauvaiseSaisie("Saisir dans la console un ingredient compris entre 1 & " + (Placard.placard).length );
        }
        if(ingredientSaisie > (Placard.placard).length){ //si l'entier saisie est supérieur à 0 alors on lève l'exception MauvaiseSaisie (IndexOutOfBoundsException)
            throw new MauvaiseSaisie("Saisir dans la console un ingredient compris entre 1 & " +(Placard.placard).length);
        }
        
        return ingredientSaisie; // si aucune exception a été levé, on retourne l'entier saisie par l'utilisateur
    }

    public static String estVegetarien(Scanner scan) throws MauvaiseSaisie{ //methode permettant la saisie de l'utilisateur du Régime Alimentaire
        System.out.println("Êtes-vous végétarien ? saisissez oui ou non (en minuscule)");
        String estVegetarien = scan.next();
        if(!(estVegetarien.equals("oui")) && !(estVegetarien.equals("non"))){ //Si saisie differente de "oui" ou "non" alors on lève l'exception MauvaiseSaisie
            throw new MauvaiseSaisie("Saisissez 'true' : oui ou 'false' : non");
        }

        return estVegetarien; //Si aucune exception levé, on retourne la chaine de caractère "oui" ou "non"
    }

    public static int choixRecette (Scanner scan, ArrayList<Recette> tabRecette, int indiceRecetteChoisie) throws MauvaiseSaisie{ //Permet la saisie de la recette choisie
        indiceRecetteChoisie = scan.nextInt();
        if(indiceRecetteChoisie <= 0){
            throw new MauvaiseSaisie("Saisir dans le Terminal une recette comprise entre 1 & " + tabRecette.size());
        }
        if(indiceRecetteChoisie > tabRecette.size()){
            throw new MauvaiseSaisie("Saisir dans le Terminal une recette comprise entre 1 & " + tabRecette.size());
        }
        return indiceRecetteChoisie;
    
    }

    public static Tools getTools(){
        return instance;
    }

}
