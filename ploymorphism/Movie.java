package ploymorphism;

public class Movie {

    private String title;
    private String director;
    private String releaseDate;
    private String duration;
    private String language;

    public Movie(String title, String director, String releaseDate, String duration, String language) {
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", duration='" + duration + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
class RomComMovie extends Movie {
    private String leadHero;
    private String leadHeroine;

    public String getLeadHero() {
        return leadHero;
    }

    public RomComMovie(String title, String director, String releaseDate, String duration, String language, String leadHero, String leadHeroine) {
        super(title, director, releaseDate, duration, language);
        this.leadHero = leadHero;
        this.leadHeroine = leadHeroine;
    }

    public void setLeadHero(String leadHero) {
        this.leadHero = leadHero;
    }

    public String getLeadHeroine() {
        return leadHeroine;
    }

    public void setLeadHeroine(String leadHeroine) {
        this.leadHeroine = leadHeroine;
    }

    @Override
    public String toString() {
        return "RomComMovie{" +
                "title='" + getTitle() + '\'' +
                ", director='" + getDirector() + '\'' +
                ", releaseDate='" + getReleaseDate()+ '\'' +
                ", duration='" + getDuration() + '\'' +
                ", language='" + getLanguage() + '\'' +
                "leadHero='" + leadHero + '\'' +
                ", leadHeroine='" + leadHeroine + '\'' +
                '}';
    }
}
class ThrillerMovie extends Movie {
    private String mainCharacter;

    public ThrillerMovie(String title, String director, String releaseDate, String duration, String language, String mainCharacter) {
        super(title, director, releaseDate, duration, language);
        this.mainCharacter = mainCharacter;
    }

    public String getMainCharacter() {
        return mainCharacter;
    }

    public void setMainCharacter(String mainCharacter) {
        this.mainCharacter = mainCharacter;
    }
    @Override
    public String toString() {
        return "ThrillerMovie{" +
                "title='" + getTitle() + '\'' +
                ", director='" + getDirector() + '\'' +
                ", releaseDate='" + getReleaseDate()+ '\'' +
                ", duration='" + getDuration() + '\'' +
                ", language='" + getLanguage() + '\'' +
                ",MainCharacter="+mainCharacter+ '\'' +
                '}';
    }
}
class MovieDriver{
    public static void main(String[] args) {
        Movie movie1=new RomComMovie("Oh My Kadaule","Ashwath marimuthu","14/02/20","2:25","Tamil","Ashok selvan","Ritika Singh");
        Movie movie2=new ThrillerMovie("Kanjana","Raghava lawrence","15/07/2011","2:45","Tamil","Ragava Lawrence");
        System.out.println(movie1);
        System.out.println(movie2);
    }
}
