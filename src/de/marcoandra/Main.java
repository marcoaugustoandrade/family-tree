package de.marcoandra;

import de.marcoandra.export.Export;
import de.marcoandra.tree.PersonComposite;

public class Main {

    public static <IExport> void main(String[] args) {

        PersonComposite maria = new PersonComposite("Maria");
        PersonComposite joao = new PersonComposite("João");
        maria.addPartner(joao);

        PersonComposite mariana = new PersonComposite("Mariana");
        PersonComposite clara = new PersonComposite("Clara");
        maria.getPartner("João").addChildren(mariana);
        maria.getPartner("João").addChildren(clara);

        PersonComposite jose = new PersonComposite("José");
        clara.addPartner(jose);

        Export export = new Export();
        export.to("XML", "dados", maria);
        export.to("JSON", "dados", maria);

    }
}
