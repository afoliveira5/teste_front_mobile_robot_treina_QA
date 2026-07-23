*** Settings ***

Library     AppiumLibrary
Library     Process
Library     OperatingSystem

*** Variables ***
${APPIUM_SERVER}        http://localhost:4723
${DEVICE_NAME}          RX8TB06JANE
${UDID}                 RX8TB06JANE
${ADB}                  adb
${APP_PATH}             C:${/}Users${/}aparecido.oliveira_s${/}Project${/}quanta${/}treinaqa-android${/}app${/}build${/}outputs${/}apk${/}debug${/}app-debug.apk
${APP_PACKAGE}          com.treinaqa.app
${APP_ACTIVITY}         .MainActivity

*** Keywords ***

APK esta instalado
    [Documentation]    Retorna True se o pacote existe no device.
    ${result}=    Run Process    ${ADB}    -s    ${UDID}    shell    pm    path    ${APP_PACKAGE}
    ...    shell=True
    ...    stdout=PIPE
    ...    stderr=PIPE
    ${saida}=    Catenate    SEPARATOR=    ${result.stdout}    ${result.stderr}
    ${instalado}=    Run Keyword And Return Status
    ...    Should Contain    ${saida}    package:
    RETURN    ${instalado}

Instalar APK
    [Documentation]    Instala (ou reinstala) o APK no device.
    File Should Exist    ${APP_PATH}
    Log    Instalando APK: ${APP_PATH}
    ${result}=    Run Process    ${ADB}    -s    ${UDID}    install    -r    ${APP_PATH}
    ...    shell=True
    ...    stdout=PIPE
    ...    stderr=PIPE
    ...    timeout=180s
    ${saida}=    Catenate    SEPARATOR=    ${result.stdout}    ${result.stderr}
    Should Contain    ${saida}    Success
    ...    msg=Falha ao instalar APK. Saída: ${saida}

Garantir APK instalado
    [Documentation]    Se o app não estiver no celular, instala antes da sessão.
    ${instalado}=    APK esta instalado
    IF    not ${instalado}
        Log    App ${APP_PACKAGE} não encontrado no device ${UDID}. Instalando...
        Instalar APK
    ELSE
        Log    App ${APP_PACKAGE} já está instalado em ${UDID}.
    END

Start session
    Garantir APK instalado
    Open Application    ${APPIUM_SERVER}
    ...                 platformName=Android
    ...                 deviceName=${DEVICE_NAME}
    ...                 udid=${UDID}
    ...                 automationName=UiAutomator2
    ...                 appPackage=${APP_PACKAGE}
    ...                 appActivity=${APP_ACTIVITY}
    ...                 appWaitActivity=*
    ...                 autoGrantPermissions=${True}
    ...                 noReset=${True}
    ...                 forceAppLaunch=${True}
    ...                 newCommandTimeout=${300}

swipe_down
    swipe by percent    50     50     50    70

swipe_up
    swipe by percent    2     50     0    0

Close session
    Close Application
