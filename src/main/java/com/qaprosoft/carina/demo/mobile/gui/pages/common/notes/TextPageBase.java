package com.qaprosoft.carina.demo.mobile.gui.pages.common.notes;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TextPageBase extends AbstractPage {

    public TextPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();
}
