import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Kurki {
	EV3LargeRegulatedMotor kurki;

	public Kurki(EV3LargeRegulatedMotor kurki) {
		this.kurki = kurki;
	}

	public void setNopeus(int nopeus) {
		kurki.setSpeed(nopeus);
		kurki.setAcceleration(9000);
	}

	public void k‰‰nn‰Vasemmalle() {
		kurki.backward();	
	}

	public void k‰‰nn‰Oikealle() {
		kurki.forward();
	}

	public void seis() {
//		kurki.resetTachoCount();
		kurki.stop();
	}

	public void oletusasentoon() {
		kurki.rotateTo(0);
	}

	public void kurkiAsento() {
		System.out.println(kurki.getTachoCount());
	}
}
