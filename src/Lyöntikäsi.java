
import java.awt.Toolkit;

import lejos.hardware.Sound;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Ly�ntik�si {
	RegulatedMotor k�si;
//	int nopeus[] = new int[2];
//	int valinta = 0;
	Toolkit toolkit;
	boolean ly�n = false;
	Sound sound;
	int HIDAS = 300;
	int NOPEA = 900;
	int nopeus;
	

	public Ly�ntik�si(RegulatedMotor k�si) {
		this.k�si = k�si;
		nopeus = NOPEA;
		k�si.setSpeed(nopeus);
//		int x = 300;
//		for (int i = 0; i < nopeus.length; i++) {
//			nopeus[i] = x;
//			x += 600;
//		}

	}
	

//	public void vaihdaNopeus() {
//		if (valinta < (nopeus.length - 1)) {
//			valinta++;
//			sound.setVolume(100);
//			sound.beep();
//		} else {
////			valinta = 0;
//			sound.setVolume(15);
//			sound.beep();
//		}
//		System.out.println("Speed: " + nopeus[valinta]);
//	}
//	
//	public void setValinta() {
//		valinta = 1;
//	}
	
	public void vaihdaNopeus() {
		if(k�si.getSpeed() == NOPEA) {
			nopeus = HIDAS;
			k�si.setSpeed(nopeus);
			sound.setVolume(15);
			sound.beep();
		}
		else if(k�si.getSpeed() == HIDAS) {
			nopeus = NOPEA;
			k�si.setSpeed(nopeus);
			sound.setVolume(100);
			sound.beep();
		}
	}
	
	public void nopea() {
		k�si.setSpeed(NOPEA);
	}

	public void oletusasentoon() {
		Delay.msDelay(1000);
		k�si.setSpeed(100);
		k�si.rotateTo(0);
//		k�si.setSpeed(palautaNopeus());
		k�si.setSpeed(nopeus);
	}

	public void ly�() {
		ly�n = true;
//		k�si.setSpeed(palautaNopeus());
		k�si.rotate(120);
		oletusasentoon();
		ly�n = false;
	}

//	public int palautaNopeus() {
//		return nopeus[valinta];
//	}

	public void seis() {
		while (ly�n) {

		}
		k�si.stop();
	}
	
	public int getNopeus() {
		return nopeus;
	}
}
