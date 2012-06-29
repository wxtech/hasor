/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.more.webui.web;
import org.more.webui.context.BeanManager;
import org.more.webui.context.FacesConfig;
import org.more.webui.context.FacesContext;
import org.more.webui.freemarker.loader.ClassPathTemplateLoader;
import org.more.webui.lifestyle.Lifecycle;
import freemarker.template.Configuration;
/**
 * Ĭ��ʵ��
 * @version : 2012-6-27
 * @author ������ (zyc@byshell.org)
 */
public class DefaultWebUIFactory implements WebUIFactory {
    /**����{@link Lifecycle}����*/
    public Lifecycle createLifestyle(FacesConfig config, FacesContext context) {
        return Lifecycle.getDefault(config, context);
    }
    /**����{@link FacesContext}����*/
    public FacesContext createFacesContext(FacesConfig config) {
        return new DefaultFacesContext(config);
    }
}
class DefaultFacesContext extends FacesContext {
    private BeanManager   bManager = new DefaultBeanManager();
    private Configuration cfg      = null;
    public DefaultFacesContext(FacesConfig facesConfig) {
        super(facesConfig);
    }
    public BeanManager getBeanContext() {
        return bManager;
    }
    public Configuration createFreemarker() {
        if (cfg != null)
            return cfg;
        cfg = new Configuration();
        cfg.setTemplateLoader(new ClassPathTemplateLoader(null));
        return cfg;
    }
}
class DefaultBeanManager implements BeanManager {
    @Override
    public <T> T getBean(Class<?> type) {
        try {
            return (T) type.newInstance();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}