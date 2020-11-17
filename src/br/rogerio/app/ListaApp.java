/*
Exercícios de Fixação – Lista
4. Considere uma coleção de nomes de sites da web e seus respectivos links
na Internet armazenados através de uma lista. Escreva a respectiva
estrutura e um método que, dado o nome de um site, busque o seu link
correspondente na lista e ao mesmo tempo mova o nó que contém o nome
buscado para o início da lista, de forma que ele possa ser encontrado mais
rapidamente na próxima vez que for buscado.
 */
package br.rogerio.app;

import br.rogerio.model.Lista;
import br.rogerio.model.Site;
import javax.swing.JOptionPane;

/**
 *
 * @author roger
 */
public class ListaApp {

    public static void main(String[] args) {

        Lista lista = new Lista(5);

        Site site1 = new Site("AribImoveis", "http://www.elaineribeiroimoveis.com.br/");
        Site site2 = new Site("ImobiBrasil", "https://admin01.imobibrasil.net/imobiliarias/");
        Site site3 = new Site("Canalpro-Zap", "https://canalpro.grupozap.com/login");
        Site site4 = new Site("OLX-Pro", "https://pro.olx.com.br/login");
        Site site5 = new Site("PostgresTutorial", "https://www.postgresqltutorial.com/");

        try {
            lista.inserirNoInicio(site1);
            lista.inserirNoInicio(site2);
            lista.inserirNoInicio(site3);
            lista.inserirNoInicio(site4);
            lista.inserirNoInicio(site5);
            lista.mostrarLista();

            System.out.println("Retornando o link desejado: "
                    + lista.getLinkDoSite(site2.getNome()).getLink());
            
            System.out.println("");
            lista.mostrarLista();
            

        } catch (RuntimeException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

        System.out.printf("\n%s%d\n", "Número de sites nesta lista: ", lista.size());

    }

}
