*** Settings ***

Library     AppiumLibrary

*** Keywords ***

Start session
    Open Application    http://localhost:4723
    ...                 platformName=Android
    ...                 deviceName=RX8TB06JANE
    ...                 automationName=UiAutomator2
    ...                 appPackage=br.com.quantaPrevidencia.debug
    ...                 appActivity=br.com.quantaPrevidencia.ui.splash.SplashActivity

swipe_down
    swipe by percent    50     50     50    70

swipe_up
    swipe by percent    2     50     0    0


Close session
    Close Application