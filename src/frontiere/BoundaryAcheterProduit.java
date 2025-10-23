package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			String produit = Clavier.entrerChaine("Quel produit voulez vous acheter ?");
			Gaulois[] vendeurs = controlAcheterProduit.trouverProduits(produit);
			if (vendeurs.length == 0) {
				System.out.println("Désolé, personne ne vend ce produit au marché");
			} else {
				int choix = -1;
				while (!(choix >= 0 && choix < vendeurs.length)) {
					System.out.println("Chez quel commerçant voulez vous acheter des ");
					System.out.println(produit);
					for (int i = 0; i < vendeurs.length; i++) {
						StringBuilder chaine = new StringBuilder();
						chaine.append(i + 1);
						chaine.append(" ");
						chaine.append(vendeurs[i].getNom());
						System.out.println(chaine);
					}
					choix = Clavier.entrerEntier("");
					choix--; // régler le décalage de manière décevante
					if (choix >= 0 && choix < vendeurs.length) {
						StringBuilder chaine = new StringBuilder();
						String nomVendeur = vendeurs[choix].getNom();
						chaine.append(nomAcheteur);
						chaine.append(" se déplace jusqu'à l'étal du vendeur ");
						chaine.append(nomVendeur);
						System.out.println(chaine);
						chaine = new StringBuilder();
						chaine.append("Bonjour ");
						chaine.append(nomAcheteur);
						chaine = new StringBuilder();
						chaine.append("Combien de ");
						chaine.append(produit);
						chaine.append(" voulez-vous acheter ?");
						int nombreDeProduits = Clavier.entrerEntier(chaine.toString());
						int nombreDeProduitsDisponible = controlAcheterProduit.quantiteAchetable(nomVendeur);
						if (nombreDeProduitsDisponible > nombreDeProduits) {
							chaine = new StringBuilder();
							chaine.append(nomAcheteur);
							chaine.append(" achète ");
							chaine.append(nombreDeProduits);
							chaine.append(" ");
							chaine.append(produit);
							chaine.append(" à ");
							chaine.append(vendeurs[choix].getNom());
							System.out.println(chaine);
							controlAcheterProduit.acheterProduit(nomVendeur, nombreDeProduitsDisponible);
						} else if (nombreDeProduitsDisponible == 0) {
							System.out.println(nomAcheteur + " veut acheter " + nombreDeProduits + " " + produit
									+ ", malheureusement il n'y en a plus !");
						} else {
							System.out.println(nomAcheteur + " veut acheter " + nombreDeProduits + " " + produit
									+ ", malheureusement" + nomVendeur + " n'en a plus que "
									+ nombreDeProduitsDisponible + "." + nomAcheteur + " achète tout le stock de "
									+ nomVendeur);
							controlAcheterProduit.acheterProduit(nomVendeur, nombreDeProduitsDisponible);
						}
					}
				}
			}

		} else {
			StringBuilder chaine = new StringBuilder();
			chaine.append("Je suis désolée ");
			chaine.append(nomAcheteur);
			chaine.append(" mais il faut être un habitant pour commercer ici.");
			System.out.println(chaine);
		}
	}
}
