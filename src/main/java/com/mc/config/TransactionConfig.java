package com.mc.config;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Properties;

/**
 * @author chenglongchu
 * @description 根据方法命名自动管理事务
 * @create 2018/5/28 16:51
 */
@Configuration
public class TransactionConfig {
	private static final String PROPAGATION_REQUIRED = "PROPAGATION_REQUIRED,-Exception";
	private static final String PROPAGATION_SUPPORTS = "PROPAGATION_SUPPORTS";
//	private static final String[] methodRequired = new String[] { "save*", "insert*", "delete*", "update*", "opt*" };
	private static final String[] methodRequired = new String[] { "save*", "add*", "insert*", "del*", "delete*", "upd*", "update*", "opt*" };
	private static final String[] methodsReadOnly = new String[] { "find*", "get*", "select*", "has*", "is*","*" };

	/**
	 * @description spring事务的拦截器
	 * @param platformTransactionManager 事务管理器
	 * @return TransactionInterceptor 事务拦截器
	 * @author ChenglongChu
	 * @create 2018/5/30 17:04
	**/
	public TransactionInterceptor transactionInterceptor(PlatformTransactionManager platformTransactionManager) {
		TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
		transactionInterceptor.setTransactionManager(platformTransactionManager);
		Properties transactionAttributes = new Properties();
		// PROPAGATION_REQUIRED事务机制
		for (int i = 0; i < methodRequired.length; i++) {
			String key = methodRequired[i];
			transactionAttributes.put(key, PROPAGATION_REQUIRED);
		}
		// PROPAGATION_SUPPORTS事务机制
		for (int i = 0; i < methodsReadOnly.length; i++) {
			String key = methodsReadOnly[i];
			transactionAttributes.put(key, PROPAGATION_SUPPORTS);
		}
		transactionInterceptor.setTransactionAttributes(transactionAttributes);
		return transactionInterceptor;
	}

	/**
	 * @description 事务代理
	 * @param platformTransactionManager 事务管理器
	 * @author ChenglongChu
	 * @create 2018/5/30 17:06
	**/
	@Bean(name="transactionAutoProxy")
	public AspectJExpressionPointcutAdvisor transactionAutoProxy(@Qualifier("primaryDataSourceTransactionManager") PlatformTransactionManager platformTransactionManager) {
		AspectJExpressionPointcutAdvisor transactionAutoProxy = new AspectJExpressionPointcutAdvisor();
		transactionAutoProxy.setAdvice(transactionInterceptor(platformTransactionManager));
		// 对service层进行事务代理
		transactionAutoProxy.setExpression("execution(* com.mc.service..*(..))");
		return transactionAutoProxy;
	}

}
