package com.qaprosoft.carina.demo.mobile.gui.pages.android.notes;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.LearnPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.MainPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LearnPageBase.class)
public class LearnPage extends LearnPageBase {

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*id/btn_start\")")
    private ExtendedWebElement welcomeArrow;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*id/permission_allow_button\")")
    private ExtendedWebElement accessPhotos;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().className(\"android.widget.Button\")")
    private  ExtendedWebElement welcomeSkipBtn;

    public LearnPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isWelcomeArrowPresent() {
        return welcomeArrow.isElementPresent();
    }

    @Override
    public void clickWelcomeArrow() {
        welcomeArrow.click();
    }

    @Override
    public void choseAllowAccessPhotos() {
        accessPhotos.click();
    }

    @Override
    public boolean isAllowAcesPhotosBtnPresent() {
       return accessPhotos.isElementPresent();
    }

    @Override
    public boolean isWelcomeSkipBtnPresent() {
        return welcomeSkipBtn.isElementPresent();
    }

    @Override
    public void clickWelcomeSkipBtn() {
        welcomeSkipBtn.click();
    }

    @Override
    public void skipToMainPage() {
        if(accessPhotos.isElementPresent()){

        }
    }

    @Override
    public boolean isPageOpened() {
        return accessPhotos.isElementPresent();
    }
}
