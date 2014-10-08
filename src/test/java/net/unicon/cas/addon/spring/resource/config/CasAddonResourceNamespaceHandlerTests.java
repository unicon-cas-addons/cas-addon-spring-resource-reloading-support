package net.unicon.cas.addon.spring.resource.config;

import net.unicon.cas.addon.spring.resource.ResourceChangeDetectingEventNotifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author Dmitriy Kopylenko
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CasAddonResourceNamespaceHandlerTests {

    @Autowired
    ApplicationContext applicationContext;

    private static final String RESOURCE_CHANGE_DETECTOR_BEAN_NAME = "testChangeDetector";

    @Test
    public void resourceChangeDetectingEventNotifierBeanDefinitionCorrectlyParsed() {
        assertTrue(applicationContext.containsBean(RESOURCE_CHANGE_DETECTOR_BEAN_NAME));
        assertTrue(applicationContext.getBeansOfType(ResourceChangeDetectingEventNotifier.class).size() == 1);
    }
}
