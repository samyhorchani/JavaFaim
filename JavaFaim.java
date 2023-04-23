import java.util.Scanner;
import java.util.ArrayList;
public class JavaFaim {
    public static void main(String[] args) {
        int millis = 1000;
        System.out.println("\t\t\t\t\tSalut c'est JavaFaim, le programme qui t'aide à trouver une recette quand t'as faim !");
        
        Tools.faireUnePause(millis);
        
        System.out.println("\t\t\t\t\t\t\tJe peux te proposer deux solutions :) :");
        Tools.faireUnePause(millis);
        System.out.print("\n");

        System.out.println("- Option 1 : Je te propose une liste d'ingrédients que tu es susceptible de posseder dans ton placard, tu en selectionnes 1 que tu possèdes, et je te propose une recette en fonction de l'aliment choisi :)");
        System.out.print("\n");
        System.out.println("- Option 2 : tu me laisse choisir et je te propose une super recette de la mort qui tue !!!!");
        System.out.print("\n");
        
        Scanner scan = new Scanner(System.in); //création d'un scanner
        int optionSaisie = 0; //Stockage de l'option saisie
            
        try{//permet de lever l'exception
            optionSaisie = Tools.saisieOptions(scan);
        }catch(MauvaiseSaisie e){
            while(optionSaisie!=1 && optionSaisie!=2 ){//tant que l'entier saisie n'est pas 1 ou 2, exception MauvaiseSaisie levé
                System.out.println(e.getMessage()); //Affichage du message d'erreur
                optionSaisie = scan.nextInt(); //Demande de la saisie d'un nouvelle entier
            }
        }
        
        if(optionSaisie==1){//Si l'option choisie est 1

            System.out.println("\t\t\t\t\t\t\tVous avez selectionner l'option 1 :)");
            System.out.print("\n");
            System.out.print("\n");
            System.out.println((Placard.getPlacard()).toString());
            System.out.print("\n");
            System.out.println("Saisissez un ingrédient dans la liste ci-dessus");
            int ingredientSaisie = -1; //stockage de l'ingrédient saisie (initialisation arbitraire à -1)

            try{ // demande à l'utilisateur un entier correspondant un 
                ingredientSaisie = Tools.saisieIngredient(scan);
            }catch(MauvaiseSaisie e ){
                while( (ingredientSaisie <= 0) || (ingredientSaisie > (Placard.placard).length) ){
                    System.out.println(e.getMessage());
                    ingredientSaisie = scan.nextInt();
                }
            }
            System.out.println("\n");
            System.out.println("ok ok on note"+" miam :)");
            System.out.println("\n");

            String regimeAlimentaireSaisie = "réponse";
            try{
                regimeAlimentaireSaisie = Tools.estVegetarien(scan);
            }catch(MauvaiseSaisie e){
                while(!(regimeAlimentaireSaisie.equals("oui")) && !(regimeAlimentaireSaisie.equals("non")) ){
                    System.out.println(e.getMessage());
                    regimeAlimentaireSaisie=scan.next();
                }
            }
            boolean estVegetarien; //stockage du booléen estVegetarien
            if(regimeAlimentaireSaisie.equals("oui")){//initialisation
                estVegetarien = true;
                System.out.println("Vous êtes végétarien, la classe !");
                System.out.println("\n");
            }else{
                estVegetarien = false;
                System.out.println("Vous n'êtes pas végétarien, un steak parfois ça fait du bien !");
                System.out.println("\n");
            }

            
            ArrayList<Recette> tabRecette = LivreDeRecette.recetteSelonIngredient(ingredientSaisie,estVegetarien); //ArrayList qui stocke les recettes correspondante au choix de l'ingredient
            if(tabRecette.size()==0){
                Tools.faireUnePause(millis);
                System.out.println("Excusez-moi : aucune recette correspondant à votre régime alimentaire n'a été trouvé, relancez javaFaim en selectionnant un autre ingédient :(");
            }else if (tabRecette.size()==1){
                Tools.faireUnePause(millis);
                System.out.println("J'ai trouvé une recette pouvant vous correspondre :\n");
                System.out.println((tabRecette.get(0)).toString());
            }else{
                Tools.faireUnePause(millis);
                System.out.println("J'ai trouvé "+tabRecette.size()+" recettes pouvant vous correspondre, choisissez en une \n");
                for(int i = 0; i<tabRecette.size(); i++){
                    System.out.println((i+1)+") "+(tabRecette.get(i)).afficherRecette());
                }
                System.out.println("Indiquez l'indice de la recette choisie dans la console");

                
                int indiceRecetteChoisie = -1; //stocakage de l'entier correspondant à la recette choise
                try{
                    indiceRecetteChoisie = Tools.choixRecette(scan, tabRecette, indiceRecetteChoisie); //demande à l'utilisateur
                }catch(MauvaiseSaisie e){ //attrape l'exception MauavaiseSaisie
                    while((indiceRecetteChoisie <= 0) || (indiceRecetteChoisie > (Placard.placard).length)){ //si MauvaiseSaisie, demande de resaissir un entier correspondant à une recette
                        System.out.println(e.getMessage()); //Affichage du message de Mauvaise Saisie
                        indiceRecetteChoisie = scan.nextInt(); 
                    }
                }
                //on utilise un constructeur par copie pour "cloner" la recette choisie
                Recette recetteChoisie = new Recette(tabRecette.get(indiceRecetteChoisie-1).getnomplat(), (tabRecette.get(indiceRecetteChoisie-1)).getIngredientsRecette(), (tabRecette.get(indiceRecetteChoisie-1)).getInstructions() );
                
                //on affiche la recette choisie
                System.out.println("\t\t\t\t\t\tVoici la recette choisie : ");
                System.out.println("\n");
                System.out.println("\t\t\t\t\t\t"+recetteChoisie.toString());

                System.out.println("\t\t\t\t\t\t\tBon Appetit !");
                System.out.println("\t\t\t\t\t\tEt merci d'avoir utilisé JavaFaim :)");

            }

        }else{ // else gère le cas du choix de l'option 2 : la recette tiré au hasard
            System.out.println("\t\t\t\t\t\tTrès bon choix, voici la super recette de la mort qui tue :");
            Tools.faireUnePause(millis);
            System.out.println("\t\t\t\t\t\t\t\t\t.");
            Tools.faireUnePause(millis);
            System.out.println("\t\t\t\t\t\t\t\t\t.");
            Tools.faireUnePause(millis);
            System.out.println("\t\t\t\t\t\t\t\t\t.");
            System.out.println("\t\t\t\t\t\tOn fait monté le suspens...");
            Tools.faireUnePause(millis);
            System.out.println("\t\t\t\t\t\t\t\t\t.");
            Tools.faireUnePause(millis);
            System.out.println("\t\t\t\t\t\t\t\t\t.");
            Tools.faireUnePause(millis);
            System.out.println("\t\t\t\t\t\tVous êtes pressé ?");
            System.out.println("\t\t\t\t\t\t\t\t...");
            System.out.println("\t\t\t\t\t\tBon ok ok ");
            System.out.println("\n");
            Tools.faireUnePause(millis);
            System.out.println("\t\t\t\t\t\tLA VOICI");
            Tools.faireUnePause(millis);
            Recette recetteRandom = new Recette(LivreDeRecette.recetteRandom()); //copie de la recette tiré au sort et son clone
            
            System.out.println("\t\t\t\t\t"+recetteRandom.toString());
            System.out.println("\n");
            System.out.println("\n");
            Tools.faireUnePause(millis);
            System.out.println("Bon Appetit :)");
            System.out.println("\t\t\t\t\t\tEt merci d'avoir utilisé JavaFaim :)");
        }
        
        scan.close(); //fermeture du scanner


    }
}
