/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.transaction.domain.service;

import java.util.Collection;
import py.com.paronline.paronlineapi.transaction.domain.model.entity.Transaction;

/**
 *
 * @author javie
 */
public interface TransactionService {

    public void add(Transaction transaction) throws Exception;

    public void update(Transaction transaction) throws Exception;

    public void delete(Integer id) throws Exception;

    public Transaction findById(Integer id) throws Exception;

    public Collection<Transaction> findByCliente(String nombre, String apellido) throws Exception;

    public Collection<Transaction> findByEstado(String estado) throws Exception;

    public Collection<Transaction> findByTotal(double total) throws Exception;

}
