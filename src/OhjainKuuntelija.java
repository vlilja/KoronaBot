import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import ch.aplu.xboxcontroller.XboxControllerAdapter;

public class OhjainKuuntelija extends XboxControllerAdapter {

	boolean taulukko[] = new boolean[8];

	boolean streamK�yt�ss� = false;
	boolean tikkuK�yt�ss� = false;
	boolean demoP��ll� = false;
	Tiedonsiirto tiedonsiirto;
	Kontrolleri kontrolleri;
	
	
	public OhjainKuuntelija(Tiedonsiirto tiedonsiirto, Kontrolleri kontrolleri) {
		this.tiedonsiirto = tiedonsiirto;
		this.kontrolleri = kontrolleri;
		for (int i = 0; i < taulukko.length; i++) {
			taulukko[i] = false;
		}
	}
	
	
	public void leftShoulder(boolean tosi) {
		if (!streamK�yt�ss�) {
			streamK�yt�ss� = true;
			taulukko[0] = true;
			if (tosi) {
				tiedonsiirto.l�het�Tietoa(0);

			}
		}

		if (!tosi && taulukko[0]) {
			streamK�yt�ss� = tiedonsiirto.l�het�Tietoa(-1);
			taulukko[0] = false;
		}

	}

	public void rightShoulder(boolean tosi) {
		if (!streamK�yt�ss�) {
			streamK�yt�ss� = true;
			taulukko[1] = true;
			if (tosi) {
				tiedonsiirto.l�het�Tietoa(1);
			}
		}

		if (!tosi && taulukko[1]) {
			streamK�yt�ss� = tiedonsiirto.l�het�Tietoa(-1);
			taulukko[1] = false;
		}

	}

	public void dpad(int arvo, boolean painettu) {
		if (!streamK�yt�ss�) {
			streamK�yt�ss� = true;
			taulukko[2] = true;
			taulukko[3] = true;
			if (painettu && arvo == 2) {
				tiedonsiirto.l�het�Tietoa(2);
			}
			if (painettu && arvo == 6) {
				tiedonsiirto.l�het�Tietoa(3);
			}
		}

		if (!painettu && taulukko[2] && taulukko[3]) {
			streamK�yt�ss� = tiedonsiirto.l�het�Tietoa(-1);
			taulukko[2] = false;
			taulukko[3] = false;
		}

	}

	public void buttonA(boolean painettu) {
		if (!streamK�yt�ss�) {
			streamK�yt�ss� = true;
			taulukko[4] = true;
			if (painettu) {
				tiedonsiirto.l�het�Tietoa(4);
			}
		}

		if (!painettu && taulukko[4]) {
			streamK�yt�ss� = tiedonsiirto.l�het�Tietoa(-1);
			taulukko[4] = false;
		}
	}

	public void buttonY(boolean painettu) {
		if (!streamK�yt�ss�) {
			streamK�yt�ss� = true;
			taulukko[5] = true;
			if (painettu && !demoP��ll�) {
				tiedonsiirto.l�het�Tietoa(5);
				kontrolleri.vaihdaNopeus(tiedonsiirto.vastaanotaTietoa());
				
			}
		}

		if (!painettu && taulukko[5]) {		
			streamK�yt�ss� = tiedonsiirto.l�het�Tietoa(-1);
			taulukko[5] = false;
		}

	}

	public void start(boolean painettu) {
		if (!streamK�yt�ss�) {
			streamK�yt�ss� = true;
			taulukko[6] = true;
			if (painettu) {
				demoP��ll� = true;
				kontrolleri.vaihdaStatus(1);
				kontrolleri.vaihdaNopeus(900);
				tiedonsiirto.l�het�Tietoa(6);
				
				
				
				
			}
		}

		if (!painettu && taulukko[6]) {
			streamK�yt�ss� = tiedonsiirto.l�het�Tietoa(-1);
			taulukko[6] = false;
			
		}

	}

	public void back(boolean painettu) {
		if (!streamK�yt�ss�) {
			streamK�yt�ss� = true;
			taulukko[7] = true;
			if (painettu) {
				demoP��ll� = false;
				kontrolleri.vaihdaStatus(2);
				tiedonsiirto.l�het�Tietoa(7);
				
			}
		}

		if (!painettu && taulukko[7]) {
			streamK�yt�ss� = tiedonsiirto.l�het�Tietoa(-1);
			taulukko[7] = false;
			
		}

	}

}

// public void leftThumbDirection(double arg0) {
// if (arg0 > 240 && arg0 < 280 && tikkuK�yt�ss�){
// try {
// out.writeInt(3);
// out.flush();
// } catch (IOException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// }
//
// if (arg0 > 70 && arg0 < 110 && tikkuK�yt�ss�){
// try {
// out.writeInt(2);
// out.flush();
// } catch (IOException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// }
//
//
// }
//
// public void leftThumbMagnitude(double arg0) {
// tikkuK�yt�ss� = false;
// if (arg0 > 0.7){
// tikkuK�yt�ss� = true;
// }
// else{
// tikkuK�yt�ss� = false;
// try {
// out.writeInt(-1);
// out.flush();
// } catch (IOException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// }
//
// }

