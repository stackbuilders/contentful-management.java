/*
 * Copyright (C) 2014 Contentful GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.contentful.java.cma;

import com.contentful.java.cma.model.CMAArray;
import com.contentful.java.cma.model.CMALocale;
import com.contentful.java.cma.model.CMASpace;

import java.util.HashMap;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Spaces Service.
 */
interface ServiceSpaces {
  @POST("/spaces")
  Observable<CMASpace> create(
      @Body CMASpace space);

  @POST("/spaces")
  Observable<CMASpace> create(
      @Header("X-Contentful-Organization") String organization,
      @Body CMASpace space);

  @DELETE("/spaces/{space}")
  Observable<String> delete(
      @Path("space") String spaceId);

  @GET("/spaces")
  Observable<CMAArray<CMASpace>> fetchAll(
      @QueryMap HashMap<String, String> query
      );

  @GET("/spaces/{space}")
  Observable<CMASpace> fetchOne(
      @Path("space") String spaceId);

  @GET("/spaces/{space}/locales")
  Observable<CMAArray<CMALocale>> fetchLocales(
      @Path("space") String spaceId,
      @QueryMap HashMap<String, String> query
  );

  @PUT("/spaces/{space}")
  Observable<CMASpace> update(
      @Header("X-Contentful-Version") Integer version,
      @Path("space") String spaceId,
      @Body CMASpace space);
}
