import ch.aplu.xboxcontroller.XboxController;

public class Kontrolleri {

	LiikutusTesti liikutus;
	CoronaUI ui;
	XboxController xc;
	boolean ohjainKäytössä = false;

	public Kontrolleri() {
		this.liikutus = new LiikutusTesti();
		this.ui = new CoronaUI();

		ui.asetaKontrolleri(this);
	}

	public void vaihdaNopeus(int x) {
		String nopeus = "" + x;
		ui.päivitäNopeus(nopeus);
	}
	
	public void vaihdaStatus(int x){
		if(x == 1){
			ui.päivitäDemoStatus("On");
		}
		if(x == 2){
			ui.päivitäDemoStatus("Off");
		}
	}

	public void käytäOhjainta() {
		
			xc = liikutus.getOhjain(this);
			
	
		
	}

	public void lopeta() {

		liikutus.lopeta();
	}

}
