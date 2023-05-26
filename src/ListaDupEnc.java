public class ListaDupEnc<T extends Comparable<T>> extends Lista<T>
{
}
abstract class Lista<T extends Comparable> {
    private NoDuplo<T> inicio;
    private NoDuplo<T> ultimo;

    /*  Inserir no inicio da lista  */
    public void incluirInicio(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>();
        novoNo.dado = elemento;

        if (inicio == null) {
            inicio = novoNo;
            ultimo = novoNo;
        } else {
            novoNo.prox = inicio;
            inicio.ant = novoNo;
            inicio = novoNo;
        }
    }

    /*  Inserir no Fim da lista  */
    public void incluirFim(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>();
        novoNo.dado = elemento;
        if (ultimo == null) {
            inicio = novoNo;
            ultimo = novoNo;
        } else {
            novoNo.ant = ultimo;
            ultimo.prox = novoNo;
            ultimo = novoNo;
        }
    }
    /*  Inserir na posição da lista  */
    public void incluirEm(T elemento, int posicao){
        NoDuplo<T> novoNo = new NoDuplo<>();
        NoDuplo<T> atual = inicio;
        novoNo.dado = elemento;
        int cont = 0;

        if(posicao < 0 || posicao>getTamanho()){
            System.out.print("Posição invalida ou maior que o tamanho");
        }else if (posicao == 0) {
            if (inicio != null) {
                inicio.ant = novoNo;
                novoNo.prox = inicio;
            }else {
                ultimo=novoNo;
            }
            inicio = novoNo;

        }else if(posicao == getTamanho()){
            novoNo.ant = ultimo;
            ultimo.prox = novoNo;
            ultimo= novoNo;
        } else {
            while (cont <= posicao){
                if(cont == posicao){
                    atual.ant.prox = novoNo;
                    novoNo.ant = atual.ant;
                    atual.ant=novoNo;
                    novoNo.prox=atual;
                    return;
                }
                cont++;
                atual = atual.prox;
            }
        }
    }
    /*  Obter o tamanho da lista */
    public int getTamanho(){
        int tamanho = 0;
        NoDuplo<T> atual = inicio;

        while (atual != null) {
            tamanho++;
            atual = atual.prox;
        }

        return tamanho;
    }
    /*  imprimir a lista */
    public void imprimir() {
        System.out.print("[");
        NoDuplo<T> atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado);
            if (atual != ultimo) {
                System.out.print(", ");
            }
            atual = atual.prox;
        }
        System.out.println("]");
    }

    /*  Criar uma SubLista com intervalo informado  */
    public Lista<T> subLista(int posInicial, int posFinal) throws Exception{
        if (posInicial < 0 || posFinal < 0 || posInicial > posFinal || posInicial > getTamanho()) {
            throw new IllegalArgumentException("Intervalo inválido.");
        }

        ListaDupEnc subLista = new ListaDupEnc();

        NoDuplo<T> atual = inicio;
        int posicaoAtual = 0;

        while (posicaoAtual < posInicial) {
            atual = atual.prox;
            posicaoAtual++;
        }

        while (posicaoAtual <= posFinal) {
            subLista.incluirFim(atual.dado);
            atual = atual.prox;
            posicaoAtual++;
        }
        return subLista;
    };
}
class NoDuplo<T> {
    public T dado;
    public NoDuplo <T> prox;
    public NoDuplo <T> ant;
}
