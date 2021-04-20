package com.qaprosoft.carina.demo.mobile.gui.pages.android.notes;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.TextPageBase;
import org.openqa.selenium.WebDriver;

public class TextPage extends TextPageBase {

    @ExtendedFindBy(androidUIAutomator = "UiSelector().resourceIdMatches(\"*.id/edit_note\")")
    private ExtendedWebElement textField;

    public TextPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return textField.isElementPresent();
    }
}
