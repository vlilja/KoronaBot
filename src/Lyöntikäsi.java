
import java.awt.Toolkit;

import lejos.hardware.Sound;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Lyöntikäsi {
	RegulatedMotor käsi;
//	int nopeus[] = new int[2];
//	int valinta = 0;
	Toolkit toolkit;
	boolean lyön = false;
	Sound sound;
	int HIDAS = 300;
	int NOPEA = 900;
	int nopeus;
	

	public Lyöntikäsi(RegulatedMotor käsi) {
		this.käsi = käsi;
		nopeus = NOPEA;
		käsi.setSpeed(nopeus);
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
		if(käsi.getSpeed() == NOPEA) {
			nopeus = HIDAS;
			käsi.setSpeed(nopeus);
			sound.setVolume(15);
			sound.beep();
		}
		else if(käsi.getSpeed() == HIDAS) {
			nopeus = NOPEA;
			käsi.setSpeed(nopeus);
			sound.setVolume(100);
			sound.beep();
		}
	}
	
	public void nopea() {
		käsi.setSpeed(NOPEA);
	}

	public void oletusasentoon() {
		Delay.msDelay(1000);
		käsi.setSpeed(100);
		käsi.rotateTo(0);
//		käsi.setSpeed(palautaNopeus());
		käsi.setSpeed(nopeus);
	}

	public void lyö() {
		lyön = true;
//		käsi.setSpeed(palautaNopeus());
		käsi.rotate(120);
		oletusasentoon();
		lyön = false;
	}

//	public int palautaNopeus() {
//		return nopeus[valinta];
//	}

	public void seis() {
		while (lyön) {

		}
		käsi.stop();
	}
	
	public int getNopeus() {
		return nopeus;
	}
}
