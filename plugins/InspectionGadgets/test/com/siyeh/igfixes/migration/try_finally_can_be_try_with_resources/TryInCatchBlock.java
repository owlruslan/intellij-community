/*
 * Copyright 2000-2017 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */
import java.io.Reader;

class X {
  public void test() throws Exception {
    Reader r = new FileReader("");

    <caret>try {
      r.read();
    }
    finally {
      try { // 1
        r.close();
      } catch(Exception e) {/*2*/
      }
    }
  }
}