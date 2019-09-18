package de.marcoandra.tree;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonComposite implements IPerson{

    private int uuid;
    private String name;
    private List<IPerson> partners;
    private List<IPerson> childrens;

    public PersonComposite(String name) {
        uuid = this.hashCode();
        this.name = name;
        partners = new ArrayList<IPerson>();
        childrens = new ArrayList<IPerson>();
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
        partners.add((PersonComposite) partner);
    }

    @Override
    public IPerson removePartner(String name) {
        return null;
    }

    @Override
    public IPerson getPartner(String name) {
        for (IPerson p: partners){
            if (p.getName() == name){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<IPerson> getPartners() {
        return partners;
    }

    @Override
    public void addChildren(IPerson children) {
        childrens.add((PersonComposite) children);
    }

    @Override
    public IPerson removeChildren(String name) {
        return null;
    }

    @Override
    public IPerson getChildren(String name) {
        for (IPerson c: childrens){
            if (c.getName() == name){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<IPerson> getChildrens() {
        return childrens;
    }

    public void print(){
        System.out.println("Name: " + name);
        if (!partners.isEmpty()){
            for (IPerson p: partners){
                System.out.println("Name: " + p.getName());
                    if (!p.getChildrens().isEmpty()){
                        for (IPerson c: p.getChildrens()){
                            System.out.println("Name: " + c.getName());
                        }
                    }
            }
        }
    }
}
