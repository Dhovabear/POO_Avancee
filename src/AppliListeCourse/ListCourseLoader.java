package AppliListeCourse;

import java.io.*;

public class ListCourseLoader {
    private ListeCourse list;
    private String path;

    public ListCourseLoader(ListeCourse list, String path) {
        this.list = list;
        this.path = path;
    }


    public void setPath(String path){
        this.path = path;
    }

    public void load() throws IOException, ClassNotFoundException {


        list.clear();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));

        in.readObject();



        try{
            for(String art = (String) in.readObject(); art != null || art.equals(""); art = (String) in.readObject()){
                list.addArticle(art);
            }
        }catch (EOFException e){

        }


    }
}
