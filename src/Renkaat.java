
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Renkaat {
	RegulatedMotor vasen;
	RegulatedMotor oikea;

	public Renkaat(RegulatedMotor vasen, RegulatedMotor oikea) {
		this.vasen = vasen;
		this.oikea = oikea;
		vasen.setAcceleration(1000);
		oikea.setAcceleration(1000);
		vasen.synchronizeWith(new RegulatedMotor[] { oikea });
	}

	public void setNopeus(int nopeus) {
		vasen.setSpeed(nopeus);
		oikea.setSpeed(nopeus);
	}

	public void liikuVasemmalle() {
		vasen.backward();
		oikea.forward();

	}

	public void liikuVasemmalle(int delay) {
		vasen.backward();
		oikea.forward();
		Delay.msDelay(delay);
	}

	public void liikuOikealle() {
		vasen.forward();
		oikea.backward();
	}

	public void liikuOikealle(int delay) {
		vasen.forward();
		oikea.backward();
		Delay.msDelay(delay);
	}

	public void seis() {
		vasen.startSynchronization();
		vasen.stop();
		oikea.stop();
		vasen.endSynchronization();
	}

	public int oikeaTachoCount() {
		return oikea.getTachoCount();
	}

	public String tachoLaskuri() {
//		String tacho;
//		tacho = "Vasen: " + vasen.getTachoCount() + "\n" + "Oikea:"
//				+ oikea.getTachoCount();
		return "Vasen: " + vasen.getTachoCount() + "\n" + "Oikea:"
		+ oikea.getTachoCount();
	}

}
