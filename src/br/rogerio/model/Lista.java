/*
 Exercícios de Fixação – Lista
4. Considere uma coleção de nomes de sites da web e seus respectivos links
na Internet armazenados através de uma lista. Escreva a respectiva
estrutura e um método que, dado o nome de um site, busque o seu link
correspondente na lista e ao mesmo tempo mova o nó que contém o nome
buscado para o início da lista, de forma que ele possa ser encontrado mais
rapidamente na próxima vez que for buscado.
5. Desenhe o array lista interno da classe Lista após
 */
package br.rogerio.model;

/**
 *
 * @author roger
 */
public class Lista {

    private final int MAXTAM;
    private Site[] array;
    private int ultimo;

    public Lista(int tamanho) {
        if (tamanho <= 0) {
            throw new RuntimeException("Tamanho deve ser maior de zero!\n");
        }
        MAXTAM = tamanho;
        array = new Site[MAXTAM];
        ultimo = -1;
    }

    public boolean isEmpty() {
        return ultimo == -1;
    }

    public boolean isFull() {
        return ultimo + 1 == MAXTAM;
    }

    public int size() {
        return ultimo + 1;
    }

    public void inserirNoInicio(Site elemento) {
        if (isFull()) {
            throw new RuntimeException("A lista está cheia!\n");
        }
        ultimo++;
        for (int i = ultimo; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = elemento;
    }

    public void ordenarLista() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i].getNome().compareToIgnoreCase(array[j].getNome()) >=0) {
                    Site temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
                
            }
        }
        mostrarLista();
    }

    public void inserirDeFormaOrdenada(Site elemento) {
        if (isFull()) {
            throw new RuntimeException("A lista está cheia!\n");
        }
        ultimo++;
        int i = ultimo;
        while ((i > 0) && (elemento.getNome().compareTo(elemento.getNome()) >= 0)) {
            array[i] = array[i - 1];
            i--;
        }
        array[i] = elemento;
    }

    public void mostrarLista() {
        if (isEmpty()) {
            System.out.println("A lista está vazia!\n");
        } else {
            System.out.println("*****  Elementos da lista  *****");
            for (int i = 0; i <= ultimo; i++) {
                System.out.printf("%s", array[i] + "\n");
            }
            System.out.println("");
        }
    }

    public void inserirNoFim(Site elemento) {
        if (isFull()) {
            throw new RuntimeException("A lista está cheia!\n");
        }
        ultimo++;
        array[ultimo] = elemento;
    }

    public void inserirNaPosicaoInformada(int posicao, Site elemento) {
        if (isFull()) {
            throw new RuntimeException("A lista está cheia!\n");
        }
        if (posicao > ultimo + 1 || posicao < 0) {
            throw new RuntimeException("Posição inválida!\n");
        }
        ultimo++;
        for (int i = ultimo; i > posicao; i--) {
            array[i] = array[i - 1];
        }
        array[posicao] = elemento;
    }

    public void removerNoInicio() {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        for (int i = 0; i < MAXTAM; i++) {
            array[i] = array[i + 1];
        }
        ultimo--;
    }

    public void removerNoFim() {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        ultimo--;
    }

    public void removerElementoNaPosicaoInformada(int posicao) {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        if (posicao < 0 || posicao > ultimo) {
            throw new RuntimeException("Posição inválida!\n");
        }
        for (int i = posicao; i < ultimo; i++) {
            array[i] = array[i + 1];
        }
        ultimo--;
    }

    public int buscarPosicaoDoElemento(String nome) {
        for (int i = 0; i <= ultimo; i++) {
            if (array[i].getNome() == nome) {
                return i;
            }
        }
        return -1;
    }

    public boolean removerElemento(String elemento) {
        int pos = buscarPosicaoDoElemento(elemento);
        if (pos == -1) {
            return false;
        }
        removerElementoNaPosicaoInformada(pos);
        return true;
    }

    public Site getElementoNoInicio() {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        return array[0];
    }

    public Site getElementoNoFim() {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        return array[ultimo];
    }

    public Site getElementoNaPosicaoInformata(int posicao) {
        if (isEmpty()) {
            throw new RuntimeException("A lista está vazia!\n");
        }
        if (posicao > ultimo || posicao < 0) {
            throw new RuntimeException("Posição inválida!\n");
        }
        return array[posicao];
    }

    public void destroy() {
        ultimo = -1;
    }

    public boolean alterarElemento(Site elemento, Site novoElemento) {

        for (int i = 0; i < size(); i++) {
            if (elemento == array[i]) {
                array[i] = novoElemento;
                return true;
            }
        }
        return false;
    }

    public void receberVetor(Site[] vetor) {

        if (isFull()) {
            System.out.println("A lista está cheia!\n");
        }

        if (vetor.length > 0) {
            for (int i = 0; i < vetor.length; i++) {
                if (!vetor[i].equals("null")) {
                    inserirNoFim(vetor[i]);
                } else {
                    System.out.println("O vetor informado está com"
                            + " valores nulos\nVerifique!");
                    break;
                }
            }
        }
    }

    public void imprimirListaInversa() {

        if (isEmpty()) {
            System.out.println("A lista informada está vazia!\n");
        }
        System.out.println("***** Lista impressa na ordem inversa ****");
        for (int i = ultimo; i >= 0; i--) {
            if (!array[i].equals(null)) {
                System.out.printf("%s", array[i] + "\n");
            } else {
                System.out.println("A lista está vazia\nVerifique");
                break;
            }
        }
        System.out.println("");
    }

    public Site getLinkDoSite(String nome) {
        int posicao = buscarPosicaoDoElemento(nome);
        Site aux;
        
        if (posicao == -1) {
            throw new RuntimeException("Nome informado não existe na lista!");
        }
        aux = array[posicao];
        array[posicao] = array[0];
        array[0] = aux;
        
        return array[0];

    }
}
