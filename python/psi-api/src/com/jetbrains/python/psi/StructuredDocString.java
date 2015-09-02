/*
 * Copyright 2000-2014 JetBrains s.r.o.
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
package com.jetbrains.python.psi;

import com.jetbrains.python.toolbox.Substring;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author vlan
 */
public interface StructuredDocString {
  /**
   * Creates parameter type documentation specific for certain doct type
   * @param name param name
   * @param type param type
   * @return text to add to docsting
   */
  @NotNull
  String createParameterType(@NotNull String name, @NotNull String type);

  String getSummary();
  String getDescription(); // for formatter

  @NotNull
  List<String> getParameters();

  /**
   * @return all names of parameters mentioned in the docstring as substrings.
   */
  @NotNull
  List<Substring> getParameterSubstrings();

  /**
   * @param paramName {@code null} can be used for unnamed parameters descriptors, e.g. in docstring following class attribute
   */
  @Nullable
  String getParamType(@Nullable String paramName);

  /**
   * @param paramName {@code null} can be used for unnamed parameters descriptors, e.g. in docstring following class attribute
   */
  @Nullable
  Substring getParamTypeSubstring(@Nullable String paramName);

  /**
   * @param paramName {@code null} can be used for unnamed parameters descriptors, e.g. in docstring following class attribute
   */
  @Nullable
  String getParamDescription(@Nullable String paramName);
  /**
   * Keyword arguments are those arguments that usually don't exist in function signature, 
   * but are passed e.g. via {@code **kwargs} mechanism. 
   */
  @NotNull
  List<String> getKeywordArguments();
  @NotNull
  List<Substring> getKeywordArgumentSubstrings();

  // getKeywordArgumentType(name)
  // getKeywordArgumentTypeString(name)  
  @Nullable
  String getKeywordArgumentDescription(@Nullable String paramName);
  @Nullable
  String getReturnType();
  @Nullable
  Substring getReturnTypeSubstring();

  @Nullable
  String getReturnDescription(); // for formatter
  @NotNull
  List<String> getRaisedExceptions(); // for formatter

  @Nullable
  String getRaisedExceptionDescription(@Nullable String exceptionName); // for formatter

  // getAttributes
  // getAttributeSubstrings
  // getAttributeType(name)
  // getAttributeTypeSubstring(name)
  @Nullable
  String getAttributeDescription(); // for formatter

  // Tags related methods
}
