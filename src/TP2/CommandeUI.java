package TP2;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandeUI {
    private JList listeClients;
    private JList listeCommandes;
    private JButton addClientButton;
    private JButton removeClientButton;
    private JButton addCommandeButton;
    private JButton removeCommandeButton;
    private JPanel panel;

    private BDD db;

    public CommandeUI() {

        db = BDD.getInstance();

        refreshList();

        hideRightList(false);

        listeClients.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Client c = (Client) listeClients.getSelectedValue();

                hideRightList(c != null);

                System.out.println(c);
                setCommandeList(c.getId());
            }

        });


        addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Client c = new Client();

                c.setId(Integer.parseInt(JOptionPane.showInputDialog("Entrez l'Id")));
                c.setPrenom(JOptionPane.showInputDialog("Entrez le prénom"));
                c.setNom(JOptionPane.showInputDialog("Entrez le nom"));

                Client.addClient(c);


                refreshList();
            }
        });
    }


    public void hideRightList(boolean statuts){
        listeCommandes.setEnabled(statuts);
        addCommandeButton.setEnabled(statuts);
        removeCommandeButton.setEnabled(statuts && (listeCommandes.getSelectedValue() != null) );
    }

    public void refreshList(){

        DefaultListModel<Client> model = new DefaultListModel<>();

        listeClients.setModel(model);
        model.removeAllElements();

        for(Client c : Client.getListeClients())
            model.addElement(c);


    }


    public void setCommandeList(int id){

        DefaultListModel<Commande> model = new DefaultListModel<>();

        ArrayList<Commande> commandes = Commande.getCommandes(id);

        for(Commande c : commandes)
            model.addElement(c);

        listeCommandes.setModel(model);
    }


    public static void main(String[] args) {

        CommandeUI cmdUi = new CommandeUI();

        JFrame frame = new JFrame("CommandeUI");
        frame.setContentPane(cmdUi.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
