package com.tp.controleurs;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.tp.interfaces.IAlgoDiffusion;
import com.tp.interfaces.ICapteur;
import com.tp.interfaces.IObservateur;

/**
 * Classe permettant d'actualiser la valeur diffus�e par le capteur observ� en impl�mentant 
 * le patron ActiveObject et de l'envoyer � l'afficheur.
 * <p>Elle est compos�e de :
 * <ul>
 * <li>l'algorithme de diffusion utilis�</li>
 * <li>son num�ro qui �quivaut au num�ro de l'afficheur</li>
 * <li>l'afficheur auquel elle envoie la valeur du capteur</li>
 * </ul>
 * </p>
 * @see com.tp.interfaces.IObservateur
 * @see com.tp.interfaces ICapteur
 * @see Afficheur
 *
 */
public class Canal implements IObservateur, ICapteur{

	/**
	 * Valeur diffus�e par le capteur observ�
	 * @see Canal#getValue()
	 */
	int valeur;
	
	/**
	 * Num�ro du canal
	 * @see Canal#Canal()
	 */
	int numeroCanal;
	static int nombreCanal;
	
	/**
	 * Algorithme de diffusion utilis� par le capteur
	 * @see Canal#getValue()
	 * @see Canal#actualiser(ICapteur)
	 */
	IAlgoDiffusion algoDiffusion;
	
	/**
	 * Afficheur du canal
	 * @see Canal#Canal()
	 */
	Afficheur afficheur;
	
	/**
	 * Constructeur du canal. D�finit le num�ro du canal et instancie l'afficheur avec son num�ro
	 * @see Afficheur#Afficheur(int)
	 */
	public Canal(){
		nombreCanal++;
		numeroCanal = nombreCanal;
		afficheur = new Afficheur(numeroCanal);
	}
	
	
	@Override
	public void attach(IObservateur obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(IObservateur obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<IObservateur> getObservateur() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * M�thiode pour r�cup�rer la valeur diffus�e par le capteur
	 * @return La valeur diffus�e par le capteur
	 */
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		valeur = this.algoDiffusion.retournerValeur();
		System.out.println("Canal "+numeroCanal+" getValue : "+valeur);
		return valeur;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Capteur getCapteur() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * M�thode permettant d'actualiser la valeur diffus�e par le capteur en interalles de temps al�atoires avec Activeobject.
	 * @see Afficheur#actualiser(ICapteur)
	 */
	@Override
	public void actualiser(ICapteur capteur) {
		// TODO Auto-generated method stub
		//implementer r�ception des infos du capteur
		algoDiffusion = capteur.getCapteur().algoDiffusion;
		System.out.println("Mise � jour du canal : "+numeroCanal);
		
		Random r = new Random();
		int intervalle = 500 + r.nextInt(1000 - 500);
		ScheduledExecutorService execution = Executors.newScheduledThreadPool(nombreCanal);

		ScheduledFuture<Object> execFuture = execution.schedule(new Callable<Object>() {
		        public Object call() throws Exception {
		        			        	
		        	afficheur.actualiser(Canal.this);

		            return null;
		        }
		    }, intervalle, TimeUnit.MILLISECONDS);
		
		
		try {
			execFuture.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("Mise � jour du canal - Tempo : " + numeroCanal);
		
	}


}
