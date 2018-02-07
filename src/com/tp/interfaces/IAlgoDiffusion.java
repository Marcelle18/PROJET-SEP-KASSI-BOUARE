package com.tp.interfaces;

public interface IAlgoDiffusion {

	void configure(ICapteur capteur);
	
	void execute();
	
	int retournerValeur();
}
