public class MauvaiseSaisie extends Exception{
    //Cette classe permet de lever les exceptions dû à de mauvaise saisie (IndexOutOfBoundsException, InputMismatchException)
    public MauvaiseSaisie(String s){
        super("Mauvaise saisie : "+s);
    } 
}
