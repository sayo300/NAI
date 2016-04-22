package sayo300;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class LernSI {
	private Neuron neuron1, neuron2, neuron3;

	private double i , MaxeraCount = 300 , s=0 , d = 0;
	private int Epok =0;
	private boolean learn = true;
	
	public LernSI(LoadFlowers lf) {
	

		while(learn == true && s < MaxeraCount ){
			d++;
			if(d >350000){
				neuron1 = null;
				neuron2 = null;
				d =0;
				Epok++;
				log("<----------Losuje nowe wagi Epoka :" + Integer.toString(Epok));
			}
		for (Flower f : lf.getTrainingSet()) {
			
			if (f.getKindOfFlower().equals("Iris-setosa")) {
				if (neuron1 == null) {
					neuron1 = new Neuron(lf.getLotOfx(), f.getX(), 0, "Neuron 1");
					neuron2 = new Neuron(lf.getLotOfx(), f.getX(), 1, "Neuron 2");
					
				} else {
					neuron1.setNet(lf.getLotOfx(), f.getX(), 0, "Neuron 1");
					neuron2.setNet(lf.getLotOfx(), f.getX(), 1, "Neuron 2");
					
				}
			} else if (f.getKindOfFlower().equals("Iris-versicolor")) {
				if (neuron2 == null) {
					neuron1 = new Neuron(lf.getLotOfx(), f.getX(), 1, "Neuron 1");
					neuron2 = new Neuron(lf.getLotOfx(), f.getX(), 0, "Neuron 2");
					
				} else {
					neuron1.setNet(lf.getLotOfx(), f.getX(), 1, "Neuron 1");
					neuron2.setNet(lf.getLotOfx(), f.getX(), 0, "Neuron 2");
					
				}
			} else if (f.getKindOfFlower().equals("Iris-virginica")) {
				if (neuron3 == null) {
					neuron1 = new Neuron(lf.getLotOfx(), f.getX(), 1, "Neuron 1");
					neuron2 = new Neuron(lf.getLotOfx(), f.getX(), 1, "Neuron 2");
			
				} else {
					neuron1.setNet(lf.getLotOfx(), f.getX(), 1, "Neuron 1");
					neuron2.setNet(lf.getLotOfx(), f.getX(), 1, "Neuron 2");
					
				}
			}

			
		}
		i = 0;
		boolean k = false, k1 = false;

		for (Flower f : lf.getTestSet()) {
			

			if (f.getKindOfFlower().equals("Iris-setosa")) {
			k = neuron1.validate(lf.getLotOfx(), f.getX(), 0);
			k1 = neuron2.validate(lf.getLotOfx(), f.getX(), 1); 
			}else if (f.getKindOfFlower().equals("Iris-versicolor")){
				k = neuron1.validate(lf.getLotOfx(), f.getX(), 1);
				k1 = neuron2.validate(lf.getLotOfx(), f.getX(), 0); 
				
			}else if (f.getKindOfFlower().equals("Iris-virginica")){
				k = neuron1.validate(lf.getLotOfx(), f.getX(), 1);
				k1 = neuron2.validate(lf.getLotOfx(), f.getX(), 1); 
			}
			
			
			
			
			if(k == true && k1 == true){
				
				i++;
			}

		}
		

		i = (i*3.33);
		if(i > 80){
			learn = false;
			log(i);
			
		}else{
			if(i > 70){
				s++;
			System.out.println(i);
			}
		
		}
		}
		save(Double.toString(i));
	}

	public void log(boolean b) {
		System.out.println(b);
	}

	public void log(String string) {
		System.out.println(string);
	}
	public void log(int string) {
		System.out.println(string);
	}
	public void log(double string) {
		System.out.println(string);
	}
	public void log(boolean b, String string, Flower f) {
			if(b == true && f.getKindOfFlower().equals(string)){
				i++;
			}
		
		System.out.println(b + " " + string);
	}

	public void log(int[] is) {
		for (int i = 0; i < is.length; i++) {
			System.out.print(is[i] + " ");
		}
		System.out.println();
	}
	public void save(String s){
		BufferedReader reader = null;
		ArrayList<String> alist = new ArrayList<>();
		try {
			
			reader = new BufferedReader(new FileReader("Wynik.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
		
			alist.add(line);
			}
			PrintWriter writer = new PrintWriter("Wynik.txt", "UTF-8");
			for(int i =0; i< alist.size(); i++){	
			writer.println(alist.get(i));
			}
			writer.println(s);
			
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
