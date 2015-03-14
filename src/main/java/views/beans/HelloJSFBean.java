package views.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloJSFBean {
    private String name="Hola, desde Bean. OK!!!";

    public String getName() {
        return name;
    }
}
