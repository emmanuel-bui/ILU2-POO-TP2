package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (controlLibererEtal.isVendeur(nomVendeur)) {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			StringBuilder chaine = new StringBuilder();
			chaine.append("Vous avez vendu ");
			chaine.append(donneesEtal[4]);
			chaine.append(" sur ");
			chaine.append(donneesEtal[3]);
			chaine.append(" ");
			chaine.append(donneesEtal[2]);
			System.out.println(chaine);
			StringBuilder chaine2 = new StringBuilder();
			chaine2.append("En revoir ");
			chaine2.append(nomVendeur);
			chaine2.append("passez une bonne journée.");
			System.out.println(chaine2);
		} else {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}
	}

}
