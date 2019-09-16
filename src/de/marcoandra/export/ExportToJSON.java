package de.marcoandra.export;

import de.marcoandra.tree.IPerson;
import de.marcoandra.tree.PersonComposite;

public class ExportToJSON {

    private IPerson person;

    public ExportToJSON(IPerson person) {
        this.person = person;
    }

    public String export(){
        String p = "";
        p += "{";
        p += "\n\"name\": \"" + person.getName() + "\"";

        if (person instanceof PersonComposite){
            if (!person.getPartners().isEmpty()){
                p += ", \n\"patterns\": [";

                // For each pattern
                for (IPerson partner: person.getPartners()){
                    ExportToJSON exportToJSONPartner = new ExportToJSON(partner);
                    p += exportToJSONPartner.export();

                    // Export childrens
                    if (!partner.getChildrens().isEmpty()){
                        p += ",\n{\"childrens\": [";
                        int numChildrens = 1;
                        for(IPerson children: partner.getChildrens()){
                            ExportToJSON exportToJSON = new ExportToJSON(children);
                            int x = partner.getChildrens().size();
                            System.out.printf("x:" + x);
                            if (numChildrens != partner.getChildrens().size()){
                                p += exportToJSON.export() + ",";
                            } else {
                                p += exportToJSON.export();
                            }
                            numChildrens++;
                        }
                        p += "]}";
                    }
                }

                p += "]";
            }
        }

        p += "\n}";
        return p;
    }
}
