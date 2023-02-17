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
package com.alipay.sofa.smoke.tests.rpc.bean.invoke;

import com.alipay.sofa.rpc.core.exception.SofaRpcException;
import com.alipay.sofa.rpc.core.invoke.SofaResponseCallback;
import com.alipay.sofa.rpc.core.request.RequestBase;

/**
 * @author <a href="mailto:lw111072@antfin.com">LiWei</a>
 */
public class CallbackImpl implements SofaResponseCallback {

    public static String result;

    @Override
    public void onAppResponse(Object appResponse, String methodName, RequestBase request) {
        result = (String) appResponse;
    }

    @Override
    public void onAppException(Throwable throwable, String methodName, RequestBase request) {

    }

    @Override
    public void onSofaException(SofaRpcException sofaException, String methodName,
                                RequestBase request) {

    }
}