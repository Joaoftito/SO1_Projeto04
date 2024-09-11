package view;

import controller.ThreadServCalc;
import java.util.concurrent.Semaphore;

public class Main {
	
	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore mutex = new Semaphore(permissoes);
		
		for (int idThread = 1 ; idThread <= 21 ; idThread ++) {
			Thread thread = new ThreadServCalc(idThread, mutex);
			thread.start();
		}
		
	}

}
