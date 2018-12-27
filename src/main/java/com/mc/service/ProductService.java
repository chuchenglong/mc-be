package com.mc.service;

import com.mc.constant.TipsConstant;
import com.mc.mapper.ProductInfoMapper;
import com.mc.model.ProductInfo;
import com.mc.system.McBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductInfoMapper productInfoMapper;

    public List<ProductInfo> getProductListByUserId(int userId) throws McBusinessException {
        if (userId == 0)
            throw new McBusinessException(TipsConstant.NULL_USER);
        return productInfoMapper.selectProductListByUserId(userId);
    }

    public void checkProductIsUsed(ProductInfo productInfo) throws McBusinessException {
        int count = productInfoMapper.selectProductCountByCondition(productInfo);
        if (count > 0)
            throw new McBusinessException(TipsConstant.USED_PRODUCT);
    }

    public void addProduct(ProductInfo productInfo) {
        productInfoMapper.insert(productInfo);
    }

    public void checkProductIsExists(ProductInfo productInfo) throws McBusinessException {
        if (productInfo.getId() == null)
            throw new McBusinessException(TipsConstant.NULL_PRODUCT);
        if (productInfo.getUserId() == null || productInfo.getUserId() == 0)
            throw new McBusinessException(TipsConstant.NULL_USER);
    }

    public void updateProductByIdAndUserId(ProductInfo productInfo) throws McBusinessException {
        productInfoMapper.updateProductByIdAndUserId(productInfo);
    }


    public void deleteProductByIdAndUserId(ProductInfo productInfo) {
        productInfoMapper.deleteProductByIdAndUserId(productInfo);
    }

    public List<ProductInfo> getProductListByUserIdAndCompanyId(int userId, int companyId) throws McBusinessException {
        if (userId == 0)
            throw new McBusinessException(TipsConstant.NULL_USER);
        if (companyId == 0)
            throw new McBusinessException(TipsConstant.NULL_COMPANY);
        return productInfoMapper.selectProductListByUserIdAndCompanyId(userId, companyId);

    }
}
