package com.vti.rw41.Repository;

import com.vti.rw41.Entity.Product;
import com.vti.rw41.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
public List<Product> getAllProduct(){
    Session session = HibernateUtils.getSessionFactory().openSession();
    Query<Product> query = session.createQuery("FROM Product order by id desc", Product.class);
    return query.getResultList();
}

    public Optional<Product> getProductById(Integer id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query<Product> query = session.createQuery("from Product where id = :ProductId", Product.class);
        query.setParameter("ProductId", id);
        return query.getResultStream().findFirst();
    }

    public Product addProduct(Product dto) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Product product = new Product();
        product.setProductName(dto.getProductName());
        session.save(product);
        session.getTransaction().commit();
        return product;
    }

    public Optional<Product> deleteProduct(Integer id) {
        Optional<Product> product = getProductById(id);
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("DELETE Product where id = :productId").setParameter("productId", id).executeUpdate();
        session.getTransaction().commit();
        return product;
    }

    public Optional<Product> updateProduct(Integer id, Product newProduct) {
        Optional<Product> productById = getProductById(id);
        Session session = HibernateUtils.getSessionFactory().openSession();
        if (productById.isPresent()) {
            Product oldProduct = productById.get();
            oldProduct.setProductName(newProduct.getProductName());
            session.beginTransaction();
            session.update(oldProduct);
            session.getTransaction().commit();
        }
        return productById;
    }

}
