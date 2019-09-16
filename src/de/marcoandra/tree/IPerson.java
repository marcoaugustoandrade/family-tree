package de.marcoandra.tree;

import java.util.List;

public interface IPerson {

    String getName();

    void addPartner(IPerson partner);
    IPerson removePartner(String name);
    IPerson getPartner(String name);
    List<IPerson> getPartners();

    void addChildren(IPerson children);
    IPerson removeChildren(String name);
    IPerson getChildren(String name);
    List<IPerson> getChildrens();
}
