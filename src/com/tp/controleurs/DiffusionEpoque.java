package com.tp.controleurs;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.tp.interfaces.IObservateur;

/**
 * Classe Diffusion par époque, héritant de la classe Diffusion et 
 * défnissant l'algorithme de diffusion par époque, implémentant ActiveObject
 * pour la diffusion de la valeur du capteur.
 * 
 *@see Diffusion
 */
public class DiffusionEpoque extends Diffusion{

	HashMap<Integer, Integer> tableValeurs = new HashMap<>();
	int estampille = 0;
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		estampille++;
		tableValeurs.put(estampille, capteur.getValue());
					
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
	}

	/**
	 * @see com.tp.interfaces.IAlgoDiffusion#retournerValeur()
	 */
	@Override
	public int retournerValeur() {
		// TODO Auto-generated method stub
		return tableValeurs.get(estampille);
	}

}
