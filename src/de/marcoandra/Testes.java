package de.marcoandra;

import de.marcoandra.tree.IPerson;
import de.marcoandra.tree.PersonComposite;
import de.marcoandra.tree.PersonLeaf;

public class Testes {

    public static void main(String[] args) {

        IPerson maria = new PersonLeaf("Maria");

        if (maria instanceof PersonComposite){
            System.out.println("É instância de PersonComposite");
        } else {
            System.out.println("É instância de PersonLeaf");
        }
    }
}
