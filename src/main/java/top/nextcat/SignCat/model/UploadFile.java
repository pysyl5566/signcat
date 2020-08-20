package top.nextcat.SignCat.model;

import java.io.File;

public class UploadFile {
    private String objectName;
    private File file;

    public UploadFile() {
    }

    public UploadFile(String objectName, File file) {
        this.objectName = objectName;
        this.file = file;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
