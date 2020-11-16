/*
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
public class Site {

    private String nome;
    private String link;

    public Site() {
    }

    public Site(String nome, String link) {
        this.nome = nome;
        this.link = link;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Nome do site: " + nome + "\nLink do site: " + link;
    }

}
