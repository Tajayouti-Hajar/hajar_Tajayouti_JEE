package org.sid.ecom.repositories;

import org.sid.ecom.enteties.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;



public interface ProductRepository extends JpaRepository<Product,String> {

}
