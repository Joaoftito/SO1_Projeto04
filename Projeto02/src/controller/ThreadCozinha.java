package controller;

import java.util.concurrent.Semaphore;

public class ThreadCozinha extends Thread {

	private int idPratos;
	private Semaphore mutex;
	private int tempo;
	private int percentual;

	public ThreadCozinha(int idPratos, Semaphore mutex) {
		this.idPratos = idPratos;
		this.mutex = mutex;
	}

	@Override
	public void run() {
		Cozimento();
		try {
			mutex.acquire();
			Entrega();
		} catch (Exception e) {

		} finally {
			mutex.release();
		}
	}

	private void Cozimento() {

		if (idPratos % 2 != 0) {
			System.out.println("#" + idPratos + " Sopa de cebola iniciou o cozimento");
			tempo = (int) ((Math.random() * 501) + 300);
			percentual = tempo / 100;
			int aux = percentual;
			while (percentual < 100) {
				try {
					sleep(100);
				} catch (Exception e) {

				}
				System.out.println("#" + idPratos + " A sopa de cebola está " + percentual + "% concluída");
				percentual = percentual + aux;
			}
			System.out.println("#" + idPratos + " A sopa de cebola está " + "100% concluída");
		} else {
			System.out.println("#" + idPratos + " Lasanha a bolonhesa se iniciou o cozimento");
			tempo = (int) ((Math.random() * 601) + 600);
			percentual = tempo / 100;
			int aux = percentual;
			while (percentual < 100) {
				try {
					sleep(100);
				} catch (Exception e) {

				}
				System.out.println("#" + idPratos + " A lasanha a bolonhesa está " + percentual + "% concluída");
				percentual = percentual + aux;
			}
			System.out.println("#" + idPratos + " A lasanha a bolonhesa está " + "100% concluída");
		}
	}

	private void Entrega() {

		if (idPratos % 2 != 0) {
			try {
				sleep(500);
			} catch (Exception e) {

			}
			System.out.println("#" + idPratos + " A sopa de cebola foi entregue!");
		} else {
			try {
				sleep(500);
			} catch (Exception e) {

			}
			System.out.println("#" + idPratos + " A lasanha a bolonhesa foi entregue!");
		}
	}

}
