package com.tp.controleurs;

import java.util.HashMap;

public class DiffusionEpoque extends Diffusion{

	HashMap<Integer, Integer> tableValeurs = new HashMap<>();
	int estampille = 0;
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		estampille++;
		tableValeurs.put(estampille, capteur.getValue());
		//envoyer avec biblio java pour ActiveObject
	}

	@Override
	public int retournerValeur() {
		// TODO Auto-generated method stub
		return tableValeurs.get(estampille);
	}

}
