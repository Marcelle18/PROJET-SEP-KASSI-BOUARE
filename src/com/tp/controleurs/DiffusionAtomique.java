package com.tp.controleurs;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.tp.interfaces.IObservateur;

/**
 * Classe Diffusion atomique, héritant de la classe Diffusion et 
 * défnissant l'algorithme de diffusion atomique, implémentant ActiveObject
 * pour la diffusion de la valeur du capteur.
 * 
 *@see Diffusion
 */
public class DiffusionAtomique extends Diffusion{

	/**
	 * @see com.tp.interfaces.IAlgoDiffusion#execute()
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ExecutorService execution = Executors.newFixedThreadPool(nombreObservateurs);
		ArrayList<Future<Void>> futures = new ArrayList<>();
		ArrayList<Callable<Void>> appels = new ArrayList<>();
		
		for(final IObservateur observateur : capteur.getObservateur()){
			
			Callable<Void> tache = new Callable<Void>() {
				@Override
				public Void call() throws Exception {
					observateur.actualiser(capteur);
					return null;
				}
			};
			
			appels.add(tache);
			futures.add(execution.submit(tache));
		}
		
		
		for(Future<Void> future : futures){
			try {
				future.get();
				System.out.println("Retourne Future");
				System.out.flush();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see com.tp.interfaces.IAlgoDiffusion#retournerValeur()
	 */
	@Override
	public int retournerValeur() {
		// TODO Auto-generated method stub
		return capteur.getValue();
	}

}
