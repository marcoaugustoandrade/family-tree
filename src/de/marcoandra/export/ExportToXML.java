package de.marcoandra.export;

import de.marcoandra.tree.IPerson;
import de.marcoandra.tree.PersonComposite;

public class ExportToXML {

    private IPerson person;

    public ExportToXML(IPerson person) {
        this.person = person;
    }

    public String export(boolean header){
        String p = "";
        if (header) p += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
        p += "\n<person uuid=\"" + person.hashCode() + "\">";
        p += "\n<name>" + person.getName() + "</name>";

        if (person instanceof PersonComposite){
            if (!person.getPartners().isEmpty()){
                p += "\n<patterns>";

                // Para cada pattern
                for (IPerson partner: person.getPartners()){
                    ExportToXML exportToXMLPartner = new ExportToXML(partner);
                    p += exportToXMLPartner.export(false);

                    if (!partner.getChildrens().isEmpty()){
                        p += "\n<childrens>";
                        // Exporta os childrens se houver
                        for(IPerson children: partner.getChildrens()){
                            ExportToXML exportToXMLChildren = new ExportToXML(children);
                            p += exportToXMLChildren.export(false);
                        }
                        p += "\n</childrens>";
                    }
                }
                p += "\n</patterns>";
            }
        }

//        if (person instanceof PersonComposite){
//            if (!((PersonComposite) person).getPartners().isEmpty()){
//                p += "\n<patterns>";
//                for (IPerson partner: ((PersonComposite) person).getPartners()){
//                    ToXML toXMLPartner = new ToXML(partner);
//                    p += toXMLPartner.export(false);
//                }
//                p += "\n</patterns>";
//            }
//            if (!((PersonComposite) person).getChildrens().isEmpty()){
//                p += "\n<childrens>";
//                for (IPerson children: ((PersonComposite) person).getChildrens()){
//                    ToXML toXMLChildren = new ToXML(children);
//                    p += toXMLChildren.export(false);
//                }
//                p += "\n</childrens>";
//            }
//        }

        p += "\n</person>";
        return p;
    }
}
