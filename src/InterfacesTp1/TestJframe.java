package InterfacesTp1;

import AppliListeCourse.ListCourseLoader;
import AppliListeCourse.ListCourseSaver;
import AppliListeCourse.ListeCourse;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class TestJframe {
    private JPanel panel1;
    private JList list1;
    private JButton bouttonSupprimer;
    private JButton bouttonAjouter;
    private JButton buttonMinus;
    private JButton buttonPlus;
    private JLabel label;


    private int counter = 0;


    private JMenuBar menuBar;

    private ListCourseLoader coursesLoader;
    private ListCourseSaver courseSaver;
    private ListeCourse listeArticles;

    private String path = "";

    private JFileChooser fc;



    boolean saved = true;
    String fileName;

    public TestJframe() {

        menuBar = new JMenuBar();
        listeArticles = new ListeCourse();
        fc = new JFileChooser();


        coursesLoader = new ListCourseLoader(listeArticles,path);
        courseSaver = new ListCourseSaver(listeArticles,path);


        //region MenuBar
        JMenu fichier = new JMenu("Fichier");

        JMenuItem ouvrir = new JMenuItem("Ouvrir");
            ouvrir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("OuvrirLol");

                    fc.setCurrentDirectory(new File("./"));
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

                    if(fc.showDialog(null,"Ouvrir") != JFileChooser.APPROVE_OPTION)
                        return;

                    String npath = fc.getSelectedFile().getPath();

                    courseSaver.setPath(npath);
                    coursesLoader.setPath(npath);

                    try {
                        coursesLoader.load();
                        refreshList();
                        saved = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });


        JMenuItem enregistrer = new JMenuItem("Enregistrer");
            enregistrer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("Enregistrer lol");
                    if(path.isEmpty()) enregistrerSous();
                    else save();
                }
            });


        JMenuItem changerEmplacement = new JMenuItem("Enregistrer sous...");
        changerEmplacement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                enregistrerSous();
            }
        });

        fichier.add(ouvrir);
        fichier.add(enregistrer);
        fichier.add(changerEmplacement);

        menuBar.add(fichier);

        //endregion

        //region bouttonsPourLaListe
        bouttonAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nomEl = JOptionPane.showInputDialog("Entrez le nom de l'élément");

                if(!listeArticles.addArticle(nomEl)){
                    JOptionPane.showMessageDialog(null,"Erreur l'élément existe déja !","Erreur",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                refreshList();
                saved = false;

            }
        });


        bouttonSupprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                List<String> elements = list1.getSelectedValuesList();

                if(JOptionPane.showConfirmDialog(null,"Voulez vous vraiment supprimer les éléments ?","Confirmez",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE) == 1){
                    return;
                }

                for (String el: elements)
                    listeArticles.removeArticle(el);

                refreshList();
                saved = false;
            }
        });

        //endregion

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                bouttonSupprimer.setEnabled(!list1.getSelectedValuesList().isEmpty());
            }
        });
    }

    private void save() {
        try {
            courseSaver.save();
            saved = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void refreshList(){
        DefaultListModel<String> model = new DefaultListModel<>();

        List<String> tmp = Arrays.asList(listeArticles.getArticles());

        for(String item : tmp)
            model.addElement(item);



        list1.setModel(model);

    }


    private void enregistrerSous(){
        fc.setCurrentDirectory(new File("./"));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnVal = fc.showDialog(null,"Choisir");

        if(returnVal == JFileChooser.APPROVE_OPTION){
            path = fc.getSelectedFile().getPath();
            System.out.println(path);
        }else{
            return;
        }

        System.out.println(path);

        coursesLoader.setPath(path);
        courseSaver.setPath(path);

        save();
    }


    public static void main(String[] args) {




        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("TestJframe");
        TestJframe tsJf = new TestJframe();

        frame.setContentPane(tsJf.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(!tsJf.saved){
                    int choix = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment quitter sans sauvegarder ?", "Attention",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);

                    switch (choix){
                        case JOptionPane.YES_OPTION:
                            System.exit(0);
                        case JOptionPane.NO_OPTION:
                            if(tsJf.path.isEmpty()) tsJf.enregistrerSous();
                            else tsJf.save();
                            System.exit(0);
                        case JOptionPane.CANCEL_OPTION:
                            break;
                    }
                }
                else{
                    System.exit(0);
                }
            }
        });

        frame.setJMenuBar(tsJf.menuBar);

        frame.pack();
        frame.setVisible(true);
    }
}
