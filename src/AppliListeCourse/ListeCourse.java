package AppliListeCourse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListeCourse {

    private HashSet<String> courses;

    public ListeCourse() {
        courses = new HashSet<>();
    }

    public String[] getArticles(){
        return courses.toArray(new String[0]);
    }

    public boolean addArticle(String article){
        return courses.add(article);
    }

    public boolean removeArticle(String article){
        return courses.remove(article);
    }

    public void clear() {
        courses.clear();
    }
}
