package me.xiao.spring.factory;

import me.xiao.spring.BeanDefinition;
import me.xiao.spring.PropertyValue;

import java.lang.reflect.Field;

/**
 * 可以自动装载的bean工厂
 *
 * @author BaoQiang
 * @version 2.0
 * @Create at 2016/10/25 15:18
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = createBeanInstance(beanDefinition);
        appPropertyValues(bean,beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void appPropertyValues(Object bean, BeanDefinition mbd) throws Exception{
        for (PropertyValue propertyValue: mbd.getPropertyValues().getPropertyValues()){
            Field declaredFiled = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredFiled.setAccessible(true);
            declaredFiled.set(bean,propertyValue.getValue());
        }
    }

}
