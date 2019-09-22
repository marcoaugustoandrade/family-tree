package de.marcoandra.tree;

import java.util.List;

public class PersonLeaf implements IPerson{

    private int uuid;
    private String name;
    private char sex;

    public PersonLeaf(String name) {
        this.name = name;
        uuid = this.hashCode();
    }

    @Override
    public int getUUID() {
        return uuid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char getSexo() {
        return 0;
    }

    @Override
    public void addPartner(IPerson partner) {

    }

    @Override
    public IPerson removePartner(String name) {
        return null;
    }

    @Override
    public IPerson getPartner(String name) {
        return null;
    }

    @Override
    public List<IPerson> getPartners() {
        return null;
    }

    @Override
    public void addChildren(IPerson children) {

    }

    @Override
    public IPerson removeChildren(String name) {
        return null;
    }

    @Override
    public IPerson getChildren(String name) {
        return null;
    }

    @Override
    public List<IPerson> getChildrens() {
        return null;
    }
}
