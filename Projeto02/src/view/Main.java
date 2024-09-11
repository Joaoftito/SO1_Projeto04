package view;

import controller.ThreadCozinha;
import java.util.concurrent.Semaphore;

public class Main {
	
	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore mutex = new Semaphore(permissoes);
		
		for (int idPrato = 1 ; idPrato <= 5 ; idPrato ++) {
			Thread thread = new ThreadCozinha(idPrato, mutex);
			thread.start();
		}
	}

}
