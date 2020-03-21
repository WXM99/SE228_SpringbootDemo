package ebook.utils;

import java.security.Permission;

public class FilePermission extends Permission {

  private String actions;

  public FilePermission(String path, String actions) {
    super(path);
    this.actions = actions;
  }

  @Override
  public boolean implies(Permission permission) {
    if (! (permission instanceof FilePermission) )
      return false;
    FilePermission fp = (FilePermission) permission;
    // The	target	file	set	of	p1	contains	the	target	file	set	of	p2.
    boolean file_contained = false;
    String last_char = this.getName().substring(this.getName().length()-1);
    if (last_char.equals("-")) { // end up with '-'
      String rest =  this.getName().substring(0, this.getName().length()-1);
      if (fp.getName().contains(rest)) { // this.path covers fp's
        file_contained = true;
      }
    }
    // The	action	set	of	p1	contains	the	action	set	of	p2.
    boolean action_contained = false;
    if (this.getActions().contains(fp.getActions())) {
      action_contained = true;
    }
    return file_contained && action_contained;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!this.getClass().equals(obj.getClass())) {
      return false;
    }
    FilePermission fp = (FilePermission) obj;
    // same path and same actions
    return fp.getActions().equals(((FilePermission) obj).getActions())
        && fp.getName().equals(((FilePermission) obj).getName());
  }

  @Override
  public int hashCode() {
    return this.getName().hashCode() + this.actions.hashCode();
  }

  @Override
  public String getActions() {
    return this.actions;
  }
}
