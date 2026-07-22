*** Settings ***

Library    AppiumLibrary

*** Variables ***

${camposenha}                       //android.widget.EditText
${botaoacessarconta}                //android.widget.ScrollView/android.view.View[1]/android.widget.Button
${bntEsqueciSenha}                  //android.widget.ScrollView/android.view.View[2]/android.widget.Button
${toastusuariosenhainvalidos}       //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_subtitle"]
${mensagemUsuarioSenhaInvalidos}    Usuário ou senha inválidos.
${bntOkToastUserSenhaInvalido}      //android.widget.Button[@resource-id="br.com.quantaPrevidencia.homolog:id/button_acessarconta"]
