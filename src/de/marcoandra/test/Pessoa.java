package de.marcoandra.test;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private String nome;
    private List<Pessoa> conjuges;
    private List<Pessoa> filhos;

    public Pessoa(String nome) {
        this.nome = nome;
        conjuges = new ArrayList<Pessoa>();
        filhos = new ArrayList<Pessoa>();
    }

    public String getNome() {
        return nome;
    }

    public void addConjuge(Pessoa conjuge){
        conjuges.add(conjuge);
    }


    public void addFilho(Pessoa filho) {
        filhos.add(filho);
    }

    public void toYAML(int nivel){

        String espacos = "";
        for (int i = 1; i <= nivel; i++) espacos += "  ";

        if (nivel == 0) {
            System.out.println("nome: " + this.getNome());
            System.out.println("uuid: " + this.hashCode());
        } else {
            System.out.println(espacos + "- nome: " + this.getNome());
            System.out.println(espacos + "  uuid: " + this.hashCode());
        }

        int nivelc = nivel;
        if (!conjuges.isEmpty()){
            if (nivel == 0) System.out.println("conjuges:");
            else System.out.println(espacos + "  conjuges:");
            nivelc++;
            for (Pessoa c: conjuges){
                c.toYAML(nivelc);
            }
        }

        int nivelf = nivel;
        if (!filhos.isEmpty()){
            System.out.println(espacos + "  filhos:");
            nivelf++;
            for (Pessoa f: filhos){
                f.toYAML(nivelf);
            }
        }
    }

    public void toXML(int nivel){

        String espacos = "";
        for (int i = 1; i <= nivel; i++) espacos += "\t";

        // Abertura
        if (nivel == 0) System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");

        if (nivel == 0) System.out.println(espacos + "<pessoa>");
        else System.out.println(espacos + "\t<pessoa>");

        System.out.println(espacos + "\t<nome>" + this.getNome() + "</nome>");
        System.out.println(espacos + "\t<uuid>" + this.hashCode() + "</uuid>");

        int nivelc = nivel;
        if (!conjuges.isEmpty()){
            System.out.println(espacos + "\t<conjuges>");
            nivelc++;
            for (Pessoa c: conjuges){
                c.toXML(nivelc);
            }
            System.out.println(espacos + "\t</conjuges>");
        }

        int nivelf = nivel;
        if (!filhos.isEmpty()){
            System.out.println(espacos + "\t<filhos>");
            nivelf++;
            for (Pessoa f: filhos){
                f.toXML(nivelf);
            }
            System.out.println(espacos + "\t</filhos>");
        }

        // Fechamento
        if (nivel == 0) System.out.println(espacos + "</pessoa>");
        else System.out.println(espacos + "\t</pessoa>");
    }

}
