package ebook.utils.authentication;

import java.security.Principal;

public class SimplePrincipal implements Principal {
    private String descr;
    private String value;

    public SimplePrincipal(String descr, String value) {
        this.descr = descr; this.value = value;
    }
    public String getName() {
        return descr + "=" + value;
    }

    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        SimplePrincipal other = (SimplePrincipal) otherObject;
        return getName().equals(other.getName());
    }
    public int hashCode() { return getName().hashCode(); }

}
