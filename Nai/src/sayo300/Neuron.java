package sayo300;

public class Neuron {

	private double[] weight;// wagi
	private double net = 0;// net
	private double b, y;// stala b i odpowiedz która uzyskamy
	private int d;// oczekiwana odpowiedz

	public Neuron(int lotOfx, double[] x, int expected, String s) {

		// log(expected);
		weight = new double[lotOfx - 1];
		for (int i = 0; i < lotOfx - 1; i++) {
			weight[i] = (Math.random() * 3) - 1;
			// log(weight[i]);
		}
		b = (Math.random() * 3) - 1;
		setNet(lotOfx, x, expected, s);

	}

	public boolean setNet(int lotOfx, double[] x, int expected, String s) {
		this.d = expected;
		net = 0;

		net = (x[0] * weight[0] + x[1] * weight[1] + x[2] * weight[2] + x[3] * weight[3])+b;

		if (net >= 0) {
			y = 1;
		} else {
			y = 0;
		}

		if((expected == y) == false ){
		lernNeuron(lotOfx, x);
		}
	//	while((expected == y) == false){			
		valid(lotOfx, x, expected, s);
	//	}
		return expected == y;
	}

	private void valid(int lotOfx, double[] x, int expected, String s) {
		// TODO Auto-generated method stub
		net = 0;

		net = (x[0] * weight[0] + x[1] * weight[1] + x[2] * weight[2] + x[3] * weight[3])+b;

		if (net >= 0) {
			y = 1;
		} else {
			y = 0;
		}

		lernNeuron(lotOfx, x);
	}

	public void lernNeuron(int lotOfx, double[] x) {
		for (int i = 0; i < lotOfx - 1; i++) {
			//System.out.println(d-y);
			weight[i] = weight[i] + ((0.3 * (d - y)) * x[i]);

		}
//		log(weight);
//		log("");
		b = b + (0.35 * (d - y));

	}

	public boolean validate(int lotOfx, double[] x, int expected) {
		this.d = expected;
		net = 0;

		net = (x[0] * weight[0] + x[1] * weight[1] + x[2] * weight[2] + x[3] * weight[3])+b;

		if (net >= 0) {
			y = 1;
		} else {
			y = 0;
		}
		return y == expected;

	}

	public void log(String string) {
		System.out.println(string);
	}

	public void log(double string) {
		System.out.println(string);
	}

	public void log(double[] string) {

		for (double d : string) {
			System.out.print(d+" ,");
		}
	}

	public void log(int string) {
		System.out.println(string);
	}
}
