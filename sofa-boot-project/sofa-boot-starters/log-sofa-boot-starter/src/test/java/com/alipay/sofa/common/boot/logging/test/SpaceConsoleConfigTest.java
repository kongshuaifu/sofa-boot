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
package com.alipay.sofa.common.boot.logging.test;

import com.alipay.sofa.common.log.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.SpringApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:guaner.zzx@alipay.com">Alaneuler</a>
 * Created on 2020/12/16
 */
public class SpaceConsoleConfigTest extends LogTestBase {
    /**
     * test sofa.middleware.log.{space id}.console config
     */
    @Test
    public void testSpaceConsoleConfig() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(
            String.format(Constants.SOFA_MIDDLEWARE_SINGLE_LOG_CONSOLE_SWITCH, TEST_SPACE), "true");
        properties.put("logging.level.test.space", "info");
        SpringApplication springApplication = new SpringApplication(EmptyConfig.class);
        springApplication.setDefaultProperties(properties);
        springApplication.run();
        logger = getLogger();
        logger.info("space console");
        logger.debug("space console debug");
        Assert.assertTrue(outContent.toString().contains("space console"));
        Assert.assertFalse(outContent.toString().contains("space console debug"));
    }
}
