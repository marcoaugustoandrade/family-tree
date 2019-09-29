package de.marcoandra.test;

public class MainToXML {

    public static void main(String[] args) {

        Pessoa maria = new Pessoa("Maria");
        Pessoa joao = new Pessoa("Joao");
        maria.addConjuge(joao);

        Pessoa mariana = new Pessoa("Mariana");
        joao.addFilho(mariana);
        Pessoa joana = new Pessoa("Joana");
        joao.addFilho(joana);

        Pessoa otavio = new Pessoa("Otavio");
        mariana.addConjuge(otavio);

        Pessoa jose = new Pessoa("Jose");
        maria.addConjuge(jose);

        Pessoa mario = new Pessoa("Mario");
        jose.addFilho(mario);

        Pessoa ana = new Pessoa("Ana");
        mario.addConjuge(ana);

        Pessoa tatiana = new Pessoa("Tatiana");
        ana.addFilho(tatiana);

//        maria.toYAML(0);
        maria.toXML(0);

    }
}
