package com.mc.mapper;

import com.mc.config.QkMapperConfig;
import com.mc.model.ProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductInfoMapper extends QkMapperConfig<ProductInfo> {
    List<ProductInfo> selectProductListByUserId(int userId);

    int selectProductCountByCondition(ProductInfo productInfo);

    void updateProductByIdAndUserId(ProductInfo productInfo);

    void deleteProductByIdAndUserId(ProductInfo productInfo);

    List<ProductInfo> selectProductListByUserIdAndCompanyId(@Param("userId") int userId, @Param("companyId") int companyId);
}