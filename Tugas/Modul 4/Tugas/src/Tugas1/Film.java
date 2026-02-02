package Tugas1;

public class Film {
    String judulFilm;
    int tahunRilis;

    public Film(String judulFilm, int tahunRilis) {
        this.judulFilm = judulFilm;
        this.tahunRilis = tahunRilis;
    }

    public String getJudulFilm() {
        return judulFilm;
    }

    public int getTahunRilis() {
        return tahunRilis;
    }

    @Override
    public String toString() {
        return "Judul: " + judulFilm + ", Tahun: " + tahunRilis;
    }
}
