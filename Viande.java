public class Viande extends IngredientPesable{

	public Viande(String nom,int poids){
		super(nom, poids);
	}

	public boolean vegetarien() { //Les ingredients etant de la Viande ne conviennent pas à un regime alimentaire vegetarien 
		return false;
	}

}
