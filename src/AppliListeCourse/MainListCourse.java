package AppliListeCourse;

import java.io.IOException;
import java.util.Scanner;

public class MainListCourse {

    static final Scanner in = new Scanner(System.in);
    static String path;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        if(args.length != 1) return;

        path = args[0];

        System.out.println("Bienvenu dans la super appli des course !!!");

        affMenu();


        ListeCourse liste = new ListeCourse();
        MenuListCourse mnlc = new MenuListCourse(liste,in);
        ListCourseLoader lcl = new ListCourseLoader(liste,path);
        ListCourseSaver lcs = new ListCourseSaver(liste,path);

        for (String choix = in.next(); !choix.equals("4") ; choix = in.next()) {

            if(choix.equals("1")) mnlc.initInteractive();
            else if(choix.equals("2")){liste = new ListeCourse(); lcl.load();}
            else if(choix.equals("3"))lcs.save();
            else System.out.println("choix invalide !");

            affMenu();

        }

    }


    public static void affMenu(){

        System.out.println("----Menu----");
        System.out.println("1: Saisir une nouvelle liste");
        System.out.println("2: Ouvrir liste course");
        System.out.println("3: Enregistrer liste course");
        System.out.println("4: Quitter");
    }


}
