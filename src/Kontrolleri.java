import ch.aplu.xboxcontroller.XboxController;

public class Kontrolleri {

	LiikutusTesti liikutus;
	CoronaUI ui;
	XboxController xc;
	boolean ohjainK‰ytˆss‰ = false;

	public Kontrolleri() {
		this.liikutus = new LiikutusTesti();
		this.ui = new CoronaUI();

		ui.asetaKontrolleri(this);
	}

	public void vaihdaNopeus(int x) {
		String nopeus = "" + x;
		ui.p‰ivit‰Nopeus(nopeus);
	}
	
	public void vaihdaStatus(int x){
		if(x == 1){
			ui.p‰ivit‰DemoStatus("On");
		}
		if(x == 2){
			ui.p‰ivit‰DemoStatus("Off");
		}
	}

	public void k‰yt‰Ohjainta() {
		
			xc = liikutus.getOhjain(this);
			
	
		
	}

	public void lopeta() {

		liikutus.lopeta();
	}

}
