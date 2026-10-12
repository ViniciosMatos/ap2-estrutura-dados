package musicas;

public class Musica {
    String titulo;
    String artista;
    String album;
    int duracao;
    Musica proxima;
    Musica anterior;

    public Musica(String titulo, String artista, String album, int duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.duracao = duracao;
        this.proxima = null;
        this.anterior = null;
    }
}
