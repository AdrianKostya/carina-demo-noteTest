package com.qaprosoft.carina.demo.mobile.gui.pages.ios.notes.modal;

import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.TextPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.notes.modal.TypeOfDocPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.constant.ProjectConstant;
import org.openqa.selenium.WebDriver;

 class TypeOfDocPage extends TypeOfDocPageBase {

    public TypeOfDocPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TextPageBase choseTextTypeOfDoc() {
      throw new UnsupportedOperationException(ProjectConstant.UNIMPLEMENTED_FOR_IOS);
    }

     @Override
     public boolean isPageOpened() {
         throw new UnsupportedOperationException(ProjectConstant.UNIMPLEMENTED_FOR_IOS);
     }
 }
