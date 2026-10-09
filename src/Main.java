void main() {
   FilaPendentes<String> teste = new FilaPendentes<>();
   PilhaCancelados<String> cancelado = new PilhaCancelados<>();

    teste.adicionar("teste1");
    teste.adicionar("teste2");
    teste.adicionar("teste3");
    teste.adicionar("teste4");

    cancelado.adicionar(teste.cancelar());
    teste.imprimirPendentes();
    cancelado.imprimirCancelados();

}
