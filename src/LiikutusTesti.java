import java.io.DataInputStream;

import javax.swing.JOptionPane;

import ch.aplu.xboxcontroller.XboxController;

public class LiikutusTesti {

	private alustus alustus;
	private XboxController xc;
	private Tiedonsiirto siirto;
	OhjainKuuntelija kuuntelija;
	Kontrolleri kontrolleri;


	
	public LiikutusTesti() {
		
		
		
		
	}


	
	
	
	public XboxController getOhjain(Kontrolleri kontrolleri){
			alustus = new alustus();
			xc = alustus.getOhjain();
			siirto = new Tiedonsiirto();
			kuuntelija = new OhjainKuuntelija(siirto, kontrolleri);	
			xc.addXboxControllerListener(kuuntelija);
			
		
		
		return xc;
		
	}

	public void lopeta() {
		if(xc != null){
		xc.release();
		siirto.lopetaOhjelma();
		}
		System.exit(0);
	}

}
