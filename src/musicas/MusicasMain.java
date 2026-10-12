package musicas;

public class MusicasMain {
    static void main() {
        Player playlist = new Player();

        boolean menu = true;
        while (menu) {
            IO.println("___ Lista de Músicas ___");
            IO.println("1- Adicionar música\n" +
                    "2- Avançar música\n" +
                    "3- Voltar música\n" +
                    "4- Exibir Música\n" +
                    "5- Remover Música\n" +
                    "6- Listar Playlist\n" +
                    "7- Ordenar Playlist\n" +
                    "0- Sair");
            int opcao = 9;

            try {
                opcao = Integer.parseInt(IO.readln("-> Escolha uma opção: "));
            } catch (NumberFormatException e) {
                IO.println("ERRO: A entrada não pôde ser convertida para número inteiro");
            }

            switch (opcao) {
                case 1:
                    playlist.adicionar();
                    break;

                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    playlist.listarMusicas();
                    break;
                case 7:

                    break;
                case 0:
                    menu = false;
                default:
                    IO.println("Digite um opção valida");
                    break;
            }
        }
    }
}
