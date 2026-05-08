import java.util.Scanner;
class Contact {
    String name;
    String phoneNumber;
}
class ContactsManager {
    private Contact[] myFriends;
    private int friendsCount;

    public ContactsManager() {
        this.friendsCount = 0;
        this.myFriends = new Contact[500];
    }

    public void addContact(Contact contact) {
        if (friendsCount < myFriends.length) {
            myFriends[friendsCount] = contact;
            friendsCount++;
        }
    }

    public Contact searchContact(String searchName) {
        for (int i = 0; i < friendsCount; i++) {
            if (myFriends[i].name.equalsIgnoreCase(searchName)) { // ignoreCase rend la recherche plus flexible
                return myFriends[i];
            }
        }
        return null;
    }
}
public class Main {
    public static void main(String[] args) {
        ContactsManager myContactsManager = new ContactsManager();

        addFriend(myContactsManager, "Franck", "0601020304");
        addFriend(myContactsManager, "Bile", "0605060708");
        addFriend(myContactsManager, "Charlie", "0609101112");
        addFriend(myContactsManager, "Jean", "0613141516");
        addFriend(myContactsManager, "Eve", "0617181920");

        Scanner scanner = new Scanner(System.in);
        System.out.println("      Gestionnaire de Contacts      ");
        System.out.print("Entrez le nom de l'ami à rechercher : ");
        String nomRecherche = scanner.nextLine();

        Contact resultat = myContactsManager.searchContact(nomRecherche);
        if (resultat != null) {
            System.out.println("Le numéro de " + resultat.name + " est " + resultat.phoneNumber);
        } else {
            System.out.println("Erreur : Contact introuvable.");
        }

        scanner.close();
    }
    public static void addFriend(ContactsManager manager, String name, String phone) {
        Contact c = new Contact();
        c.name = name;
        c.phoneNumber = phone;
        manager.addContact(c);
    }
}