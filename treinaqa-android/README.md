# treinaQA Android (APK nativo)

App **Android nativo** do treinaQA — **Kotlin + Jetpack Compose + Room**.

**Não é WebView.** É um APK real, com UI nativa e banco local (offline).

- Package: `com.treinaqa.app`
- Usuário seed: `teste@gmail.com` / `Test@mobi2024`
- Seletores Appium: [`SELETORES.md`](./SELETORES.md)

---

## Pré-requisitos

| Item | Observação |
|------|------------|
| [Android Studio](https://developer.android.com/studio) | Inclui SDK + JBR (Java) |
| Celular Android com **Depuração USB** | Ou emulador AVD |
| `adb` no PATH | Vem em `Android/Sdk/platform-tools` |

No celular: **Configurações → Opções do desenvolvedor → Depuração USB** (ligada).

Confira o aparelho:

```bash
adb devices
```

Deve aparecer algo como `RX8TB06JANE    device`.

---

## Como gerar o APK

### Opção A — Android Studio (recomendado)

1. Abra a pasta `treinaqa-android` no **Android Studio**
2. Aguarde o **Gradle Sync**
3. Menu **Build → Build Bundle(s) / APK(s) → Build APK(s)**
4. APK gerado em:

```text
treinaqa-android/app/build/outputs/apk/debug/app-debug.apk
```

### Opção B — linha de comando (Windows)

```bat
cd treinaqa-android
set JAVA_HOME=C:\Program Files\Android\Android Studio\jbr
gradlew.bat assembleDebug
```

APK em: `app\build\outputs\apk\debug\app-debug.apk`

---

## Como instalar no celular

Com o celular conectado via USB e autorizado:

```bat
adb install -r app\build\outputs\apk\debug\app-debug.apk
```

Ou apontando o serial do aparelho:

```bat
adb -s SEU_SERIAL install -r app\build\outputs\apk\debug\app-debug.apk
```

`-r` reinstala mantendo dados (atualiza o app).

Depois abra o app **treinaQA** no aparelho.

---

## Capabilities Appium (exemplo)

```json
{
  "platformName": "Android",
  "appium:automationName": "UiAutomator2",
  "appium:udid": "SEU_SERIAL",
  "appium:appPackage": "com.treinaqa.app",
  "appium:appActivity": "com.treinaqa.app.MainActivity",
  "appium:appWaitActivity": "*",
  "appium:noReset": true
}
```

Os `resource-id` dos campos/botões estão em `SELETORES.md` (ex.: `loginEmail`, `botaoEntrar`, `tituloCadastro`, `tituloMarca`).

---

## Telas

Login · Cadastro · Esqueci senha · Meus Dados · Atualizar dados · Exclusão

---

## Estrutura

```text
treinaqa-android/
├── app/src/main/java/com/treinaqa/app/
│   ├── data/       # Room + Repository
│   ├── domain/     # Validators
│   └── ui/         # Compose + seletores
├── SELETORES.md
└── README.md
```
