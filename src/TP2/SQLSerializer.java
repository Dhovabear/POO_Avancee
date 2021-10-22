package TP2;

import java.lang.reflect.*;

public class SQLSerializer<T> {

    public SQLSerializer(){

    }

    /**
     * Fonction de ouf guedin qui va renvoyer un objet de la classe donné
     * et le faire initaliser interactivement
     * @param c
     * @return
     */
    public T prompt(Class<T> c){

        System.out.println(c.getName());
        Field[] champs = c.getDeclaredFields();


        //a voir plus tard
        try {

            Constructor<?> construct = c.getConstructor();

            Object instance = construct.newInstance();

            System.out.println(instance.getClass().getCanonicalName());

            for(Field field : champs){
                boolean formatGood = false;
                do{

                    if(Modifier.isStatic(field.getModifiers())) break;

                    Class fieldType = field.getType();
                    System.out.println("Entrez le champ "+field.getName()+" "+fieldType.getSimpleName()+" : ");

                    String choix = Main.in.next();

                    field.setAccessible(true);


                    if(fieldType.getSimpleName().equals("int")){
                        try{
                            field.set(instance,Integer.parseInt(choix));
                        }catch (NumberFormatException e){
                            System.out.println("Erreur veuillez entrer un Int !");
                            continue;
                        }
                        formatGood = true;
                    }else if(fieldType.getSimpleName().equals("double")){
                        try{
                            field.set(instance,Double.parseDouble(choix));
                        }catch (NumberFormatException e){
                            System.out.println("Erreur veuillez entrer un Double !");
                            continue;
                        }
                        formatGood = true;
                    }else if(fieldType.getSimpleName().equals("float")){
                        try{
                            field.set(instance,Float.parseFloat(choix));
                        }catch (NumberFormatException e){
                            System.out.println("Erreur veuillez entrer un Float !");
                            continue;
                        }
                        formatGood = true;
                    }else if(fieldType.getSimpleName().equals("String")){
                        field.set(instance,choix);
                        formatGood = true;
                    }

                    field.setAccessible(false);

                }while (!formatGood);
            }

            return (T)instance;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Client cl = (new SQLSerializer<Client>()).prompt(Client.class);
        Commande c = (new SQLSerializer<Commande>()).prompt(Commande.class);

        System.out.println(cl);




        System.out.println(c);
    }

}
