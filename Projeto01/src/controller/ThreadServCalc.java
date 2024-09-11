package controller;

import java.util.concurrent.Semaphore;

public class ThreadServCalc extends Thread {

	private int calc;
	private int tempo;
	private int vezes1;
	private int vezes2;
	private int idThread;
	private Semaphore mutex;

	public ThreadServCalc(int idThread, Semaphore mutex) {
		this.idThread = idThread;
		this.mutex = mutex;

	}

	@Override
	public void run() {
		Calculos();

		try {
			mutex.acquire();
			BancoDados();
		} catch (Exception e) {

		} finally {
			mutex.release();
		}
	}

	private void Calculos() {

		if (idThread % 3 == 1) {
			calc = (int) ((Math.random() * 201) + 800);
			System.out.println("#" + idThread + " Fazendo cálculos em " + calc + " milissegundos");
			try {
				sleep(calc);
			} catch (Exception e) {

			}
			tempo = 1000;
			if (vezes2 == 1) {
				BancoDados();
				vezes2++;
			}
		} else {
			if (idThread % 3 == 2) {
				calc = (int) ((Math.random() * 501) + 1000);
				System.out.println("#" + idThread + " Fazendo cálculos em " + calc + " milissegundos");
				try {
					sleep(calc);
				} catch (Exception e) {

				}
				tempo = 1500;
				if (vezes2 == 1 || vezes2 == 2) {
					BancoDados();
					vezes2++;
				}
			} else {
				if (idThread % 3 == 0) {
					calc = (int) ((Math.random() * 1001) + 1001);
					System.out.println("#" + idThread + " Fazendo cálculos em " + calc + " milissegundos");
					try {
						sleep(calc);
					} catch (Exception e) {

					}
					tempo = 1500;
					if (vezes2 == 1 || vezes2 == 2) {
						BancoDados();
						vezes2++;
					}
				}
			}
		}

	}

	private void BancoDados() {

		if (idThread % 3 == 1) {
			System.out.println("#" + idThread + " Fazendo transação com o banco de dados por 1 segundo");
			try {
				sleep(tempo);
			} catch (Exception e) {

			}
			if (vezes1 == 0 || vezes1 == 1) {
				vezes2++;
				Calculos();
				vezes1++;
			}
		}
		if (idThread % 3 == 2) {
			System.out.println("#" + idThread + " Fazendo transação com o banco de dados por 1,5 segundos");
			try {
				sleep(tempo);
			} catch (Exception e) {

			}
			if (vezes1 == 0 || vezes1 == 1 || vezes1 == 2) {
				vezes2++;
				Calculos();
				vezes1++;
			}
		}
		if (idThread % 3 == 0) {
			System.out.println("#" + idThread + " Fazendo transação com o banco de dados por 1,5 segundos");
			try {
				sleep(tempo);
			} catch (Exception e) {

			}
			if (vezes1 == 0 || vezes1 == 1 || vezes1 == 2) {
				vezes2++;
				Calculos();
				vezes1++;
			}
		}
	}

}
