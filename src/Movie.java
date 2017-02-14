/*
 * Created by Jeff Choi on 2/14/17.
 */
public class Movie {
    private String title;
    private String category;

    public Movie() {
        title = "";
        category = "";
    }

    public Movie(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }


}
