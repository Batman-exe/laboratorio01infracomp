package app;

import java.util.Scanner;

/**
 * Clase que implementa el ejercicio del taller 1 implementando la interfaz Runnable
 * @author Santiago Tangarife
 *
 */
public class Taller1R implements Runnable {

	private int id;

	private int limite;

	private int descanso;
	
	public Taller1R (int id, int limite, int descanso){
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
					try { Thread.sleep(descanso);} catch (InterruptedException e) {e.printStackTrace();}
				}
			}
		}
		else
		{
			for (int i = 1; i <= limite; i++) {
				if(i%2!=0)
					System.out.println("T"+id+": "+i);
				try { Thread.sleep(descanso);} catch (InterruptedException e) {e.printStackTrace();}
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
		
		Thread t1 = new Thread(new Taller1R(0, limit, desc1));
		Thread t2 = new Thread(new Taller1R(1, limit, desc2));
		t1.start();
		t2.start();
	}
}
