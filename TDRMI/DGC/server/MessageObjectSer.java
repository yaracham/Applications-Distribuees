package server;

import java.io.Serializable;

public interface MessageObjectSer extends Serializable {
    int getNumberFromObject();
    int getNumberFromClass();
}
