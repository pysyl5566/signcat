package top.nextcat.SignCat.model.result;

public class ResultImageUpload {
    private String imagePath;

    public ResultImageUpload() {
    }

    public ResultImageUpload(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
