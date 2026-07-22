# Bem Vindo ao Repositorio de Automacao_Mobile_utilizando_Robot_FrameWork


## Faça o git clone
>```
>
>git clone git@bitbucket.org:seu-usuario/automacao_mobile_robot.git
>
>```

# Para poder utilizar o projeto e preciso Configurar os itens abaixo:

## Baixe Python 3.6 ou superior 
>```
>
> https://www.python.org/downloads/
>
>```
# Baixe Appium
>```
>
> https://appium.io/
>
>```

## Baixe Android SDK 
>```
>
>https://developer.android.com/studio
>
>```

# Baixe Node.js
>```
>
>https://nodejs.org/en/download
>
>```

# Baixe o Visual Studio Code 
>```
>
>https://code.visualstudio.com/download
>
>```

# Apos a instalacao dos itens, abrir cmd e rodar os seguintes comados:
>```
>
>pip install -r requirements.txt
>
>```

## Instalando o Appium
>```
>
>npm install -g appium
>
>```

# instalando Appium UIautomator2
>```
>
>npm install -g appium-uiautomator2-driver
>
>```

# Instalando Appium Library
>```
>
>pip install --upgrade robotframework-appiumlibrary                   
>
>```


# ================================================================================================================

# Observação:  Os passos a seguir deve ser seguido conforme a ordem que abaixo


## Para inicializar o servidor do Appium
>```
>
>appium
>
>```


## Verificar qual AVD voce tem instalado
>```
>
>emulator -list-avds
>
>```

## Rodar o emulador por liha de comando
>```
>
>emulator -avd[Nome do seu emulador]
>EXEMPLO DO MEU EMULADOR ==> emulator -avd Medium_Phone_API_25  
>
>```

## Rodar automação via linha de comando
>```
>
>
>```

# OBSERVAÇÃO 2: Não se esqueça de alterar o nome do seu EUMLADOR NO CAPABILITIES que fica na pasta RESOURCE > KEYWORDS.
>```
>
>platformName=Android
> =====> deviceName=Medium_Phone_API_25 "MUDE nome do seu emulador aqui" 
>automationName=UiAutomator2
>appPackage=br.com.quantaPrevidencia.homolog
>appActivity=br.com.quantaPrevidencia.ui.splash.SplashActivity
>
>```
![rodando automaçao robot](https://github.com/user-attachments/assets/f10e5ad4-96c5-4ae3-9898-ddb54bbad39c)


#teste
>{
 > "platformName": "Android",
  >"appium:automationName": "UiAutomator2",
  >"appium:udid": "RX8TB06JANE",
  >"appium:appPackage": "br.com.quantaPrevidencia.debug",
  >"appium:appActivity": "br.com.quantaPrevidencia.ui.splash.SplashActivity",
  >"appium:appWaitActivity": "*",
  >"appium:appWaitDuration": 60000
>}
>```
