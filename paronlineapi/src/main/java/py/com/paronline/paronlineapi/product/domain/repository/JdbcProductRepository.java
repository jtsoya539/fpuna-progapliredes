/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.product.domain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import py.com.paronline.paronlineapi.product.domain.model.entity.Product;
import py.com.paronline.paronlineapi.product.domain.model.entity.ProductCategory;
import py.com.paronline.paronlineapi.util.DBUtils;

/**
 *
 * @author javie
 */
public class JdbcProductRepository implements ProductRepository {

    @Override
    public boolean containsDescripcion(String descripcion) {
        try {
            return this.findByDescripcion(descripcion).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    @Override
    public boolean containsCategoria(ProductCategory categoria) {
        try {
            return this.findByCategoria(categoria).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    @Override
    public boolean containsPrecioUnit(double precioUnit) {
        try {
            return this.findByPrecioUnit(precioUnit).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    @Override
    public Collection<Product> findByDescripcion(String descripcion) throws Exception {
        Collection<Product> retValue = new ArrayList();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM producto WHERE descripcion = ?");

            pstmt.setString(1, descripcion);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retValue.add(new Product(rs.getInt("id_producto"), rs.getString("descripcion"), getProductCategory(rs.getInt("id_categoria")), rs.getDouble("precio_unit"), rs.getInt("cantidad")));
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
    public Collection<Product> findByCategoria(ProductCategory categoria) throws Exception {
        Collection<Product> retValue = new ArrayList();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM producto WHERE id_categoria = ?");

            pstmt.setInt(1, categoria.getId());

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retValue.add(new Product(rs.getInt("id_producto"), rs.getString("descripcion"), getProductCategory(rs.getInt("id_categoria")), rs.getDouble("precio_unit"), rs.getInt("cantidad")));
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
    public Collection<Product> findByPrecioUnit(double precioUnit) throws Exception {
        Collection<Product> retValue = new ArrayList();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM producto WHERE precio_unit = ?");

            pstmt.setDouble(1, precioUnit);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retValue.add(new Product(rs.getInt("id_producto"), rs.getString("descripcion"), getProductCategory(rs.getInt("id_categoria")), rs.getDouble("precio_unit"), rs.getInt("cantidad")));
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
    public void add(Product entity) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO producto (descripcion, id_categoria, precio_unit, cantidad) VALUES (?, ?, ?, ?)");

            pstmt.setString(1, entity.getDescripcion());
            pstmt.setInt(2, entity.getCategoria().getId());
            pstmt.setDouble(3, entity.getPrecioUnit());
            pstmt.setInt(4, entity.getCantidad());

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
            pstmt = conn.prepareStatement("DELETE FROM producto WHERE id_producto = ?");

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
    public void update(Product entity) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("UPDATE producto SET descripcion = ?, id_categoria = ?, precio_unit = ?, cantidad = ? WHERE id_producto = ?");

            pstmt.setString(1, entity.getDescripcion());
            pstmt.setInt(2, entity.getCategoria().getId());
            pstmt.setDouble(3, entity.getPrecioUnit());
            pstmt.setInt(4, entity.getCantidad());
            pstmt.setInt(5, entity.getId());

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
    public Product get(Integer id) {
        Product retValue = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM producto WHERE id_producto = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue = new Product(rs.getInt("id_producto"), rs.getString("descripcion"), getProductCategory(rs.getInt("id_categoria")), rs.getDouble("precio_unit"), rs.getInt("cantidad"));
            } else {
                retValue = new Product();
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
    public Collection<Product> getAll() {
        Collection<Product> retValue = new ArrayList();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM producto");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retValue.add(new Product(rs.getInt("id_producto"), rs.getString("descripcion"), getProductCategory(rs.getInt("id_categoria")), rs.getDouble("precio_unit"), rs.getInt("cantidad")));
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

    private ProductCategory getProductCategory(Integer id) {
        ProductCategory retValue = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM categoria WHERE id_categoria = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue = new ProductCategory(rs.getInt("id_categoria"), rs.getString("descripcion"));
            } else {
                retValue = new ProductCategory();
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
