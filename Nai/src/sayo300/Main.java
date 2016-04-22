package sayo300;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				//Podaj w jakich proporcjach podzieliæ baze treningowa na testowa 
				LoadFlowers lf = new LoadFlowers("iris.dat.txt", 80, 20);
				lf.setY();
				
				LernSI lern = new LernSI(lf);
				
	}

}
