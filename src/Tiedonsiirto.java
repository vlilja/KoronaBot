import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Tiedonsiirto {

	private DataInputStream in;
	private DataOutputStream out;
	private Socket s;
	private volatile boolean käytössä = false;

	public Tiedonsiirto() {
		Socket s = null;
		try {
			s = new Socket("10.0.1.1", 1111);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.in = null;
		try {
			out = new DataOutputStream(s.getOutputStream());
			in = new DataInputStream(s.getInputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

	public boolean lähetäTietoa(int x) {

		try {
			out.writeInt(x);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("Tietoalähti" + System.nanoTime());
		return false;
	}

	public int vastaanotaTietoa() {
		int x = 0;
		try {
			x = in.readInt();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// System.out.println("Tietoalähti" + System.nanoTime());
		return x;
	}

	public void lopetaOhjelma() {
		try {
			out.writeInt(100);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("Tietoalähti" + System.nanoTime());
	}

	public DataOutputStream getOutput() {	

		return out;
	}
	
	public DataInputStream getInput(){
		
		return in;
	}

}
