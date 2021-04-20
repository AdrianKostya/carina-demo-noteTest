package com.qaprosoft.carina.demo.mobile.gui.pages.ios.notes;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.LearnPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.MainPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.constant.ProjectConstant;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LearnPageBase.class)
public class LearnPage extends LearnPageBase {
    public LearnPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isWelcomeArrowPresent() {
        throw new UnsupportedOperationException(ProjectConstant.UNIMPLEMENTED_FOR_IOS);
    }

    @Override
    public void clickWelcomeArrow() {
        throw new UnsupportedOperationException(ProjectConstant.UNIMPLEMENTED_FOR_IOS);
    }

    @Override
    public void choseAllowAccessPhotos() {
        throw new UnsupportedOperationException(ProjectConstant.UNIMPLEMENTED_FOR_IOS);
    }

    @Override
    public boolean isAllowAcesPhotosBtnPresent() {
        throw new UnsupportedOperationException(ProjectConstant.UNIMPLEMENTED_FOR_IOS);
    }

    @Override
    public boolean isWelcomeSkipBtnPresent() {
        throw new UnsupportedOperationException(ProjectConstant.UNIMPLEMENTED_FOR_IOS);
    }

    @Override
    public void clickWelcomeSkipBtn() {
        throw new UnsupportedOperationException(ProjectConstant.UNIMPLEMENTED_FOR_IOS);
    }

    @Override
    public void skipToMainPage() {
        throw new UnsupportedOperationException(ProjectConstant.UNIMPLEMENTED_FOR_IOS);
    }

    @Override
    public boolean isPageOpened() {
        throw new UnsupportedOperationException(ProjectConstant.UNIMPLEMENTED_FOR_IOS);
    }
}
