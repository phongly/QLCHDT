/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ly.phong
 */
// TableModel implementation that will be populated by SwingWorker.
public class ResultSetTableModel extends AbstractTableModel {
  private final List<Row> rows;

  public ResultSetTableModel() {
    this.rows = new ArrayList<Row>();
  }

  public int getRowCount() {
    return rows.size();
  }

  public int getColumnCount() {
    return rows.get(0).getSize();
  }

  public Object getValue(int row, int column) {
    return rows.get(row).getValue(column);
  }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = rows.get(rowIndex).getValue(rowIndex);
        return value;
    }

}
