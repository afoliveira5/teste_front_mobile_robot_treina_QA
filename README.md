# Automação Mobile — treinaQA (Robot Framework + Appium)

Projeto de testes do app **treinaQA** (`com.treinaqa.app`) com Robot Framework e Appium.

## Pré-requisitos

- Python 3.6+
- Node.js + Appium + driver UiAutomator2
- Android SDK / dispositivo ou emulador
- Robot Framework (`pip install -r requirements.txt`)

## Instalação

```bash
pip install -r requirements.txt
npm install
```

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

## Credenciais demo (seed do app)

- E-mail: `teste@gmail.com`
- Senha: `Test@mobi2024`

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
