package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwd on 2017/3/15.
 */
public class ErrorMessage implements Serializable{
    private int line;
    private List<String> errors = new ArrayList<String>();

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
