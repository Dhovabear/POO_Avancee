package AppliListeCourse;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class ListCourseSaver {

    private ListeCourse list;
    private String path;

    public ListCourseSaver(ListeCourse list, String path) {
        this.list = list;
        this.path = path;
    }


    public void setPath(String path) {
        this.path = path;
    }

    public void save() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));

        out.writeObject(Calendar.getInstance().getTime());
        for(String art : list.getArticles()) out.writeObject(art);
    }

}
