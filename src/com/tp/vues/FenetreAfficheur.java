package com.tp.vues;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tp.controleurs.Afficheur;

/**
 * <b>Interface graphique d'un afficheur</b>
 * <p>
 * Permet d'afficher :
 * <ul>
 * <li>le num�ro de l'afficheur</li>
 * <li>la valeur du capteur</li>
 * </ul>
 * </p>
 *
 *@see Afficheur
 */
public class FenetreAfficheur extends JFrame{
	private JPanel panel = new JPanel();
	
	/**
	 * Label pour afficher le num�ro de l'afficheur
	 * @see FenetreAfficheur#setNumAfficheur(int)
	 */
	private JLabel labelNumAfficheur = new JLabel("Afficheur N� ");
	
	/**
	 * Label pour afficher la valeur du capteur
	 * @see FenetreAfficheur#setValeur(int)
	 */
	private JLabel labelValeur = new JLabel("Valeur = ");
	
	/**
	 * <p>Controleur de l'afficheur permettant d'obtenir :
	 * <ul>
	 * <li>le num�ro de l'afficheur � afficher</li>
	 * <li>la valeur du capteur � afficher</li>
	 * </ul>
	 * </p>
	 * @see Afficheur
	 */
	Afficheur affiche;
	
	
	/**
	 * Constructeur de la fen�tre
	 * <p>A la construction de la fen�tre, on n'a que les valeurs par d�fauts des labels qui sont : 
	 * <ul>
	 * <li>le num�ro de l'afficheur : "Afficheur N�"</li>
	 * <li>la valeur du capteur : "valeur ="</li>
	 * </ul>
	 * </p>
	 * @param afficheur
	 */
	public FenetreAfficheur(Afficheur afficheur){
		super();
		affiche = afficheur;
		this.setSize(new Dimension(150, 200));
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		panel.setLayout(new GridLayout(2,1));
		panel.add(labelNumAfficheur);
		panel.add(labelValeur);
		this.setContentPane(panel);
	}
	
	/**
	 * M�thode pour mettre � jour le num�ro de l'afficheur
	 * @param numero
	 */
	public void setNumAfficheur(int numero){
		labelNumAfficheur.setText("Afficheur N� "+numero);
		this.setLocation(50 + (200 * ((numero - 1) % 5)), 50 + ((numero-1) / 5) * 220);
	}
	
	/**
	 * M�thode pour mettre � jour la valeur du capteur
	 * @param valeur
	 */
	public void setValeur(int valeur){
		labelValeur.setText("Valeur = "+valeur);
	}
	
}
