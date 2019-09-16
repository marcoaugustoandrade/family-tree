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


//        List<IPerson> treeList = new ArrayList<IPerson>();
//        char option = ' ';
//        Scanner input = new Scanner(System.in);
//
//        while (option != 'c'){
//
//            System.out.println("1 - Adicionar uma pessoa na árvore genealógica");
//            System.out.println("2 - Imprimir a árvore");
//            System.out.println("3 - Exportar árvore genealógia para um arquivo");
//            System.out.println("c - Fechar aplicativo");
//            char i = input.next().charAt(0);
//
//            if (i == '1') {
//
//                System.out.println("Quer adicionar como uma nova árvore, conjuge ou como filho? (a/c/f)");
//                char type = input.next().charAt(0);
//
//                if (type == 'a') {
//
//                    System.out.println("Informe o nome da pessoa: ");
//                    String name = input.next();
//                    IPerson person = new PersonComposite(name);
//                    treeList.add(person);
//                } else if (type == 'c') {
//
//                    System.out.println("Informe o nome do novo conjuge: ");
//                    String partnerName = input.next();
//                    IPerson person = new PersonComposite(partnerName);
//                    System.out.println("Informe o nome do conjuge que será o parceiro: ");
//                    String partner = input.next();
//
//                    for (IPerson p : treeList) {
//                        if (p.getName() == partner) {
//                            p.addPartner(person);
//                        }
//                    }
//                } else if (type == 'f') {
//                    System.out.println("");
//                }
//            } else if (i == '2'){
//                PersonComposite top = (PersonComposite) treeList.get(0);
//                top.print();
//            } else if (i == '3'){
//
//                Export export = new Export();
//                System.out.println("Nome do arquivo: ");
//                String fileName = input.next();
//                System.out.println("Formato do arquivo: 1)XML 2)JSON 3)YAML 4)TOML");
//                char fileFormatOption = input.next().charAt(0);
//                String fileFormat = "";
//                if (fileFormatOption == '1') fileFormat = "XML";
//                else if (fileFormatOption == '2') fileFormat = "JSON";
//                else if (fileFormatOption == '3') fileFormat = "YAML";
//                else if (fileFormatOption == '4') fileFormat = "TOML";
//                export.to(fileFormat, fileName, treeList.get(0));
//
//            } else if (i == 'c'){
//                option = 'c';
//            }
//        }

    }
}
