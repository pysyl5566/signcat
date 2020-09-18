package top.nextcat.SignCat.model.result;

public class ResultServerChan {
//    {
//        "errno":0,
//            "errmsg":"success",
//            "dataset":"done"
//    }
    private Integer errno;
    private String errmsg;
    private String dataset;

    public ResultServerChan() {
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public ResultServerChan(Integer errno, String errmsg, String dataset) {
        this.errno = errno;
        this.errmsg = errmsg;
        this.dataset = dataset;
    }
}
