import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lejos.hardware.Sound;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class RoboLiikutus {

	public static void main(String[] args) throws IOException {
		// Moottorit
		EV3LargeRegulatedMotor ma = new EV3LargeRegulatedMotor(MotorPort.A);
		EV3LargeRegulatedMotor mb = new EV3LargeRegulatedMotor(MotorPort.B);
		EV3LargeRegulatedMotor mc = new EV3LargeRegulatedMotor(MotorPort.C);
		EV3LargeRegulatedMotor md = new EV3LargeRegulatedMotor(MotorPort.D);
		Port colorPort = LocalEV3.get().getPort("S1");
		@SuppressWarnings("resource")
		SampleProvider colorProvider = ((EV3ColorSensor) new EV3ColorSensor(
				colorPort)).getRGBMode();
		V�rintunnistus v�ri = new V�rintunnistus(colorProvider);

		// Yhteyden muodostus
		ServerSocket serv = new ServerSocket(1111);
		Socket s = serv.accept();
		System.out.println("Yhteys muodostettu");
		Delay.msDelay(2000);

		DataInputStream in = new DataInputStream(s.getInputStream());
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		Renkaat renkaat = new Renkaat(ma, mb);
		Kurki kurki = new Kurki(mc);
		Ly�ntik�si k�si = new Ly�ntik�si(md);
		Demo demo = new Demo(v�ri, k�si, renkaat, kurki, in, out);
		renkaat.setNopeus(100);
		kurki.setNopeus(20);

		boolean k�ynniss� = true;
		int i = 0;
		while (k�ynniss�) {
			
			i = in.readInt();
			if (i == 0) {
				renkaat.liikuVasemmalle();
			}
			if (i == 1) {
				renkaat.liikuOikealle();
			}
			if (i == 2) {
				kurki.k��nn�Oikealle();
			}
			if (i == 3) {
				kurki.k��nn�Vasemmalle();
			}
			if (i == 4) {
				k�si.ly�();
			}
			if (i == 5) {
				k�si.vaihdaNopeus();
				out.writeInt(k�si.getNopeus());
				out.flush();
			}
			if (i == 6) {
				
				demo.ajaDemoa();
				
			}

			if (i == -1) {
				// System.out.println(renkaat.tachoLaskuri());
				renkaat.seis();
				kurki.seis();
				k�si.seis();
			}
			if (i == 100) {
				k�ynniss� = false;
			}

			i = -2;
		}
	}
}
