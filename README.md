# Automação Mobile — treinaQA (Robot Framework + Appium)

Bem-vindo ao repositório de testes do app **treinaQA** (`com.treinaqa.app`) com Robot Framework e Appium.

Repositório: https://github.com/afoliveira5/teste_front_mobile_robot_treina_QA

## Clone do projeto

```bash
git clone https://github.com/afoliveira5/teste_front_mobile_robot_treina_QA.git
```

## Pré-requisitos

- Python 3.6+
- Node.js + Appium + driver UiAutomator2
- Android SDK / dispositivo ou emulador
- Robot Framework (`pip install -r requirements.txt`)

Instale os itens abaixo antes de usar o projeto:

| Item | Link |
|------|------|
| Python 3.6 ou superior | https://www.python.org/downloads/ |
| Appium | https://appium.io/ |
| Android SDK | https://developer.android.com/studio |
| Node.js | https://nodejs.org/en/download |
| Visual Studio Code | https://code.visualstudio.com/download |

## Instalação

```bash
pip install -r requirements.txt
npm install
```

## Instalação das dependências

Após instalar os pré-requisitos, abra o terminal e execute:

```bash
pip install -r requirements.txt
npm install -g appium
npm install -g appium-uiautomator2-driver
pip install --upgrade robotframework-appiumlibrary
```

---

## App treinaQA Android (APK de treino)

O app nativo **treinaQA** (Kotlin + Jetpack Compose) está **neste repositório**, na pasta:

```text
treinaqa-android/
```

Serve para treinar automação mobile (Appium / Robot) com um app próprio, sem depender do app Quanta.

Documentação completa (gerar APK e instalar no celular):  
[`treinaqa-android/README.md`](./treinaqa-android/README.md)

### Resumo rápido — gerar e instalar o APK

1. Instale o [Android Studio](https://developer.android.com/studio)
2. Abra a pasta `treinaqa-android` no Android Studio e aguarde o Gradle Sync
3. **Build → Build Bundle(s) / APK(s) → Build APK(s)**
4. No celular, ative **Depuração USB** e conecte no PC
5. Confirme o aparelho: `adb devices`
6. Instale:

```bat
adb install -r treinaqa-android\app\build\outputs\apk\debug\app-debug.apk
```

- Package: `com.treinaqa.app`
- Versão atual do app: **1.2.0**
- Login seed: `teste@gmail.com` / `Test@mobi2024`
- Seletores: [`treinaqa-android/SELETORES.md`](./treinaqa-android/SELETORES.md)
- Rodapé: `Aplicativo criado pelo chefinho do teste Aparecido`

## APK

Coloque o caminho do APK em `Keywords_session.resource` (`${APP_PATH}`).

Exemplo:

```text
.../treinaqa-android/app/build/outputs/apk/debug/app-debug.apk
```

Instalar e abrir manualmente:

```bash
adb -s SEU_DEVICE install -r caminho/do/app-debug.apk
adb -s SEU_DEVICE shell am start -n com.treinaqa.app/.MainActivity
```

Se o app não estiver no device, a keyword `Garantir APK instalado` instala automaticamente ao iniciar a sessão.

## Capabilities

```json
{
  "platformName": "Android",
  "appium:deviceName": "RX8TB06JANE",
  "appium:platformVersion": "14.0",
  "appium:automationName": "UiAutomator2",
  "appium:appPackage": "com.treinaqa.app",
  "appium:appActivity": ".MainActivity",
  "appium:noReset": true,
  "appium:fullReset": false
}
```

## Ordem de execução

Siga os passos na ordem abaixo.

### 1. Iniciar o servidor Appium

```bash
appium
```

### 2. Verificar os emuladores (AVD) instalados

```bash
emulator -list-avds
```

### 3. Iniciar o emulador

```bash
emulator -avd NomeDoSeuEmulador
```

Exemplo:

```bash
emulator -avd Medium_Phone_API_25
```

### 4. Ajustar as capabilities

Altere o nome do dispositivo/emulador nas capabilities (pasta de resources/keywords da sessão):

```json
{
  "platformName": "Android",
  "appium:deviceName": "RX8TB06JANE",
  "appium:platformVersion": "14.0",
  "appium:automationName": "UiAutomator2",
  "appium:appPackage": "com.treinaqa.app",
  "appium:appActivity": ".MainActivity",
  "appium:noReset": true,
  "appium:fullReset": false
}
```

Exemplo de capabilities (JSON):

```json
{
  "platformName": "Android",
  "appium:deviceName": "RX8TB06JANE",
  "appium:platformVersion": "14.0",
  "appium:automationName": "UiAutomator2",
  "appium:appPackage": "com.treinaqa.app",
  "appium:appActivity": ".MainActivity",
  "appium:noReset": true,
  "appium:fullReset": false
}
```

### 5. Rodar a automação

```bash
robot -d results tests/
```

## Rodar testes

```bash
appium
robot -d results tests/login.robot
robot -d results tests/
```

## Estrutura

- `Keywords_session.resource` — sessão Appium + instalação do APK se necessário
- `keywords/` — login, cadastro, home, esqueci senha
- `variaveis/` — seletores dos testTags do Compose
- `tests/` — cenários do treinaQA
