import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class V�rintunnistus {

	boolean k�ynniss�;
	private float[] tunnistettava;
	private SampleProvider colorProvider;
	boolean tunnistettu;

	public V�rintunnistus(SampleProvider colorProvider) {
		this.colorProvider = colorProvider;
	}

	public float[] skannaaV�ri() {
		float[] sample = new float[colorProvider.sampleSize()];
		colorProvider.fetchSample(sample, 0);
		return sample;
	}

	public void setV�ri() {
		this.tunnistettava = new float[3];
//		tunnistettava = skannaaV�ri();
//		tunnistettava[0] = Math.round(tunnistettava[0] * 255);
//		tunnistettava[1] = Math.round(tunnistettava[1] * 255);
//		tunnistettava[2] = Math.round(tunnistettava[2] * 255);

		tunnistettava[0] = 5;
		tunnistettava[1] = 5;
		tunnistettava[2] = 3;
//		
//		System.out.println("v�ri 1: " + tunnistettava[0]);
//		System.out.println("v�ri 2: " + tunnistettava[1]);
//		System.out.println("v�ri 3: " + tunnistettava[2]);
	}

	public boolean v�riTunnistus() {

		tunnistettu = false;

		float[] tunnista = skannaaV�ri();
		tunnista[0] = Math.round(tunnista[0] * 255);
		tunnista[1] = Math.round(tunnista[1] * 255);
		tunnista[2] = Math.round(tunnista[2] * 255);

		for (int i = 0; i < tunnista.length; i++) {
			// System.out.println(tunnista[i]);
			tunnista[i] = tunnista[i] - tunnistettava[i];
			tunnista[i] = (tunnista[i] * tunnista[i]);
		}

		float skannattu = tunnista[0] + tunnista[1] + tunnista[2];
		skannattu = (float) Math.sqrt(skannattu);

		if (skannattu < 8) {
			tunnistettu = true;

		}

		// Delay.msDelay(50);

		return tunnistettu;

	}

	public void printtaaTunnistettu() {
		for (int i = 0; i < 3; i++) {
			System.out.println(this.tunnistettava[i]);
		}

	}

}
