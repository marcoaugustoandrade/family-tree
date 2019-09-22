package de.marcoandra.export;

import de.marcoandra.tree.IPerson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Export implements IExport{

    private ExportToJSON exportToJSON;
    private ExportToXML exportToXML;

    public void to(String type, String fileName, IPerson person){

        String data = "";

        if (type.equals("JSON")){
            exportToJSON = new ExportToJSON(person);
            data = exportToJSON.export();
            fileName += ".json";
        } else if (type.equals("XML")){
            exportToXML = new ExportToXML(person);
            data = exportToXML.export(true, 0);
            fileName += ".xml";
        }

        writeFile(fileName, data);
    }

    public void writeFile(String filename, String data){

        BufferedWriter writer = null;
        try{
            File file = new File(filename);
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(data);
            System.out.println("Salvando dados em " + filename);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
