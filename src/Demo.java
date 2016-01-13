import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;

public class Demo {

	boolean k�ynniss� = false;
	V�rintunnistus tunnistus;
	Renkaat renkaat;
	Ly�ntik�si k�si;
	Kurki kurki;
	DataInputStream in;
	DataOutputStream out;
	
	public Demo(V�rintunnistus tunnistus, Ly�ntik�si k�si, Renkaat renkaat, Kurki kurki,
			DataInputStream in, DataOutputStream out) {
		this.tunnistus = tunnistus;
		this.k�si = k�si;
		this.renkaat = renkaat;
		this.kurki = kurki;
		this.in = in;
		this.out = out;

	}

	public void ajaDemoa() throws IOException {
		kurki.oletusasentoon();
		k�si.nopea();
		int i = 0;
		int aika = 0;
		k�ynniss� = true;
//		for (int k = 0; k < 5; k++) {
//			System.out.println("Skannaan v�ri�");
			tunnistus.setV�ri();
//			Delay.msDelay(1000);
//		}
		renkaat.liikuOikealle(1000);
		while (k�ynniss�) {
			
			lopetaDemo();

			System.out.println("olen k�ynniss�");
			if (i == 0) {
				renkaat.liikuOikealle();
			} else {
				renkaat.liikuVasemmalle();
			}
			if (tunnistus.v�riTunnistus()) {
				System.out.println("Ly�n");
				renkaat.liikuOikealle();
				if (i == 0) {
					 aika = 1300;
//					aika = 800;
				}
				 else aika = 1050;
//				else
//					aika = 550;
				Delay.msDelay(aika);
				renkaat.seis();
				k�si.ly�();
				if (i == 0) {
					i = 1;
				} else if (i == 1) {
					i = 0;
				}
			}
			if (renkaat.oikeaTachoCount() < -625) {
				i = 1;
			} else if (renkaat.oikeaTachoCount() > 625) {
				i = 0;
			}
		}
	}

	public void lopetaDemo() {
		int h = 0;
		try {
			if (in.available() == 4) {
				h = in.readInt();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (h == 7) {
			k�ynniss� = false;
			
			
		}
	}

}
