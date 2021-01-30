package app;

import java.util.Scanner;

/**
 * Clase que implemeta el ejercicion del taller 1 extendiendo de thread.
 * @author Santiago Tangarife
 *
 */
public class Taller1 extends Thread {

	private int id;

	private int limite;

	private int descanso;
	
	public Taller1 (int id, int limite, int descanso){
		this.id = id;
		this.limite = limite;
		this.descanso = descanso;
	}

	public void run()
	{
		if(id%2==0)
		{
			for (int i = 1; i <= limite; i++) {
				if(i%2==0)
				{
					System.out.println("T"+id+": "+i);
					try { this.sleep(descanso);} catch (InterruptedException e) {e.printStackTrace();}
				}
			}
		}
		else
		{
			for (int i = 1; i <= limite; i++) {
				if(i%2!=0)
					System.out.println("T"+id+": "+i);
				try { this.sleep(descanso);} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
	}
	
	public static void main(String[] args) {
		int limit =0;
		int desc1 = 0;
		int desc2 = 0;
		Scanner lec = new Scanner(System.in);
		System.out.println("Ingrese el limite superior: ");
		limit = lec.nextInt();
		System.out.println("Ingrese el tiempo(ms) de espera del primer thread: ");
		desc1 = lec.nextInt();
		System.out.println("Ingrese el tiempo(ms) de espera del segundo thread: ");
		desc2 = lec.nextInt();
		
		Taller1 t1 = new Taller1(0, limit, desc1);
		Taller1 t2 = new Taller1(1, limit, desc2);
		t1.start();
		t2.start();
	}

}
