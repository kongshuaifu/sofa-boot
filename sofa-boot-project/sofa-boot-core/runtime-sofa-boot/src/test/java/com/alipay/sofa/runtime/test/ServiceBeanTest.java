/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.runtime.test;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.test.beans.facade.SampleService;
import com.alipay.sofa.runtime.test.beans.service.SofaServiceBeanService;
import com.alipay.sofa.runtime.test.configuration.RuntimeConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ServiceBeanTest
 *
 * @author xunfang
 * @version ServiceBeanTest.java, v 0.1 2023/5/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = "spring.application.name=SofaServiceBeanService")
@Import(SofaServiceBeanService.class)
public class ServiceBeanTest {
    @SofaReference(uniqueId = "sofaServiceBeanService")
    private SampleService sofaServiceBeanService;

    @Test
    public void testSofaServiceBean() {
        Assert.assertNotNull(sofaServiceBeanService);
        Assert.assertEquals("sofaServiceBeanService", sofaServiceBeanService.service());
    }

    @Configuration(proxyBeanMethods = false)
    @Import(RuntimeConfiguration.class)
    static class ServiceBeanTestConfiguration {

    }

}
