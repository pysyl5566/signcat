package top.nextcat.SignCat.service;

import top.nextcat.SignCat.model.SignTask;
import top.nextcat.SignCat.model.result.Result;

import java.util.Date;

public interface SignService {
    void addAutoSignJob(SignTask signTask);
    Result autoSign(SignTask signTask);
    Result sign(SignTask signTask);
}
