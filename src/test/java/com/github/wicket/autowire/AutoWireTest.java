/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.wicket.autowire;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class AutoWireTest {

  private WicketTester tester;

  @Before
  public void setUp() {
    this.tester = new AutoWireTester();
  }

  @Test
  public void testBasicPage() {
    this.tester.startPage(BasicPage.class);
  }

  @Test
  public void testSubClassPage() {
    this.tester.startPage(SubClassPage.class);
  }

  @Test
  public void testBasicPanel() {
    this.tester.startComponentInPage(BasicPanel.class);
  }

  @Test
  public void testContainer() {
    this.tester.startPage(ContainerPage.class);
  }

  @Test
  public void testBorder() {
    this.tester.startPage(BorderPage.class);
  }

  @Test
  public void testCustomId() {
    this.tester.startComponentInPage(CustomIdPanel.class);
  }

  @Test
  public void testManualInstantiation() {
    this.tester.startPage(ManualInstantiationPage.class);
    this.tester.assertLabel("test1", "test1");
    this.tester.assertLabel("test2", "test2");
  }

  @Test
  public void testMissingCloseTag() {
    this.tester.startPage(MissingCloseTagPage.class);
  }

  @Test
  public void testChildMarkupContainer() {
    this.tester.startPage(ChildMarkupContainer.class);
  }

  @Test
  public void testPerformance() {
    long begin = System.currentTimeMillis();
    this.tester.startPage(PerformanceTest.class);
    System.out.println("Performance test took " + (System.currentTimeMillis() - begin) + "ms");
  }

  @Test
  public void testPerformanceCompare() {
    this.tester = new WicketTester();

    long begin = System.currentTimeMillis();
    this.tester.startPage(PerformanceCompareTest.class);
    System.out.println("Performance compare test took " + (System.currentTimeMillis() - begin) + "ms");
  }
}
