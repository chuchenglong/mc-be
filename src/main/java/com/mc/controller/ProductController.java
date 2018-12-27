package com.mc.controller;

import com.mc.constant.ThreadLocalConstant;
import com.mc.model.ProductInfo;
import com.mc.service.ProductService;
import com.mc.system.McBusinessException;
import com.mc.system.McResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/getProductList", method = RequestMethod.POST)
    public McResult getProductList() throws McBusinessException {
        List<ProductInfo> productInfos = productService.getProductListByUserId(ThreadLocalConstant.getLocalUser().getUserId());
        // 返回成功结果信息
        return McResult.newSuccess(productInfos);
    }

    @RequestMapping(value = "/getProductListByCompanyId", method = RequestMethod.POST)
    public McResult getProductListByCompanyId(@RequestBody ProductInfo productInfo) throws McBusinessException {
        List<ProductInfo> productInfos = productService.getProductListByUserIdAndCompanyId(ThreadLocalConstant.getLocalUser().getUserId(), productInfo.getCompanyId());
        // 返回成功结果信息
        return McResult.newSuccess(productInfos);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public McResult addProduct(@RequestBody ProductInfo productInfo) throws McBusinessException {
        productInfo.setUserId(ThreadLocalConstant.getLocalUser().getUserId());
        productService.checkProductIsUsed(productInfo);
        productService.addProduct(productInfo);
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public McResult updateProduct(@RequestBody ProductInfo productInfo) throws McBusinessException {
        productInfo.setUserId(ThreadLocalConstant.getLocalUser().getUserId());
        productService.checkProductIsExists(productInfo);
        productService.updateProductByIdAndUserId(productInfo);
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public McResult deleteProduct(@RequestBody ProductInfo productInfo) throws McBusinessException {
        productInfo.setUserId(ThreadLocalConstant.getLocalUser().getUserId());
        productService.checkProductIsExists(productInfo);
        productService.deleteProductByIdAndUserId(productInfo);
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }
}
