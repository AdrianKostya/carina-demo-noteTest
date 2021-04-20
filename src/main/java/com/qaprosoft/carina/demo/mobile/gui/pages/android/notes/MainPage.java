package com.qaprosoft.carina.demo.mobile.gui.pages.android.notes;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.MainPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.modal.TypeOfDocPageBase;
import org.openqa.selenium.WebDriver;

public class MainPage extends MainPageBase {

    @ExtendedFindBy(androidUIAutomator = "UiSelector.resourceIdMatches(\".*id/main_btn1\")")
    private ExtendedWebElement createDocTopBtn;

    @ExtendedFindBy(androidUIAutomator = "UiSelector.resouceIdMatches(\".*img_add\")")
    private ExtendedWebElement createDocCenterBtn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TypeOfDocPageBase createNewDoc() {
        createDocTopBtn.click();
        return initPage(getDriver(), TypeOfDocPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return createDocTopBtn.isElementPresent();
    }
}
