package com.tp.vues;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tp.controleurs.Afficheur;

public class FenetreAfficheur extends JFrame{
	private JPanel panel = new JPanel();
	private JLabel labelNumAfficheur = new JLabel("Afficheur N° ");
	private JLabel labelValeur = new JLabel("Valeur = ");
	Afficheur affiche;
	
	public FenetreAfficheur(Afficheur aff){
		super();
		affiche = aff;
		this.setSize(new Dimension(150, 200));
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		panel.setLayout(new GridLayout(2,1));
		panel.add(labelNumAfficheur);
		panel.add(labelValeur);
		this.setContentPane(panel);
	}
	
	public void setNumAfficheur(int numero){
		labelNumAfficheur.setText("Afficheur N° "+numero);
		this.setLocation(50 + (200 * ((numero - 1) % 5)), 50 + ((numero-1) / 5) * 220);
	}
	
	public void setValeur(int valeur){
		labelValeur.setText("Valeur = "+valeur);
	}
	
}
