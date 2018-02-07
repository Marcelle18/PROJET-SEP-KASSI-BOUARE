package com.tp.controleurs;

import com.tp.interfaces.*;

public abstract class Diffusion implements IAlgoDiffusion{
	
	ICapteur capteur;
	int nombreObservateurs;
	
	public void configure(ICapteur cap){
		this.capteur = cap;
		this.nombreObservateurs = cap.getObservateur().size();
	}
	
	abstract public void execute();
	
	abstract public int retournerValeur();
}
