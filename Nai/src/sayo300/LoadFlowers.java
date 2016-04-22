package sayo300;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LoadFlowers {

	private List<Flower> trainingSet = new ArrayList<>();
	private List<Flower> testSet = new ArrayList<>();
	private List<String> listofTypes;
	private int proportions, lotOfx;

	public LoadFlowers(String string, int training, int test) {
		int pom = training + test;
		proportions = pom / test;

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(string));

			String line;
			int counter = 0;

			while ((line = reader.readLine()) != null) {

				String data[] = line.split(",");
				if (listofTypes == null) {
					listofTypes = new ArrayList<>();
					listofTypes.add(data[4]);
				} else {
					boolean p = false;
					for (int i = 0; i < listofTypes.size(); i++) {
						if (listofTypes.get(i).equals(data[4])) {
							p = true;
						}

					}
					if (p == false) {
						listofTypes.add(data[4]);
					}

				}
				double[] x = new double[data.length - 1];
				lotOfx = data.length;
				for (int i = 0; i < data.length - 1; i++) {
					x[i] = Double.parseDouble(data[i]);
				}

			
				Flower flower = new Flower(x, data[data.length - 1]);

				if (counter % proportions == 0) {
					testSet.add(flower);
				} else {
					trainingSet.add(flower);
				}
				counter++;

			}
		} catch (NumberFormatException | IOException e) {

			e.printStackTrace();
		}
		log(listofTypes.toString());
		writeToFile(trainingSet, "iris.trn.txt");
		writeToFile(testSet, "iris.tst.txt");
	}

	public void writeToFile(List<Flower> list, String nameOfFile) {
		try {
			PrintWriter writer = new PrintWriter(nameOfFile, "UTF-8");
			StringBuffer sb = new StringBuffer();
			for (Flower f : list) {
				sb.delete(0, sb.length());
				sb.append(f.getX()[0] + "," + f.getX()[1] + "," + f.getX()[2]
						+ "," + f.getX()[3] + "," + f.getKindOfFlower());
				writer.println(sb.toString());
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
		
			e.printStackTrace();
		}
	}

	public List<Flower> getTrainingSet() {
		return trainingSet;
	}

	public void setTrainingSet(List<Flower> trainingSet) {
		this.trainingSet = trainingSet;
	}

	public List<Flower> getTestSet() {
		return testSet;
	}

	public void setTestSet(List<Flower> testSet) {
		this.testSet = testSet;
	}

	public void log(String string) {
		System.out.println(string);
	}

	public void setY() {
		for (Flower flower : trainingSet) {
			int[] pom = new int[listofTypes.size()];
			for (int i = 0; i < listofTypes.size(); i++) {
				if (flower.getKindOfFlower().equalsIgnoreCase(
						listofTypes.get(i))) {
					pom[i] = 1;
				} else {
					pom[i] = 0;
				}
				flower.setY(pom);

			}

		}
		for (Flower flower : testSet) {
			int[] pom = new int[listofTypes.size()];
			for (int i = 0; i < listofTypes.size(); i++) {
				if (flower.getKindOfFlower().equalsIgnoreCase(
						listofTypes.get(i))) {
					pom[i] = 1;

				} else {
					pom[i] = 0;
				}
				flower.setY(pom);
			}

		}
	}

	public int getLotOfx() {
		return lotOfx;
	}

	public void setLotOfx(int lotOfx) {
		this.lotOfx = lotOfx;
	}

}
