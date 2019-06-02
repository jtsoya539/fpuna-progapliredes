/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.transaction.domain.repository;

import java.util.Collection;
import py.com.paronline.paronlineapi.common.domain.repository.Repository;
import py.com.paronline.paronlineapi.transaction.domain.model.entity.Transaction;

/**
 *
 * @author javie
 */
public interface TransactionRepository extends Repository<Transaction, Integer> {

    public boolean containsCliente(String nombre, String apellido);

    public boolean containsEstado(String estado);

    public boolean containsTotal(double total);

    public Collection<Transaction> findByCliente(String nombre, String apellido) throws Exception;

    public Collection<Transaction> findByEstado(String estado) throws Exception;

    public Collection<Transaction> findByTotal(double total) throws Exception;

}
