package de.marcoandra;

import de.marcoandra.export.Export;
import de.marcoandra.tree.IPerson;
import de.marcoandra.tree.PersonComposite;
import de.marcoandra.tree.PersonLeaf;

public class Main {

    public static <IExport> void main(String[] args) {

        IPerson maria = new PersonComposite("Maria");
        IPerson joao = new PersonComposite("João");
        maria.addPartner(joao);

        // Mariana é folha na árvore (não tem relacionamentos)
        IPerson mariana = new PersonLeaf("Mariana");
        // Clara é composta por seus relacionamentos
        IPerson clara = new PersonComposite("Clara");
        maria.getPartner("João").addChildren(mariana);
        maria.getPartner("João").addChildren(clara);

//        IPerson jose = new PersonLeaf("José");
//        clara.addPartner(jose);

        Export export = new Export();
        export.to("XML", "dados", maria);
//        export.to("JSON", "dados", maria);

    }
}
