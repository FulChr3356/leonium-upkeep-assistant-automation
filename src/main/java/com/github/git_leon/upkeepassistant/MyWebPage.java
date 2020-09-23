package com.github.git_leon.upkeepassistant;

import com.git_leon.leonium.browsertools.WebPage;
import com.git_leon.leonium.browsertools.browserhandler.BrowserHandler;
import com.git_leon.leonium.browsertools.browserhandler.BrowserHandlerInterface;
import com.git_leon.leonium.browsertools.browserhandler.logging.BrowserHandlerLoggerImpl;
import org.openqa.selenium.WebDriver;

abstract public class MyWebPage extends WebPage {
    public MyWebPage(WebDriver driver) {
        super(new BrowserHandlerLoggerImpl(driver));
    }
}
