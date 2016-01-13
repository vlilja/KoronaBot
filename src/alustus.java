
import javax.swing.JOptionPane;

import ch.aplu.xboxcontroller.*;

public class alustus {

	private XboxController xc;

	public alustus() {
		xc = new XboxController();

		if (!xc.isConnected()) {
			JOptionPane.showMessageDialog(null,
					"Xbox controller not connected.", "Fatal error",
					JOptionPane.ERROR_MESSAGE);
			xc.release();
			return;
		}

	}

	public XboxController getOhjain() {

		return this.xc;
	}
}
