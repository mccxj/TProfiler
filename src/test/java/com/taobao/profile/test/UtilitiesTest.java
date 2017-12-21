package com.taobao.profile.test;

import com.taobao.profile.utils.Utilities;
import com.taobao.profile.utils.VariableNotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class UtilitiesTest{

  @Test
  public void testRepleseVariables() throws VariableNotFoundException{
    String source = "${user.home}/logs/${user.language}/tprofiler.log";
    String str1 = Utilities.repleseVariables(source, System.getProperties());
    String str2 = System.getProperty("user.home") + "/logs/" + System.getProperty("user.language") + "/tprofiler.log";  
    Assert.assertEquals(str1, str2);
  }
}
