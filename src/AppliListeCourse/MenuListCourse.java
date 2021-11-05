package AppliListeCourse;

import java.util.Scanner;

public class MenuListCourse {

    private ListeCourse list;
    private Scanner in;


    public MenuListCourse(ListeCourse list,Scanner in) {
        this.list = list;
        this.in = in;
    }

    public void initInteractive(){
        if(in == null || list == null) System.err.println("Erreur! l'un des paramètres est nul");

        System.out.println("---Entrez les elements ('stop' pour arreter)----");

        for (String el = in.next(); !el.equalsIgnoreCase("stop") ; el = in.next()) {

            //pour afficher ce qu'on a déja mit dans la liste
            if(el.equalsIgnoreCase("see")){
                afficherListe();
                continue;
            }

            list.addArticle(el);
        }

        System.out.println("\n----Fin Traitement----");
    }

    public void afficherListe(){
        System.out.println("-Liste-Actuelle-");

        for (String m : list.getArticles()) System.out.println(m);

        System.out.println("--------");
    }
}
