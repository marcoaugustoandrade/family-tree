package de.marcoandra.export;

import de.marcoandra.tree.IPerson;
import de.marcoandra.tree.PersonComposite;

public class ExportToXML {

    private IPerson person;

    public ExportToXML(IPerson person) {
        this.person = person;
    }

    public String export(boolean header, int nivel){

        String espacos = "";
        for (int i = 0; i <= nivel; i++) espacos += " ";

        String p = "";
        if (header) p += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
        p += "\n" + espacos + "<person uuid=\"" + person.getUUID() + "\">";
        p += "\n" + espacos + "<name>" + person.getName() + "</name>";

        if (person instanceof PersonComposite){

            if (!person.getPartners().isEmpty()){
                p += "\n  <patterns>";

                // For each pattern
                for (IPerson partner: person.getPartners()){
                    ExportToXML exportToXMLPartner = new ExportToXML(partner);
                    p += "    " + exportToXMLPartner.export(false, nivel++);

                    // Export childrens
                    if (!partner.getChildrens().isEmpty()){
                        if (!partner.getChildrens().isEmpty()) {
                            p += "\n    <childrens>";
                            for(IPerson children: partner.getChildrens()){
                                ExportToXML exportToXMLChildren = new ExportToXML(children);
                                p += "        " + exportToXMLChildren.export(false, nivel++);
                            }
                            p += "\n    </childrens>";
                        }
                    }
                }
                p += "\n  </patterns>";
            }
        }
        p += "\n" + espacos + "</person>";
        return p;
    }
}
