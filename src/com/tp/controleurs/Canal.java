package com.tp.controleurs;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.tp.interfaces.IAlgoDiffusion;
import com.tp.interfaces.ICapteur;
import com.tp.interfaces.IObservateur;

public class Canal implements IObservateur, ICapteur{

	int valeur;
	int numeroCanal;
	static int nombreCanal;
	IAlgoDiffusion algoDiffusion;
	Afficheur afficheur;
	
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

	@Override
	public void actualiser(ICapteur capteur) {
		// TODO Auto-generated method stub
		//implementer réception des infos du capteur
		algoDiffusion = capteur.getCapteur().algoDiffusion;
		System.out.println("Mise à jour du canal : "+numeroCanal);
		
		ScheduledExecutorService pilExec = Executors.newScheduledThreadPool(nombreCanal);

		ScheduledFuture<Object> execFuture = pilExec.schedule(new Callable<Object>() {
		        public Object call() throws Exception {
		        			        	
		        	afficheur.actualiser(Canal.this);

		            return null;
		        }
		    }, numeroCanal*500, TimeUnit.MILLISECONDS);
		
		
		try {
			execFuture.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("Mise à jour du canal - Tempo : " + numeroCanal);
		
	}


}
