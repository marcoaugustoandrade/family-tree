package de.marcoandra.export;

import de.marcoandra.tree.IPerson;

interface IExport {

    void to(String type, String fileName, IPerson person);
}
