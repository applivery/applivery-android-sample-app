package com.applivery.applvsdklib;

import android.content.Context;
import com.applivery.applvsdklib.domain.exceptions.AppliverySdkNotInitializedException;
import com.applivery.applvsdklib.tools.utils.Validate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 25/12/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidateUtilsTest {

  @Mock Context context;

  //region notNull
  @Test(expected = NullPointerException.class)
    public void notNullValitadionWithNull() throws Exception {
    Validate.notNull(null, "Test null");
  }

  @Test
  public void notNullValitadionWithoutNull() throws Exception {
    Validate.notNull("NOT NULL", "Test null");
    assertTrue(true);
  }

  @Test
  public void notNullValitadionWithEmptyString() throws Exception {
    Validate.notNull("", "Test null");
    assertTrue(true);
  }
  //endregion

  //region empty
  @Test(expected = IllegalArgumentException.class)
  public void notEmptyValitadionWithEmpty() throws Exception {
    List<String> strings = new ArrayList<>();
    Validate.notEmpty(strings, "Empty Array");
  }

  @Test
  public void notEmptyValitadionWithElements() throws Exception {
    List<String> strings = new ArrayList<>();
    strings.add("Hello");
    Validate.notEmpty(strings, "Test not Empty");
    assertTrue(true);
  }
  //endregion

  //region contains no nulls
  @Test(expected = NullPointerException.class)
  public void containsNoNullsValitadionWithNulls() throws Exception {
    List<String> strings = new ArrayList<>();
    strings.add(null);
    strings.add("Hello");
    Validate.containsNoNulls(strings, "null value");
  }

  @Test
  public void containsNoNullsValitadionWithoutNulls() throws Exception {
    List<String> strings = new ArrayList<>();
    strings.add("Hello");
    strings.add("Hello 2");
    Validate.containsNoNulls(strings, "no null value");
    assertTrue(true);
  }
  //endregion

  //region contains no nulls or empty
  @Test(expected = NullPointerException.class)
  public void containsNoNullsOrEmptyValitadionWithNulls() throws Exception {
    List<String> strings = new ArrayList<>();
    strings.add(null);
    strings.add("Hello");
    Validate.containsNoNullOrEmpty(strings, "null value");
  }

  @Test(expected = IllegalArgumentException.class)
  public void containsNoNullsOrEmptyValitadionWithEmpty() throws Exception {
    List<String> strings = new ArrayList<>();
    strings.add("Hello");
    strings.add("");
    Validate.containsNoNullOrEmpty(strings, "empty value");
  }

  @Test
  public void containsNoNullsValitadionWithoutNullsOrEmpty() throws Exception {
    List<String> strings = new ArrayList<>();
    strings.add("Hello");
    strings.add("Hello 2");
    Validate.containsNoNullOrEmpty(strings, "no null neither empty value");
    assertTrue(true);
  }
  //endregion

  //region Empty or null
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyOrnullValidationWithEmpty() throws Exception {
    List<String> strings = new ArrayList<>();
    Validate.notEmptyAndContainsNoNulls(strings, "Test Empty");
  }

  @Test(expected = NullPointerException.class)
  public void testEmptyOrnullValidationWithNulls() throws Exception {
    List<String> strings = new ArrayList<>();
    strings.add(null);
    Validate.notEmptyAndContainsNoNulls(strings, "Test contains null");
  }

  @Test
  public void testEmptyOrnullValidationSuccess() throws Exception {
    List<String> strings = new ArrayList<>();
    strings.add("Hello");
    strings.add("Hello 2");
    Validate.notEmptyAndContainsNoNulls(strings, "Test Success");
    assertTrue(true);
  }
  //endregion

  //region Applivery Sdk Initialized
  @Test(expected = AppliverySdkNotInitializedException.class)
  public void tryToTestSdkInitialize() throws Exception {
    Validate.sdkInitialized();
  }
  //endregion

  //region Internet Permissions
  @Test(expected = NullPointerException.class)
  public void tryCheckInternetPermissionsWithNullContext() throws Exception {
    Validate.hasInternetPermissions(null);
  }
  //endregion


  @Test(expected = IllegalStateException.class)
  public void shouldThrowExceptionCheckInternetPermissionsWithContextNotNullAndNoPermission() throws Exception {
    when(context.checkCallingOrSelfPermission(isA(String.class))).thenReturn(-1);
    Validate.hasInternetPermissions(context);
  }

  @Test
  public void shouldNotThrowExceptionCheckInternetPermissionsWithContextNotNullAndNoPermissionButFlagDisabled(){
    when(context.checkCallingOrSelfPermission(isA(String.class))).thenReturn(-1);
    Validate.hasInternetPermissions(context, false);
    assertTrue(true);
  }

  @Test
  public void tryCheckInternetPermissionsWithContextAndPermission() {
    when(context.checkCallingOrSelfPermission(isA(String.class))).thenReturn(1);
    Validate.hasInternetPermissions(context);
    assertTrue(true);
  }



}
