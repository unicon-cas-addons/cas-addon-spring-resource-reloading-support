package net.unicon.cas.addon.spring.resource.config;

import net.unicon.cas.addon.spring.resource.ResourceChangeDetectingEventNotifier;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.w3c.dom.Element;


/**
 *
 * {@link org.springframework.beans.factory.xml.NamespaceHandler} for convenient <i>resource</i> configuration namespace.
 *
 * @author Dmitriy Kopylenko
 * @since 1.0.0
 */
public class CasAddonResourceNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("change-detector", new ResourceChangeDetectingEventNotifierBeanDefinitionParser());
    }

    /**
     * Parses <pre>change-detector</pre> elements into bean definitions of type {@link ResourceChangeDetectingEventNotifier}
     */
    private static class ResourceChangeDetectingEventNotifierBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

        @Override
        protected Class<?> getBeanClass(Element element) {
            return ResourceChangeDetectingEventNotifier.class;
        }

        @Override
        protected void doParse(Element element, BeanDefinitionBuilder builder) {
            builder.addConstructorArgValue(element.getAttribute("watched-resource"));
        }
    }
}
