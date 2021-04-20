package com.qaprosoft.carina.demo.mobile.gui.pages.android.notes.modal;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.notes.TextPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.TextPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.modal.TypeOfDocPageBase;
import org.openqa.selenium.WebDriver;

public class TypeOfDocPage extends TypeOfDocPageBase {

    @ExtendedFindBy(androidUIAutomator = "UiSelector().textMatches(\".*Text\")")
    private ExtendedWebElement text;

    @ExtendedFindBy(androidUIAutomator = "UiSelector().textMatches(\".*Checklist\")")
    private ExtendedWebElement checkList;

    @ExtendedFindBy(androidUIAutomator = "UiSelector().resourceidMatches(\".*id/alertTitle)")
    private ExtendedWebElement title;

    public TypeOfDocPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TextPageBase choseTextTypeOfDoc() {
        text.click();
        return initPage(getDriver(), TextPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }


}
