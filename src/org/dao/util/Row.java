/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.util;

/**
 *
 * @author ly.phong
 */
public class Row extends Object{
  private  Object[] values;
  private  Object attachedInfoObj;
  public Row(Object[] values, Object infoObj) {
    this.values = values;
    this.attachedInfoObj = infoObj;
  }

  public int getSize() {
    return values.length;
  }

  public Object getValue(int i) {
    return values[i];
  }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }

    public Object getAttachedInfoObj() {
        return attachedInfoObj;
    }

    public void setAttachedInfoObj(Object attachedInfoObj) {
        this.attachedInfoObj = attachedInfoObj;
    }
  
}