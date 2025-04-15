package org.sistema_categorias.Repository;

import org.sistema_categorias.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
