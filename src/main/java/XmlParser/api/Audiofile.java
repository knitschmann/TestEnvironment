package XmlParser.api;

public class Audiofile {
    String name;
    String mp3FileUrl;
    String publicationDate;
    String author;
    String duration;

    public Audiofile() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMp3FileUrl(String mp3FileUrl) {
        this.mp3FileUrl = mp3FileUrl;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Audiofile{" +
                "name='" + name + '\'' +
                ", mp3FileUrl='" + mp3FileUrl + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", author='" + author + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
