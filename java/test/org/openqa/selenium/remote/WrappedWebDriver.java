package org.openqa.selenium.remote;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Interactive;
import org.openqa.selenium.interactions.Sequence;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class WrappedWebDriver implements WebDriver, JavascriptExecutor, TakesScreenshot, HasCapabilities, Interactive, WrapsDriver, WebStorage, HasDevTools {
    private final WebDriver delegate;

    public WrappedWebDriver(WebDriver delegate) {
      this.delegate = delegate;
    }

    public void additionalFunctionality() {
      System.out.println("Some additional functionality");
    }

    @Override
    public void get(String url) {
      delegate.get(url);
    }

    @Override
    public String getCurrentUrl() {
      return delegate.getCurrentUrl();
    }

    @Override
    public String getTitle() {
      return delegate.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
      return delegate.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
      return delegate.findElement(by);
    }

    @Override
    public String getPageSource() {
      return delegate.getPageSource();
    }

    @Override
    public void close() {
      delegate.close();
    }

    @Override
    public void quit() {
      delegate.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
      return delegate.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
      return delegate.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
      return delegate.switchTo();
    }

    @Override
    public Navigation navigate() {
      return delegate.navigate();
    }

    @Override
    public Options manage() {
      return delegate.manage();
    }

    @Override
    public Capabilities getCapabilities() {
      return ((HasCapabilities)delegate).getCapabilities();
    }

    @Override
    public Object executeScript(String script, Object... args) {
      return ((JavascriptExecutor) delegate).executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
      return ((JavascriptExecutor) delegate).executeAsyncScript(script, args);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
      return ((TakesScreenshot) delegate).getScreenshotAs(target);
    }

    @Override
    public WebDriver getWrappedDriver() {
      if (delegate instanceof WrapsDriver) {
        return ((WrapsDriver) delegate).getWrappedDriver();
      }
      return delegate;
    }

    @Override
    public Optional<DevTools> maybeGetDevTools() {
      return ((HasDevTools)delegate).maybeGetDevTools();
    }

    @Override
    public LocalStorage getLocalStorage() {
      return ((WebStorage)delegate).getLocalStorage();
    }

    @Override
    public SessionStorage getSessionStorage() {
      return ((WebStorage)delegate).getSessionStorage();
    }

    @Override
    public void perform(Collection<Sequence> actions) {
      ((Interactive)delegate).perform(actions);
    }

    @Override
    public void resetInputState() {
      ((Interactive)delegate).resetInputState();
    }
  }
