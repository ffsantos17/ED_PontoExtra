
public class Main {

    public static void main(String[] args) throws Exception {
        ListaDupEnc lista = new ListaDupEnc();
        lista.incluirEm(1, 0);
        lista.incluirEm(2, 1);
        lista.incluirEm(3, 2);
        lista.incluirEm(4, 3);
        lista.incluirEm(5, 4);
        lista.incluirEm(6, 5);
        lista.incluirEm(7, 6);
        System.out.print("Lista: ");
        lista.imprimir();

        Lista subLista = lista.subLista(2,5);
        System.out.print("SubLista: ");
        subLista.imprimir();
    }
}
