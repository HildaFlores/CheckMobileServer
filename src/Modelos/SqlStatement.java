/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Modelos.OperacionSql.SqlOperation;

/**
 *
 * @author Prueba
 */
public class SqlStatement {
    
     private SqlOperation operation;
    private String table, projection, arguments, orderBy;

    public SqlOperation getOperation() {
        return operation;
    }

    public void setOperation(SqlOperation operation) {
        this.operation = operation;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getProjection() {
        return projection;
    }

    public void setProjection(String projection) {
        this.projection = projection;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = "order by " + orderBy;
    }

    @Override
    public String toString() {
        return operation.name() + " " + projection + " FROM " + table + " " + arguments + " " + orderBy;
    }
}
