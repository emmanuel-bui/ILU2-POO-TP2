package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		} else {
			StringBuilder chaine = new StringBuilder();
			chaine.append(nomAcheteur);
			chaine.append(", vous trouverez au marché : ");
			System.out.println(chaine);
			for (int i = 0; i < infosMarche.length / 3; i++) {
				StringBuilder chaine2 = new StringBuilder();
				chaine2.append("-");
				chaine2.append(infosMarche[i]);
				i++;
				chaine2.append(" qui vend ");
				chaine2.append(infosMarche[i]);
				i++;
				chaine2.append(" ");
				chaine2.append(infosMarche[i]);
				System.out.println(chaine2);
			}
		}
	}
}
