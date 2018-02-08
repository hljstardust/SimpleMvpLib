/*
 * Copyright 2016, The Android Open Source Project
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

package com.autohome.mvplib.usecase;


/**
 * 抽取DomainLayer，避免present层代码重复
 * @author yangliqiang
 * @date 2017/3/24
 */
public class UseCaseHandler {

    private static UseCaseHandler INSTANCE;

    private UseCaseHandler() {
    }

    public <T extends UseCase.RequestValues, R extends UseCase.ResponseValue> void execute(
            UseCase<T, R> useCase, T values, UseCase.UseCaseCallback<R> callback) {
        useCase.setRequestValues(values);
        useCase.setUseCaseCallback(callback);
        useCase.run();

    }

    public static UseCaseHandler getInstance() {
        if (INSTANCE == null) {
            synchronized (UseCaseHandler.class){
                if(INSTANCE == null){
                    INSTANCE = new UseCaseHandler();
                }
            }
        }
        return INSTANCE;
    }
}
