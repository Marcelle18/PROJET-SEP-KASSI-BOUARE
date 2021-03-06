package com.tp.controleurs;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.tp.interfaces.IObservateur;

/**
 * Classe Diffusion s�quentielle, h�ritant de la classe Diffusion et 
 * d�fnissant l'algorithme de diffusion s�quentielle, impl�mentant ActiveObject
 * pour la diffusion de la valeur du capteur.
 * 
 *@see Diffusion
 */
public class DiffusionSequentielle extends Diffusion{

	int valeurCourante; //valeur du capteur
	boolean lectureComplete = true; // vrai si tous les afficheurs on lu la valeur courante
	int nombreLecture = 0; // nombre d'afficheurs ayant lu la valeur courante
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if(lectureComplete){
			
			nombreLecture = 0;
			lectureComplete = false;
			valeurCourante = capteur.getValue();
			
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
	}

	/**
	 * @see com.tp.interfaces.IAlgoDiffusion#retournerValeur()
	 */
	@Override
	public int retournerValeur() {
		// TODO Auto-generated method stub
		nombreLecture++;
		lectureComplete = (nombreLecture == nombreObservateurs);
		return valeurCourante;
	}

}
