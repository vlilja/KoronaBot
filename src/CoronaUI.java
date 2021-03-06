import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class CoronaUI extends JFrame implements ActionListener {

	private JPanel paneeli;
	private JPanel status;
	private JButton käytäOhjainta;
	private JLabel otsikko;
	private JButton lopeta;
	private JLabel nopeus;
	private JLabel demotila;
	private Kontrolleri kontrolleri;
	boolean ohjainLuotu = false;

	public CoronaUI() {

		käytäOhjainta = new JButton("Ohjain: ei käytössä");
		käytäOhjainta.addActionListener(this);
		otsikko = new JLabel("CoronaBotti 1.0");
		status = new JPanel();
		status.setLayout(new GridLayout(3, 1));
		nopeus = new JLabel("Nopeus: 900");
		demotila = new JLabel("Demotila: off");
		lopeta = new JButton("Lopeta pelaaminen");
		lopeta.addActionListener(this);
		paneeli = new JPanel(new BorderLayout());
		status.add(nopeus);
		status.add(demotila);
		status.add(käytäOhjainta);
		paneeli.add(otsikko, BorderLayout.NORTH);
		paneeli.add(status, BorderLayout.CENTER);
		paneeli.add(lopeta, BorderLayout.SOUTH);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				kontrolleri.lopeta();
				System.out.println("Lopetin");
			}
		});
		add(paneeli);
		setVisible(true);
		setSize(new Dimension(400, 400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void asetaKontrolleri(Kontrolleri kontrolleri) {
		this.kontrolleri = kontrolleri;
	}

	public void päivitäNopeus(String nopeus) {
		this.nopeus.setText("Nopeus: " + nopeus);
	}

	public void päivitäDemoStatus(String demo) {
		demotila.setText("Demotila: " + demo);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == käytäOhjainta) {
			kontrolleri.käytäOhjainta();
			if(!ohjainLuotu){
			käytäOhjainta.setText("Ohjain: käytössä");
			ohjainLuotu = true;
			käytäOhjainta.setEnabled(false);
			
		}
		}

		if (e.getSource() == lopeta) {
			kontrolleri.lopeta();

		}
	}
}

