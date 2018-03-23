package Resource;

import Util.Date;
import Util.Hour;
import User.Person;

public class Resource {
    private String ident;
    private Date dInicio;
    private Hour hInicio;
    private Date dTermino;
    private Hour htermino;
    private Person user;
    private String status = "Em processo de alocação";
    private Atividade event;
}
