package musicas;

public class Player {
    Musica musicaAtual;
    Musica primeiraMusica;
    Musica ultimaMusica;
    int tamanho;

    public Player() {
        this.musicaAtual = null;
        this.primeiraMusica = null;
        this.ultimaMusica = null;
        this.tamanho = 0;
    }

    public void adicionar() {
        int opcao = Integer.parseInt(IO.readln("1- Adicionar no Inicio\n" +
                "2- Adicionar no Meio\n" +
                "3- Adicionar no Fim\n" +
                "-> Qual opção deseja seguir? "));

        String titulo = IO.readln("-> Titulo: ");
        String artista = IO.readln("-> Artista: ");
        String album = IO.readln("-> Album: ");
        int duracao = Integer.parseInt(IO.readln("-> Duração (em segundos): "));

        switch (opcao) {
            case 1:
                adicionarNoInicio(titulo, artista, album, duracao);
                break;
            case 2:
                adicionarNoMeio(titulo, artista, album, duracao);
                break;
            case 3:
                adicionarNoFim(titulo, artista, album, duracao);
                break;
            default:
                IO.println("Opção inválida");
                break;
        }
    }

    public void avancarMusica() {
        if (musicaAtual.proxima == null) {
            IO.println("Fim da playlist!");
            return;
        }
        IO.println("Avançando...");
        musicaAtual = musicaAtual.proxima;
    }

    public void voltarMusica() {
        if (musicaAtual.anterior == null) return;

        IO.println("Voltando...");
        musicaAtual = musicaAtual.anterior;
    }

    public void exibirMusica() {
        if (tamanho == 0) {
            IO.println("Não há músicas tocando no momento");
            return;
        }
        IO.println(musicaAtual.titulo + " | " + musicaAtual.duracao + " | " + musicaAtual.album + " | " + musicaAtual.artista);
    }

    public void adicionarNoInicio(String titulo, String artista, String album, int duracao) {
        Musica novaMusica = new Musica(titulo, artista, album, duracao);
        if (tamanho == 0) {
            musicaAtual = novaMusica;
            ultimaMusica = novaMusica;
        } else {
            novaMusica.proxima = primeiraMusica;
            primeiraMusica.anterior = novaMusica;
        }

        primeiraMusica = novaMusica;
        tamanho++;
        IO.println("Música adiocionada no inicio!");
    }

    public void adicionarNoFim(String titulo, String artista, String album, int duracao) {
        Musica novaMusica = new Musica(titulo, artista, album, duracao);
        if (tamanho == 0) {
            musicaAtual = novaMusica;
            primeiraMusica = novaMusica;
        } else {
            novaMusica.anterior = ultimaMusica;
            ultimaMusica.proxima = novaMusica;
        }

        ultimaMusica = novaMusica;
        tamanho++;
        IO.println("Música adiocionada no final!");
    }


    public void adicionarNoMeio(String titulo, String artista, String album, int duracao) {

    }

    public void remover(String titulo) {
        Musica atual = primeiraMusica;
        while (atual != null) {
            if (atual.titulo.equals(titulo)) {
                if (atual == primeiraMusica) {
                    primeiraMusica = atual.proxima;
                    if (primeiraMusica != null) primeiraMusica.anterior = null;

                } else if (atual == ultimaMusica) {
                    ultimaMusica = atual.anterior;
                    if (ultimaMusica != null) ultimaMusica.proxima = null;

                } else {
                    atual.anterior.proxima = atual.proxima;
                    atual.proxima.anterior = atual.anterior;
                }
                tamanho--;
                IO.println("Música removida da playlist!");
                return;
            }
            atual = atual.proxima;
        }
    }

    public void listarMusicas() {
        IO.println();
        IO.println("-----Playlist-----");
        if (tamanho == 0) {
            IO.println("Não há músicas na playlist");
            return;
        }

        Musica atual = primeiraMusica;
        while (atual != null) {
            IO.println(musicaAtual.titulo + " | " + musicaAtual.duracao + " | " + musicaAtual.album + " | " + musicaAtual.artista);
            atual = atual.proxima;
        }
    }
}
