package org.sid.ecom.repositories;

import org.sid.ecom.enteties.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
