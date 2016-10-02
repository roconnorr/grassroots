/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

//import domain.Product;
import java.util.Collection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ocoro749
 */
/*public class JobDatabaseAccess implements ProductDataInterface {

    private String url = "jdbc:h2:tcp://localhost:9013/soultest;IFEXISTS=TRUE";

    public JobDatabaseAccess() {
    }

    public JobDatabaseAccess(String altUrl) {
        url = altUrl;
    }

    @Override
    public void saveProduct(Product p) {
        String sql = "merge into products (productid, name, description, category, price, quantityinstock) values (?,?,?,?,?,?)";
        
        try (   
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setInt(1, p.getProductID());
                stmt.setString(2, p.getName());
                stmt.setString(3, p.getDescription());
                stmt.setString(4, p.getCategory());
                stmt.setDouble(5, p.getPrice());
                stmt.setInt(6, p.getQuantityInStock());
                stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<Product> getProducts() {
        String sql = "select * from products order by productid";
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                ResultSet rs = stmt.executeQuery();
                List<Product> products = new ArrayList<>();
                while (rs.next()) {
                    Integer productID = rs.getInt("productid");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String category = rs.getString("category");
                    Double price = rs.getDouble("price");
                    Integer quantityInStock = rs.getInt("quantity");
                    Product p = new Product(productID, name, description, category, price, quantityInStock);
                    products.add(p);
                }
                return products;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<String> getCategories() {
        String sql = "select distinct category from products order by category";     
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                ResultSet rs = stmt.executeQuery();
                List<String> categories = new ArrayList<>();
                while(rs.next()){
                    String category = rs.getString("category");
                    categories.add(category);  
                }
                return categories;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Product searchProductID(Integer id) {
        String sql = "select * from products where productid = ?";
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();      
                if(rs.next()) {                  
                    Integer productID = rs.getInt("productid");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String category = rs.getString("category");
                    Double price = rs.getDouble("price");
                    Integer quantityInStock = rs.getInt("quantity");
                    Product p = new Product(productID, name, description, category, price, quantityInStock);
                    return p;
                }else{
                    return null;
                }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<Product> filterCategory(String categoryFilter) {
        String sql = "select * from products where category = ?";
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setString(1, categoryFilter);
                ResultSet rs = stmt.executeQuery();
                List<Product> products = new ArrayList<>();
                while (rs.next()) {
                    Integer productID = rs.getInt("productid");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String category = rs.getString("category");
                    Double price = rs.getDouble("price");
                    Integer quantityInStock = rs.getInt("quantity");
                    Product p = new Product(productID, name, description, category, price, quantityInStock);
                    products.add(p);
                }
                return products;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public void deleteProduct(Product p) {
        String sql = "delete from products where productid = ?";
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setInt(1, p.getProductID());
                stmt.executeUpdate();
        }catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
        
    }

}*/
