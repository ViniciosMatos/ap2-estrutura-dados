void main() {
   FilaPendentes<String> teste = new FilaPendentes<>();

    teste.adicionar("teste1");
    teste.adicionar("teste2");
    teste.adicionar("teste3");
    teste.adicionar("teste4");

    teste.imprimirPendentes();
}
