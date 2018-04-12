package presentation;

import java.util.Scanner;

import dAO.ClientDAO;
import dAO.CompteCourantDAO;
import dAO.CompteEpargneDAO;
import dAO.LoginDAO;
import domaine.Client;
import domaine.Epargne;
import domaine.Login;
import service.ClientService;
import service.LoginService;


public class Lanceur {
	public static void main(String[] args) {
		ClientService serviceClient = new ClientService();
		Client client = new Client();
		Epargne compte = new Epargne();

		LoginService loginServiceDAO = new LoginService();
		Login login = new Login ("championDu69", "693512");
		
		
		//		loginServiceDAO.Connexion(employeDAO, loginDAO, login);


//		compte.setIdCompte(23);
//dao.creerClient(client);
//dao.getClient(client);
//compte.setSolde(10500);
//
//		dao.updateClient(client);
//	
//dao.deleteClient(client);
//	System.out.println(dao.getAll());


//		System.out.println(compteDAO.getCompte(compte));
//		
//		int selection;
//		Scanner a = new Scanner(System.in);
//		Scanner b = new Scanner(System.in);
//		Scanner c = new Scanner(System.in);
//		do {
//			System.out.println("Que voulez vous faire ?");
//			System.out.println("1 - Créer un nouveau client");
//			System.out.println("2 - Afficher un client");
//			System.out.println("3 - Modifier un client");
//			System.out.println("4 - Supprimer un client");
//			System.out.println("5 - Afficher tout les clients");
//			System.out.println("6 - Quitter");
//
//			do {
//				selection = a.nextInt();
//				switch (selection) {
//				case (1):
//					System.out.println("Veuillez rentrer le nom du client");
//					client.setNom(b.nextLine());
//					System.out.println("Veuillez rentrer le prenom du client");
//					client.setPrenom(b.nextLine());
//					System.out.println("Veuillez rentrer l'idConseiller du client");
//					client.setIdConseiller(c.nextInt());
//					System.out.println("Veuillez rentrer l'age du client");
//					client.setAge(c.nextInt());
//
//					System.out.println(serviceClient.creerClient(dao, client));
//
//					break;
//				case (2):
//					System.out.println("Veuillez rentrer l'ID client");
//					System.out.println(serviceClient.getClient(dao, c.nextInt(), client));
//
//					break;
//
//				case (3):
//					System.out.println("Veuillez rentrer le nouveau nom du client");
//					client.setNom(b.nextLine());
//					System.out.println("Veuillez rentrer le nouveau prenom du client");
//					client.setPrenom(b.nextLine());
//					System.out.println("Veuillez rentrer le nouveau idConseiller du client");
//					client.setIdConseiller(c.nextInt());
//					System.out.println("Veuillez rentrer le nouvel age du client");
//					client.setAge(c.nextInt());
//
//					System.out.println(serviceClient.updateClient(dao, client));
//
//					break;
//
//				case (4):
//					System.out.println(serviceClient.deleteClient(dao, client));
//
//					break;
//
//				case (5):
//					serviceClient.getAll(dao);
//				case (6):
//					System.out.println("Au revoir");
//
//					break;
//				default:
//					System.out.println("Choix non reconnu");
//				}
//				
//			} while (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5
//					&& selection != 6);
//		} while (selection != 6);
//		a.close();
//		b.close();
//		c.close();
	}
}
