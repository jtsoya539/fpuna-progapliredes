/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.transaction.domain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import py.com.paronline.paronlineapi.product.domain.repository.JdbcProductRepository;
import py.com.paronline.paronlineapi.product.domain.service.ProductServiceImpl;
import py.com.paronline.paronlineapi.transaction.domain.model.entity.Transaction;
import py.com.paronline.paronlineapi.transaction.domain.model.entity.TransactionDetail;
import py.com.paronline.paronlineapi.user.domain.repository.JdbcUserRepository;
import py.com.paronline.paronlineapi.user.domain.service.UserServiceImpl;
import py.com.paronline.paronlineapi.util.DBUtils;

/**
 *
 * @author javie
 */
public class JdbcTransactionRepository implements TransactionRepository {

    private final UserServiceImpl userService = new UserServiceImpl(new JdbcUserRepository());
    private final ProductServiceImpl productService = new ProductServiceImpl(new JdbcProductRepository());

    @Override
    public boolean containsCliente(String nombre, String apellido) {
        try {
            return this.findByCliente(nombre, apellido).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    @Override
    public boolean containsEstado(String estado) {
        try {
            return this.findByEstado(estado).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    @Override
    public boolean containsTotal(double total) {
        try {
            return this.findByTotal(total).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    @Override
    public Collection<Transaction> findByCliente(String nombre, String apellido) throws Exception {
        Collection<Transaction> retValue = new ArrayList();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transaction transaction = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("SELECT t.* FROM transacciones_cab t, cliente c WHERE c.id_cliente = t.id_cliente AND c.nombre = ? AND c.apellido = ?");

            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                transaction = new Transaction();
                transaction.setId(rs.getInt("id_transaccion"));
                transaction.setFecha(rs.getDate("fecha"));
                transaction.setCliente(userService.findById(rs.getInt("id_cliente")));
                transaction.setTotal(rs.getDouble("total"));
                transaction.setDireccionEnvio(rs.getString("direccion_envio"));
                transaction.setIdMedioPago(rs.getInt("id_medio_pago"));
                transaction.setNroTarjeta(rs.getInt("nro_tarjeta"));
                transaction.setEstado(rs.getString("estado"));
                transaction.setDetalles((ArrayList<TransactionDetail>) getTransactionDetails(transaction.getId()));
                retValue.add(transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(conn);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }

    @Override
    public Collection<Transaction> findByEstado(String estado) throws Exception {
        Collection<Transaction> retValue = new ArrayList();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transaction transaction = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM transacciones_cab WHERE estado = ?");

            pstmt.setString(1, estado);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                transaction = new Transaction();
                transaction.setId(rs.getInt("id_transaccion"));
                transaction.setFecha(rs.getDate("fecha"));
                transaction.setCliente(userService.findById(rs.getInt("id_cliente")));
                transaction.setTotal(rs.getDouble("total"));
                transaction.setDireccionEnvio(rs.getString("direccion_envio"));
                transaction.setIdMedioPago(rs.getInt("id_medio_pago"));
                transaction.setNroTarjeta(rs.getInt("nro_tarjeta"));
                transaction.setEstado(rs.getString("estado"));
                transaction.setDetalles((ArrayList<TransactionDetail>) getTransactionDetails(transaction.getId()));
                retValue.add(transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(conn);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }

    @Override
    public Collection<Transaction> findByTotal(double total) throws Exception {
        Collection<Transaction> retValue = new ArrayList();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transaction transaction = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM transacciones_cab WHERE total = ?");

            pstmt.setDouble(1, total);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                transaction = new Transaction();
                transaction.setId(rs.getInt("id_transaccion"));
                transaction.setFecha(rs.getDate("fecha"));
                transaction.setCliente(userService.findById(rs.getInt("id_cliente")));
                transaction.setTotal(rs.getDouble("total"));
                transaction.setDireccionEnvio(rs.getString("direccion_envio"));
                transaction.setIdMedioPago(rs.getInt("id_medio_pago"));
                transaction.setNroTarjeta(rs.getInt("nro_tarjeta"));
                transaction.setEstado(rs.getString("estado"));
                transaction.setDetalles((ArrayList<TransactionDetail>) getTransactionDetails(transaction.getId()));
                retValue.add(transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(conn);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }

    @Override
    public void add(Transaction entity) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO transacciones_cab (id_transaccion, fecha, id_cliente, total, direccion_envio, id_medio_pago, nro_tarjeta, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            pstmt.setInt(1, entity.getId());
            pstmt.setDate(2, (java.sql.Date) entity.getFecha());
            pstmt.setInt(3, entity.getCliente().getId());
            pstmt.setDouble(4, entity.getTotal());
            pstmt.setString(5, entity.getDireccionEnvio());
            pstmt.setInt(6, entity.getIdMedioPago());
            pstmt.setInt(7, entity.getNroTarjeta());
            pstmt.setString(8, entity.getEstado());

            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(conn);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void remove(Integer id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("DELETE FROM transacciones_cab WHERE id_transaccion = ?");

            pstmt.setInt(1, id);

            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(conn);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(Transaction entity) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("UPDATE transacciones_cab SET fecha = ?, id_cliente = ?, total = ?, direccion_envio = ?, id_medio_pago = ?, nro_tarjeta = ?, estado = ? WHERE id_transaccion = ?");

            pstmt.setDate(1, (java.sql.Date) entity.getFecha());
            pstmt.setInt(2, entity.getCliente().getId());
            pstmt.setDouble(3, entity.getTotal());
            pstmt.setString(4, entity.getDireccionEnvio());
            pstmt.setInt(5, entity.getIdMedioPago());
            pstmt.setInt(6, entity.getNroTarjeta());
            pstmt.setString(7, entity.getEstado());
            pstmt.setInt(8, entity.getId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(conn);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean contains(Integer id) {
        return this.get(id).getId() > 0;
    }

    @Override
    public Transaction get(Integer id) {
        Transaction retValue = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transaction transaction = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM transacciones_cab WHERE id_transaccion = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                transaction = new Transaction();
                transaction.setId(rs.getInt("id_transaccion"));
                transaction.setFecha(rs.getDate("fecha"));
                transaction.setCliente(userService.findById(rs.getInt("id_cliente")));
                transaction.setTotal(rs.getDouble("total"));
                transaction.setDireccionEnvio(rs.getString("direccion_envio"));
                transaction.setIdMedioPago(rs.getInt("id_medio_pago"));
                transaction.setNroTarjeta(rs.getInt("nro_tarjeta"));
                transaction.setEstado(rs.getString("estado"));
                transaction.setDetalles((ArrayList<TransactionDetail>) getTransactionDetails(transaction.getId()));
                retValue = transaction;
            } else {
                retValue = new Transaction();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(conn);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }

    @Override
    public Collection<Transaction> getAll() {
        Collection<Transaction> retValue = new ArrayList();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transaction transaction = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM transacciones_cab");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                transaction = new Transaction();
                transaction.setId(rs.getInt("id_transaccion"));
                transaction.setFecha(rs.getDate("fecha"));
                transaction.setCliente(userService.findById(rs.getInt("id_cliente")));
                transaction.setTotal(rs.getDouble("total"));
                transaction.setDireccionEnvio(rs.getString("direccion_envio"));
                transaction.setIdMedioPago(rs.getInt("id_medio_pago"));
                transaction.setNroTarjeta(rs.getInt("nro_tarjeta"));
                transaction.setEstado(rs.getString("estado"));
                transaction.setDetalles((ArrayList<TransactionDetail>) getTransactionDetails(transaction.getId()));
                retValue.add(transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(conn);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }

    private Collection<TransactionDetail> getTransactionDetails(Integer id) {
        Collection<TransactionDetail> retValue = new ArrayList();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TransactionDetail transactionDetail = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM transacciones_det WHERE id_transaccion = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                transactionDetail = new TransactionDetail();
                transactionDetail.setIdTransaccion(rs.getInt("id_transaccion"));
                transactionDetail.setItem(rs.getInt("item"));
                transactionDetail.setProducto(productService.findById(rs.getInt("id_producto")));
                transactionDetail.setCantidad(rs.getInt("cantidad"));
                transactionDetail.setPrecio(rs.getDouble("precio"));
                transactionDetail.setSubTotal(rs.getDouble("sub_total"));
                retValue.add(transactionDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(conn);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }

}
