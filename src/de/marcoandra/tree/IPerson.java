package de.marcoandra.tree;

import java.util.List;

public interface IPerson {

    int getUUID();
    String getName();
    char getSexo();
    // Data de nascimento
    // Local de nascimento
    // Data de falecimento
    // Local de falecimento


    void addPartner(IPerson partner);
    IPerson removePartner(String name);
    IPerson getPartner(String name);
    List<IPerson> getPartners();

    void addChildren(IPerson children);
    IPerson removeChildren(String name);
    IPerson getChildren(String name);
    List<IPerson> getChildrens();
}
