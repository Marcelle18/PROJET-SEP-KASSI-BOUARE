package com.tp.interfaces;

import java.util.ArrayList;

import com.tp.controleurs.Capteur;

public interface ICapteur extends ISujetObserver{

	ArrayList<IObservateur> getObservateur();
	
	int getValue();
	
	void tick();
	
	Capteur getCapteur();
}
