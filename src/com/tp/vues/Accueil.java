package com.tp.vues;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.tp.controleurs.Demarrage;

public class Accueil extends JFrame{

	private JLabel labelTempo = new JLabel("Tempo : ");
	private JLabel labelNombreAfficheurs = new JLabel("Nombre d'afficheurs : ");
	private JLabel labelMillisec = new JLabel("millisecondes");
	private JButton boutonValider = new JButton("Valider");
	private ButtonGroup group = new ButtonGroup();
	private JRadioButton radioAtomique = new JRadioButton("Diffusion atomique");
	private JRadioButton radioSequentielle = new JRadioButton("Diffusion séquentielle");
	private JRadioButton radioEpoque = new JRadioButton("Diffusion par époque");
	private JTextField textTempo = new JTextField();
	private JTextField textNombreAfficheurs = new JTextField();
	private JPanel panelTempo = new JPanel();
	private JPanel panelAlgo = new JPanel();
	private JPanel panelNombreAfficheurs = new JPanel();
	private JPanel panelCentral = new JPanel();
	Demarrage demarre;
	int tempo = 1000; // par défaut 1 sec
	int algoDiffusion = 0; // par défaut diffusion atomique
	int nombreAfficheurs = 4; //par défaut 4 afficheurs
	
	public Accueil(){
		super();
		//demarre = d;
		this.setSize(500,310);
		this.setTitle("ACCUEIL");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		Font f=new Font("Arial",Font.PLAIN,14);
		labelTempo.setFont(f);
		labelNombreAfficheurs.setFont(f);
		labelMillisec.setFont(f);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelTempo.setLayout(new FlowLayout());
		textTempo.setPreferredSize(new Dimension(75,20));
		textTempo.setText(String.valueOf(tempo));
		panelTempo.add(labelTempo);
		panelTempo.add(textTempo);
		panelTempo.add(labelMillisec);
		
		panelAlgo.setLayout(new FlowLayout());
		radioAtomique.setSelected(true);
		panelAlgo.add(radioAtomique);
		panelAlgo.add(radioSequentielle);
		panelAlgo.add(radioEpoque);
		group.add(radioAtomique);
		group.add(radioSequentielle);
		group.add(radioEpoque);
		
		panelNombreAfficheurs.setLayout(new FlowLayout());
		textNombreAfficheurs.setPreferredSize(new Dimension(50, 20));
		textNombreAfficheurs.setText(String.valueOf(nombreAfficheurs));
		panelNombreAfficheurs.add(labelNombreAfficheurs);
		panelNombreAfficheurs.add(textNombreAfficheurs);
		
		panelCentral.setLayout(new GridBagLayout());
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth = 1;
		gbc.anchor= GridBagConstraints.FIRST_LINE_START;
		gbc.insets= new Insets(20,0,20,0);
		panelCentral.add(panelTempo,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridheight=1;
		gbc.gridwidth = 1;
		gbc.anchor= GridBagConstraints.LINE_START;
		gbc.insets= new Insets(20,0,20,0);
		panelCentral.add(panelAlgo,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridheight=1;
		gbc.gridwidth = 1;
		gbc.anchor= GridBagConstraints.LINE_START;
		gbc.insets= new Insets(20,0,20,0);
		panelCentral.add(panelNombreAfficheurs,gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.gridheight=1;
		gbc.gridwidth = 1;
		gbc.anchor= GridBagConstraints.LAST_LINE_END;
		gbc.insets= new Insets(20,0,20,0);
		panelCentral.add(boutonValider,gbc);
		
		this.setContentPane(panelCentral);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		//listeners
		
		radioAtomique.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				algoDiffusion = 0;
			}
		});
		
		radioSequentielle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				algoDiffusion = 1;
			}
		});
		
		radioEpoque.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				algoDiffusion = 2;
			}
		});
		
		boutonValider.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
	                tempo = Integer.parseInt(textTempo.getText());
	                nombreAfficheurs = Integer.parseInt(textNombreAfficheurs.getText());
	                demarre = new Demarrage(tempo, algoDiffusion, nombreAfficheurs);
	            }
	            catch (NumberFormatException f) {
	            	JOptionPane boiteDialogue = new JOptionPane();
	            	boiteDialogue.showMessageDialog(null, "Erreur de saisie ! Vérifiez les valeurs du tempo et du nombre d'afficheurs",
	            			"Erreur", JOptionPane.ERROR_MESSAGE);
	            }
			}
		});
		
	}
}
