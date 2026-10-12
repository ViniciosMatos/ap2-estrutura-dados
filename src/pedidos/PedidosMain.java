import pedidos.FilaPendentes;
import pedidos.PilhaCancelados;

void main() {
    FilaPendentes<String> pendentes = new FilaPendentes<>();
    PilhaCancelados<String> cancelados = new PilhaCancelados<>();

    boolean menu = true;
    while (menu) {
        IO.println("___ Menu de Pedidos ___");
        IO.println("1- Adicionar pedido\n" +
                "2- Atender pedido\n" +
                "3- Cancelar pedido\n" +
                "4- Restaurar pedido\n" +
                "5- Imprimir pedidos pendentes\n" +
                "6- Imprimir pedidos cancelados\n" +
                "0- Sair");
        int opcao = 9;

        try {
            opcao = Integer.parseInt(IO.readln("Escolha uma opção: "));
        } catch (NumberFormatException e) {
            IO.println("ERRO: A entrada não pôde ser convertida para número inteiro");
        }

        switch (opcao) {
            case 1:
                String novoPedido = IO.readln("Descreva o pedido: ");
                pendentes.adicionar(novoPedido);
                break;
            case 2:
                pendentes.atender();
                break;
            case 3:
                pendentes.cancelar(cancelados);
                break;
            case 4:
                cancelados.restaurar(pendentes);
                break;
            case 5:
                pendentes.imprimirPendentes();
                break;
            case 6:
                cancelados.imprimirCancelados();
                break;
            case 0:
                menu = false;
            default:
                IO.println("Digite um opção valida");
                break;
        }
    }
}
