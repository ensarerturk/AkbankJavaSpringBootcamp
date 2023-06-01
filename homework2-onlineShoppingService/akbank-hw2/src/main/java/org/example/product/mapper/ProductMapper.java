package org.example.product.mapper;

import org.example.product.Product;
import org.example.product.dto.ProductDTO;
import org.example.product.dto.ProductSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/*
 * This interface performs automatic conversions between "ProductS veDTO" and "Product DTO" classes using the MapStruct library.
 * */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toEntity(ProductSaveDTO productSaveDTO);

    ProductDTO toDTO(Product product);

    List<ProductDTO> toDTOList(List<Product> productList);
}
